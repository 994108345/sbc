package cn.wzl.sbc.permission.service.systemparam.impl;

import cn.wzl.sbc.common.constant.KafkaConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.permission.dao.bean.SystemParamDao;
import cn.wzl.sbc.permission.service.systemparam.SystemParamService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2019/1/9 16:51
 * @doc SystemParamServiceImpl
 **/
@Service("systemParamService")
public class SystemParamServiceImpl implements SystemParamService {

    private static final Logger log = LoggerFactory.getLogger(SystemParamServiceImpl.class);

    @Resource
    private SystemParamDao systemParamDao;


    @Override
    public MessageResult secKill() {
        MessageResult result = new MessageResult();
        try {
            systemParamDao.updateSysparamOfSeckill();
        } catch (Exception e) {
            log.error("systemParamService secKill:",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @KafkaListener(topics=KafkaConstant.Topic.SECKILL_TOPIC)
    public void listenA (ConsumerRecord<?,?> record){
        log.info("kafka的key---: " + record.key());
        log.info("kafka的value---: " + record.value().toString());
    }


}
