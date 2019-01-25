package cn.wzl.sbc.redis.test;

import cn.wzl.sbc.RedisApplication;
import cn.wzl.sbc.common.KafkaCallBack;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest(classes= RedisApplication.class)
public class KafkaDemoTest {
    @Resource
    private KafkaTemplate kafkaTemplate;

    @Test
    public void sendMessage(){
        try {
            kafkaTemplate.setProducerListener(new KafkaCallBack());
            kafkaTemplate.send("1a1","12341253454345345453");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }

    @KafkaListener(topics= {"a7"})
    public void listenA (ConsumerRecord<?,?> record){
        System.out.println("kafka的key---: " + record.key());
        System.out.println("kafka的value---: " + record.value().toString());
    }
}
