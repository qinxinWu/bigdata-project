package pku.qingxin.common.bean;

import pku.qingxin.common.api.Column;
import pku.qingxin.common.api.RowKey;
import pku.qingxin.common.api.TableRef;
import pku.qingxin.common.constant.Names;
import pku.qingxin.common.constant.ValueConstrant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 基本的数据访问对象
 * @author qingxin
 * @create 2020-05-03 10:18
 */
public abstract class BaseDao {
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
    private ThreadLocal<Admin> adminConnectionThreadLocal = new ThreadLocal<Admin>();


    protected void start() throws Exception{
        getConnection();
        getAdmin();
    }

    protected void end() throws Exception{
        Admin admin = getAdmin();
        if( admin != null){
            admin.close();
            adminConnectionThreadLocal.remove();
        }

        Connection connection = getConnection();
        if(connection != null){
            connection.close();
            connectionThreadLocal.remove();
        }
    }


    //获取连接对象
    protected synchronized Connection getConnection() throws Exception{
        Connection connection = connectionThreadLocal.get();
        if( connection == null){
            Configuration configuration = HBaseConfiguration.create();
            connection = ConnectionFactory.createConnection(configuration);
            connectionThreadLocal.set(connection);

        }
        return connection;
    }

    //获取管理对象
    protected synchronized Admin getAdmin() throws Exception{
        Admin admin = adminConnectionThreadLocal.get();
        if( admin == null){
            admin = getConnection().getAdmin();
            adminConnectionThreadLocal.set(admin);
        }
        return admin;
    }

    //创建命名空间。若没有则创建，有则不创建
    protected void createNamespaceNX(String namespace) throws Exception{
        Admin admin = getAdmin();

        try {
            admin.getNamespaceDescriptor(namespace);
        } catch (NamespaceNotFoundException e) {
            //e.printStackTrace();
            NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(namespace).build();
            admin.createNamespace(namespaceDescriptor);
        }
    }

    //创建新表，已有则覆盖
    protected void createTableXX(String name,String... families) throws Exception{
       createTableXX(name,null,null,families);
        }

    //创建新表，已有则覆盖
    protected void createTableXX(String name,String coprocessorClass,Integer regionCount,String... families) throws Exception{
        Admin admin = getAdmin();
        TableName tableName = TableName.valueOf(name);

        if(admin.tableExists(tableName)){
            //表存在则删除表
            deleteTable(name);
        }

        //创建表
        createTable(name,coprocessorClass,regionCount,families);

    }





    //创建表
    private void createTable(String name,String coprocessorClass,Integer regionCount,String... families) throws Exception{
        Admin admin = getAdmin();
        TableName tableName = TableName.valueOf(name);

        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);

        if(families == null || families.length == 0){
            families = new String[1];
            families[0] = Names.CF_INFO.getValue();
        }

        for (String family : families) {
            HColumnDescriptor columnDescriptor = new HColumnDescriptor(family);
            hTableDescriptor.addFamily(columnDescriptor);
        }

        //增加协处理器
        if(coprocessorClass != null && !"".equals(coprocessorClass)){
            hTableDescriptor.addCoprocessor(coprocessorClass);

        }


        //增加预分区

        if(regionCount == null || regionCount <=1){
            admin.createTable(hTableDescriptor);
        }else {
            //分区键
            byte[][] splitKeys =genericSplitKeys(regionCount);
            admin.createTable(hTableDescriptor,splitKeys);


        }


    }



    //让同一个人同一个月的通话记录放在同一个分区，提高查询速率
    protected int genericRegionNum(String tel,String date){
        //取电话号码后四位
        String telSubstring = tel.substring(tel.length() - 4);

        //取年月
        String dateSubstring = date.substring(0, 6);

        int telHash = telSubstring.hashCode();
        int dateHash = dateSubstring.hashCode();

        //crc校验采用异或算法
        int crc = Math.abs(telHash ^ dateHash);

        //对所有分区数 取模
        int regionNum = crc % ValueConstrant.REGION_COUNT;

        return regionNum;

    }


    //生成分区键
    private byte[][] genericSplitKeys(Integer regionCount) {
        int splitKeyCount = regionCount - 1;

        byte[][] bytes = new byte[splitKeyCount][];
        //0|,1|,2|,...
        //(-∞，0|） [0|,1|)  [1|，+∞）
        List<byte[]> byteList = new ArrayList<byte[]>();
        for (int i = 0;i < splitKeyCount;i++){
            String splitKey = i + "|";

           // System.out.println(splitKey);

            byteList.add(Bytes.toBytes(splitKey));
        }

        byteList.toArray(bytes);
        return bytes;
    }

    //插入数据
    protected void putData(String name, Put put) throws Exception{
        //获取表对象
        Connection connection = getConnection();
        Table table = connection.getTable(TableName.valueOf(name));
        //增加数据
        table.put(put);
        //关闭表
        table.close();
    }

    //插入多条数据
    protected void putData(String name, List<Put> puts) throws Exception{
        //获取表对象
        Connection connection = getConnection();
        Table table = connection.getTable(TableName.valueOf(name));
        //增加数据
        table.put(puts);
        //关闭表
        table.close();
    }

    //插入多条数据
    protected void putData2(String name, List<Put> puts) throws Exception{
        Connection connection = getConnection();
        BufferedMutator mutator = null;
        TableName tName = TableName.valueOf(name);
        BufferedMutatorParams params = new BufferedMutatorParams(tName);
        params.writeBufferSize(1*1024*1024); // 可以自己设定阈值 5M 达到5M则提交一次
        try
        {
            mutator = connection.getBufferedMutator(params);
            mutator.mutate(puts); // 数据量达到5M时会自动提交一次
            mutator.flush(); // 手动提交一次
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(mutator != null)mutator.close();  // 提交一次
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            //end();
        }
    }



    //插入对象
    protected void putData(Object object) throws Exception{
        //反射获取对应的表名
        Class clazz = object.getClass();
        TableRef tableRef = (TableRef) clazz.getAnnotation(TableRef.class);
        String tableName = tableRef.value();
        //反射获取rowkey
        Field[] declaredFields = clazz.getDeclaredFields();
        String strRowkey = "";
        for (Field declaredField : declaredFields) {
            RowKey rowKey = declaredField.getAnnotation(RowKey.class);
            if(rowKey != null){
                declaredField.setAccessible(true);
                strRowkey = (String) declaredField.get(object);
                break;
            }
        }
        //获取表对象
        Connection connection = getConnection();
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(Bytes.toBytes(strRowkey));

        for (Field declaredField : declaredFields) {
            Column column = declaredField.getAnnotation(Column.class);
            if(column != null){
                String family = column.family();
                String columnName = column.column();
                if(columnName == null || "".equals(columnName)){
                        columnName = declaredField.getName();
                }
                declaredField.setAccessible(true);
                String value= (String)declaredField.get(object);

                put.addColumn(Bytes.toBytes(family),Bytes.toBytes(columnName),Bytes.toBytes(value));

            }

        }

        //增加数据
        table.put(put);
        //关闭表
        table.close();
    }








    //删除表
    protected void deleteTable(String name) throws Exception{
        TableName tableName = TableName.valueOf(name);
        Admin admin = getAdmin();
        admin.disableTable(tableName);
        admin.deleteTable(tableName);
    }


   /* public static void main(String[] args) {
        System.out.println(genericRegionNum("13145678901","20180601123023"));
    }
*/







}
