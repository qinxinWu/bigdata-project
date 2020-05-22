package pku.qingxin.dataproducer;

import pku.qingxin.common.bean.Producer;
import pku.qingxin.dataproducer.bean.CallLogProducer;
import pku.qingxin.dataproducer.io.CallLogDataIn;
import pku.qingxin.dataproducer.io.CallLogDataOut;

/**
 * 引导初始化对象
 * @author qingxin
 * @create 2020-05-01 16:20
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception{
        if(args.length < 2){
            System.out.println("传入的路径参数不正确，必须传入两个路径参数（输入路径、输出路径）：path1 path2");
            System.exit(1);
        }

        //创建生产者对象
        Producer producer = new CallLogProducer();
        //用于模拟产生通话记录的联系人文件
        //producer.setIn(new CallLogDataIn("E:\\Bachelor\\graduation\\contact.log"));
        producer.setIn(new CallLogDataIn(args[0]));
        //模拟产生的通话记录日志文件
        //producer.setOut(new CallLogDataOut("E:\\Bachelor\\graduation\\call.log"));
        producer.setOut(new CallLogDataOut(args[1]));


        //生产数据
        producer.produce();

        //关闭生产者对象
        producer.close();
    }
}
