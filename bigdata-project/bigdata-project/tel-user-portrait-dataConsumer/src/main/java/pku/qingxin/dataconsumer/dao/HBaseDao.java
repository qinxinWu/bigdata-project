package pku.qingxin.dataconsumer.dao;

import pku.qingxin.common.bean.BaseDao;
import pku.qingxin.common.constant.Names;
import pku.qingxin.common.util.DateUtil;
import pku.qingxin.dataconsumer.bean.CallLog;
import pku.qingxin.dataconsumer.bean.CalleeLog;
import pku.qingxin.dataconsumer.bean.CallerLog;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Hbase的数据访问对象
 * @author qingxin
 * @create 2020-05-03 10:20
 */
public class HBaseDao extends BaseDao{

    //初始化
    public void init() throws Exception{
        start();

        //createNamespaceNX(Names.NAMESPACE.getValue());

        //createTableXX(Names.TABLE.getValue(),"csu.qingxin.datacoprocessor.InsertCalleeCoprocessor" , ValueConstrant.REGION_COUNT,Names.CF_CALLER.getValue(),Names.CF_CALLEE.getValue());


        //end();

    }


    //插入数据2.0:插入对象
    public void insertData(CallLog callLog) throws Exception{
        String call1 = callLog.getCall1();
        String call2 = callLog.getCall2();
        String calltime = callLog.getCalltime();
        String duration = callLog.getDuration();
        String rowKey = genericRegionNum(call1,calltime)+"-"+call1+"-"+calltime+"-"+call2+"-"+duration;
        callLog.setRowkey(rowKey);

        putData(callLog);

    }

    //插入数据2.0:插入caller对象
    public void insertCallerData(CallerLog callerLog) throws Exception{
        String call1 = callerLog.getCall1();
        String call2 = callerLog.getCall2();
        String calltime = callerLog.getCalltime();
        String duration = callerLog.getDuration();
        String rowKey = genericRegionNum(call1,calltime)+"-"+call1+"-"+calltime+"-"+call2+"-"+duration+"-"+"1";
        callerLog.setRowkey(rowKey);

        putData(callerLog);

    }

    //插入数据2.0:插入callee对象
    public void insertCalleeData(CalleeLog calleeLog) throws Exception{
        String call1 = calleeLog.getCall1();
        String call2 = calleeLog.getCall2();
        String calltime = calleeLog.getCalltime();
        String duration = calleeLog.getDuration();
        String rowKey = genericRegionNum(call1,calltime)+"-"+call1+"-"+calltime+"-"+call2+"-"+duration+"-"+"0";
        calleeLog.setRowkey(rowKey);

        putData(calleeLog);

    }






    //插入数据
    public void insertData(String value) throws Exception{
        //获取通话记录日志
        String[] splits = value.split("\t");
        if(splits[0].contains("19644749833") || splits[1].contains("19644749833")){
            return;
        }
        String call1 = splits[0];
        String call2 = splits[1];
        String calltime = splits[2];
        String duration = splits[3];


        //插入呼叫者记录
        //统计某个用户某个月的业务
        //rowkey的设计：唯一性、散列性、长度性
        String callerRowKey = genericRegionNum(call1,calltime)+"-"+call1+"-"+calltime+"-"+call2+"-"+duration +"-"+"1";
        //封装数据对象
        Put callerPut = new Put(Bytes.toBytes(callerRowKey));
        byte[] callerFamily = Bytes.toBytes(Names.CF_CALLER.getValue());
        callerPut.addColumn(callerFamily,Bytes.toBytes("call1"),Bytes.toBytes(call1));
        callerPut.addColumn(callerFamily,Bytes.toBytes("call2"),Bytes.toBytes(call2));
        callerPut.addColumn(callerFamily,Bytes.toBytes("calltime"),Bytes.toBytes(calltime));
        callerPut.addColumn(callerFamily,Bytes.toBytes("duration"),Bytes.toBytes(duration));
        callerPut.addColumn(callerFamily,Bytes.toBytes("flag"),Bytes.toBytes("1"));


       /* //插入被呼叫者记录
        //统计某个用户某个月的业务
        //rowkey的设计：唯一性、散列性、长度性
        String calleeRowKey = genericRegionNum(call2,calltime)+"-"+call2+"-"+calltime+"-"+call1+"-"+duration +"-" +"0";
        //封装数据对象
        Put calleePut = new Put(Bytes.toBytes(calleeRowKey));
        byte[] calleeFamily = Bytes.toBytes(Names.CF_CALLEE.getValue());
        calleePut.addColumn(calleeFamily,Bytes.toBytes("call1"),Bytes.toBytes(call2));
        calleePut.addColumn(calleeFamily,Bytes.toBytes("call2"),Bytes.toBytes(call1));
        calleePut.addColumn(calleeFamily,Bytes.toBytes("calltime"),Bytes.toBytes(calltime));
        calleePut.addColumn(calleeFamily,Bytes.toBytes("duration"),Bytes.toBytes(duration));
        calleePut.addColumn(calleeFamily,Bytes.toBytes("flag"),Bytes.toBytes("0"));

*/

        //将通话记录日志保存到Hbase中
        List<Put> puts = new ArrayList<Put>();
        puts.add(callerPut);
       // puts.add(calleePut);
        putData2(Names.TABLE.getValue(),puts);


        //putData(Names.TABLE.getValue(),puts);

    }

    //获取某个某个用户某个月到某个月的业务查询时的startrow和srow集合
    protected List<String[]> getMonthStartStopRowkeysp(String tel,String start,String end){
        List<String[]> rowkeyss = new ArrayList<String[]>();
        String startTime = start.substring(0, 6);
        String endTime = end.substring(0, 6);

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(DateUtil.parse(startTime,"yyyyMM"));

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(DateUtil.parse(endTime,"yyyyMM"));

        while (startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()){
            //当前时间
            String nowTime = DateUtil.format(startCalendar.getTime(), "yyyyMM");

            int regionNum = genericRegionNum(tel, nowTime);

            String startRow = regionNum + "-" + tel + "-" + nowTime;
            String stopRow = startRow + "|";

            String[] rowkeys = {startRow,stopRow};
            rowkeyss.add(rowkeys);

            //月份+1
            startCalendar.add(Calendar.MONTH,1);

        }


        return rowkeyss;
    }


    /*public static void main(String[] args) {
        for(String[] strings : getMonthStartStopRowkeysp("13323456789","201803","201808")){
            System.out.println(strings[0]+"~"+strings[1]);

        }
    }*/
}
