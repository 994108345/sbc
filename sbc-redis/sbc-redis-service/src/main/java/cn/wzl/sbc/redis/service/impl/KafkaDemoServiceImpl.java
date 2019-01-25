package cn.wzl.sbc.redis.service.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.redis.service.KafkaDemoService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class KafkaDemoServiceImpl implements KafkaDemoService {
    @Resource
    private KafkaTemplate kafkaTemplate;


    @Override
    public MessageResult getTopics() {
        return null;
    }
}
