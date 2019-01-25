package cn.wzl.sbc.permission.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service("kafkaService")
public class KafkaServiceImpl implements KafkaService {

    @KafkaListener(topics= {"1a1"})
    public void listenA (ConsumerRecord<?,?> record){
        System.out.println("kafka的key---: " + record.key());
        System.out.println("kafka的value---: " + record.value().toString());
    }
}
