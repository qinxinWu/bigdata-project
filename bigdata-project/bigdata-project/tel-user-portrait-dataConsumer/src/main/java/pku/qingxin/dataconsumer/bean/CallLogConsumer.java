package pku.qingxin.dataconsumer.bean;

import pku.qingxin.common.bean.Consumer;
import pku.qingxin.common.constant.Names;
import pku.qingxin.dataconsumer.dao.HBaseDao;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * 通话记录日志消费者对象
 * @author qingxin
 * @create 2020-05-02 10:58
 */
public class CallLogConsumer implements Consumer{
    //消费数据
    public void consume() {
        try {

            //创建配置对象
            Properties properties = new Properties();
            /*properties.setProperty("bootstrap.servers","192.168.60.101:9092");
            properties.setProperty("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
            properties.setProperty("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
            properties.setProperty("group.id","qingxin");
            properties.setProperty("enable.auto.commit","true");
            properties.setProperty("auto.commit.interval.ms","1000");*/


            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("dataConsumer.properties"));


            //获取Flume采集的数据
            KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(properties);

            //关注主题
            consumer.subscribe(Arrays.asList(Names.TOPIC.getValue()));

            //Hbase的数据访问对象
            HBaseDao hBaseDao = new HBaseDao();
            //初始化
            hBaseDao.init();

            //消费数据
            while(true){
                ConsumerRecords<String,String> consumerRecords = consumer.poll(100);
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    if(consumerRecord.value().contains("19644749833")){
                        continue;
                    }
                    System.out.println(consumerRecord.value());
                    //向Hbase中插入数据
                   hBaseDao.insertData(consumerRecord.value());

                    //hBaseDao.insertData(consumerRecord.value());
                    //CallLog callLog = new CallLog(consumerRecord.value());
                    //hBaseDao.insertData(callLog);

                    /*CallerLog callerLog = new CallerLog(consumerRecord.value());
                    hBaseDao.insertCallerData(callerLog);*/
                    //System.out.println(consumerRecord.value());

                  /*  CalleeLog calleeLog = new CalleeLog(consumerRecord.value());
                    hBaseDao.insertCalleeData(calleeLog);*/


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //关闭资源
    public void close() throws IOException {

    }
}
