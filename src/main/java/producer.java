import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.*;
import java.util.Properties;

public class producer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","blackjack:9092");      //url server
        properties.put("acks","all");                          //消息确认机制
        properties.put("retries",0);                           //消息发送重复次数
        properties.put("batch.size",16384);                    //一批次发送多少条
        properties.put("linger.ms",1);                         //消息每条确认
        properties.put("buffer.memory",33554432);
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");



        Producer<String,String> kafkaProducer = new KafkaProducer<String,String>(properties);
        File file = new File("C:\\Users\\liuqi\\Desktop\\新建文件夹\\LJD8AC3F5L0000046_VDCM_1.6191634509E+12_58.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String Line=null;
        while ((Line= bufferedReader.readLine())!=""){
            if (!Line.equals("\t")){
                System.out.println(Line);
                Thread.sleep(100);
            }

        }

 //       kafkaProducer.send(new ProducerRecord<String,File>("tango",));
        for (int i = 1; i < 100; i++) {

            kafkaProducer.send(new ProducerRecord<String,String>("test","tango has "+i+" bergs~"));
            System.out.println(i);
        }
        kafkaProducer.close();
    }
}
