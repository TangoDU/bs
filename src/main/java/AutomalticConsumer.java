import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.record.Record;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class AutomalticConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();

        props.put("bootstrap.servers","slave1:9092");
        props.put("group.id","test_group");//消费组
        props.put("enable.auto.commit","true");//允许自动提交offset
        props.put("auto.commit.interval.ms","1000");//每隔多久自动提交offset
        props.put("session.timeout.ms","30000");
        //指定key,value的反序列化类
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<String,String>(props);

        //指定消费哪个topic里面的数据
        kafkaConsumer.subscribe(Arrays.asList("tango"));
        //使用死循环来消费test这个topic里面的数据


        while (true){
            System.out.println("---------------------------------------------------------------------");
            ConsumerRecords<String,String> consumerRecords = kafkaConsumer.poll(1000);

            for (ConsumerRecord<String,String> consumerRecord:consumerRecords) {
                long offset = consumerRecord.offset();
                String value = consumerRecord.value();
                System.out.println("消息的offset值为:"+offset+";"+"消息的value值"+value);

            }


        }




    }
}
