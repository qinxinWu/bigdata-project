package pku.qingxin.dataproducer.bean;


import pku.qingxin.common.bean.DataIn;
import pku.qingxin.common.bean.DataOut;
import pku.qingxin.common.bean.Producer;
import pku.qingxin.common.util.DateUtil;
import pku.qingxin.common.util.NumberUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author qingxin
 * @create 2020-05-01 16:25
 */
public class CallLogProducer implements Producer{
    //数据来源
    private DataIn dataIn;
    //数据输出
    private DataOut dataOut;

    private volatile boolean flag = true;

    //设置数据来源
    public void setIn(DataIn in) {
        dataIn = in;
    }
    //设置数据输出
    public void setOut(DataOut out) {
        dataOut = out;
    }
    //生产通话记录数据
    public void produce() {
        try {
            //从联系人文件中获取数据

            List<Contact> contacts = dataIn.read(Contact.class);

            while (flag) {
                //从联系人文件中随机抽取两人，用于生产一条通话记录（区分主叫、被叫）
                    int call1Index = new Random().nextInt(contacts.size());
                    int call2Index;
                    while (true){
                        call2Index = new Random().nextInt(contacts.size());
                        if(call2Index != call1Index){
                            break;
                        }
                    }
                    Contact call1 = contacts.get(call1Index);
                    Contact call2 = contacts.get(call2Index);
                //随机生成通话时间
                String startDate = "20170101000000";
                String endDate = "20190101000000";

                long startTime = DateUtil.parse(startDate,"yyyyMMddHHmmss").getTime();
                long endTime = DateUtil.parse(endDate,"yyyyMMddHHmmss").getTime();

                long callTime = startTime + (long) ((endTime - startTime) * Math.random());
                String callTimeString = DateUtil.format(new Date(callTime),"yyyyMMddHHmmss");



                //随机生成通话时长
                String duration = NumberUtil.format(new Random().nextInt(3600),4);

                //拼接成完整通话记录
                CallLog callLog = new CallLog(call1.getTel(),call2.getTel(),callTimeString,duration);

                //System.out.println(callLog.toString());
                //将通话记录写到通话记录日志文件中
                dataOut.write(callLog);

                Thread.sleep(100);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        if(dataIn != null){
            dataIn.close();
        }
        if(dataOut != null){
            dataOut.close();
        }
    }
}
