package cn.wzl.sbc.common;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;

public class KafkaCallBack implements ProducerListener {

    private static final Logger log = LoggerFactory.getLogger(KafkaCallBack.class);
    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info(String.format("成功:主题为%s，key为$s,值为%s",producerRecord.topic(),producerRecord.key(),producerRecord.value()));
    }

    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        log.info(String.format("成功:主题为%s，key为$s,值为%s",topic,key,value));
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        log.info(String.format("失败:主题为%s，key为$s,值为%s",producerRecord.topic(),producerRecord.key(),producerRecord.value()));
    }

    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        log.info(String.format("失败:主题为%s，key为$s,值为%s",topic,key,value));
    }
}
