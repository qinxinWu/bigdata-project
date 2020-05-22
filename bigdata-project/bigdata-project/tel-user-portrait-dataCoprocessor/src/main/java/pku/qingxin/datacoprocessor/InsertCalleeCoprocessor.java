package pku.qingxin.datacoprocessor;

import pku.qingxin.common.bean.BaseDao;
import pku.qingxin.common.constant.Names;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Durability;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.regionserver.wal.WALEdit;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * 1、创建类
 * 2、让表添加协处理器
 * 3、将项目打成jar包发布到hbase中（包括关联的jar包），并且需要分发到各个集群服务器上
 * 使用协处理器插入被呼叫用户的数据
 * @author qingxin
 * @create 2020-05-06 10:46
 */
public class InsertCalleeCoprocessor extends BaseRegionObserver{


    //在保存呼叫者用户数据之后触发，用于自动保存被呼叫者用户的数据
    @Override
    public void postPut(ObserverContext<RegionCoprocessorEnvironment> e, Put put, WALEdit edit, Durability durability) throws IOException {
        //super.postPut(e, put, edit, durability);
        Table table = e.getEnvironment().getTable(TableName.valueOf(Names.TABLE.getValue()));

        String rowkey = Bytes.toString(put.getRow());
        //1-133-2018-155-0201-1
        String[] splits = rowkey.split("-");
        String call1 = splits[1];
        String call2 = splits[3];
        String calltime = splits[2];
        String duration = splits[4];
        String flag = splits[5];

        //只有呼叫用户数据被保存后才触发
        if ("1".equals(flag)){
            CoprocessorDao coprocessorDao = new CoprocessorDao();
            //插入被呼叫者记录
            //统计某个用户某个月的业务
            //rowkey的设计：唯一性、散列性、长度性
            //String calleeRowKey = genericRegionNum(call2,calltime)+"-"+call2+"-"+calltime+"-"+call1+"-"+duration +"-" +"0";
            String calleeRowKey = coprocessorDao.getRegionNum(call2,calltime)+"-"+call2+"-"+calltime+"-"+call1+"-"+duration +"-" +"0";
            //封装数据对象
            Put calleePut = new Put(Bytes.toBytes(calleeRowKey));
            byte[] calleeFamily = Bytes.toBytes(Names.CF_CALLEE.getValue());
            calleePut.addColumn(calleeFamily,Bytes.toBytes("call1"),Bytes.toBytes(call2));
            calleePut.addColumn(calleeFamily,Bytes.toBytes("call2"),Bytes.toBytes(call1));
            calleePut.addColumn(calleeFamily,Bytes.toBytes("calltime"),Bytes.toBytes(calltime));
            calleePut.addColumn(calleeFamily,Bytes.toBytes("duration"),Bytes.toBytes(duration));
            calleePut.addColumn(calleeFamily,Bytes.toBytes("flag"),Bytes.toBytes("0"));

            table.put(calleePut);
            table.close();

        }



    }


    private class CoprocessorDao extends BaseDao{
        public int getRegionNum(String tel,String time){
            return genericRegionNum(tel,time);

        }

    }
}
