import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class consumer {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.put("bootstrap.servers","slave1");
        prop.put("group.id","Arsenal");
        prop.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        prop.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> Consumer = new KafkaConsumer<>(prop);
        String topic = "tango";
        List<PartitionInfo> partitionInfos = Consumer.partitionsFor(topic);
        List<TopicPartition> topicPartitions = new ArrayList<>();

        Map<TopicPartition,Long> hashMap = new HashMap<>();
        DateFormat DateFormat = new SimpleDateFormat();

    //./kafka-console-consumer.sh --topic topicnamexxx --bootstrap-server 192.168.1.2:9092  --property print.timestamp=true --from-beginning |awk -F 'CreateTime:|\t' '$2>= 1614845604323 && $2 <= 1614845750416 {print $0}'

    }


    }

