package pku.qingxin.dataconsumer;

import pku.qingxin.common.bean.Consumer;
import pku.qingxin.dataconsumer.bean.CallLogConsumer;

/**
 * 初始化启动数据消费者
 * 使用kafka消费者获取Flume框架采集的数据，将数据存储到Hbase中
 * @author qingxin
 * @create 2020-05-02 10:50
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception{

        //创建消费者
        Consumer consumer = new CallLogConsumer();

        //消费数据
        consumer.consume();

        //关闭资源
        consumer.close();

    }
}
