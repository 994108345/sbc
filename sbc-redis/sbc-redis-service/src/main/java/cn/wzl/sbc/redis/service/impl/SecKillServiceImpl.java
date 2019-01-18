package cn.wzl.sbc.redis.service.impl;

import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.constant.RestConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.redis.service.SecKillService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wzl
 * @Date 2019/1/9 17:38
 * @doc SecKillServiceImpl
 **/
@Service("secKillService")
public class SecKillServiceImpl implements SecKillService{

    private final static Logger log = LoggerFactory.getLogger(SecKillServiceImpl.class);

    /**
     * redis是否已经存够秒杀够用的数据
     */
    private boolean isEnough = true;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Value("${permission.seckill.url}")
    private String SECKILL_URL;

    @Override
    public MessageResult secKill(UserInfo userInfo) {
        MessageResult result = new MessageResult();
        try {
            Long count = 0L;
            /*当redis数目够了,就不再往redis里存数据*/
            if(isEnough){
                /*往redis里存值，达到秒杀数后，开始操作数据库*/
                count = redisUtil.lsetLeft(RedisConstant.RedisKeys.SECKILL_KEY,userInfo.getUserName());
            }else{
                throw new Exception("不好意思，你没有秒杀成功，请下次再接再厉");
            }
            if(count == CommonConstant.CommonParam.SECKILL_COUNT){
                /*使用rest请求*/
                this.calculateCount();
                isEnough = false;
            }else if(count > CommonConstant.CommonParam.SECKILL_COUNT){
                isEnough = false;
                throw new Exception("不好意思，你没有秒杀成功，请下次再接再厉");
            }
        } catch (Exception e) {
            log.error("secKillService secKill:",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }

        return result;
    }

    /**
     * 开始请求清算模块，扣减秒杀数量
     * @return
     */
    private void calculateCount(){
        UserInfo userInfo = new UserInfo();
        List<String> list = redisUtil.lgetByRange(RedisConstant.RedisKeys.SECKILL_KEY,0,CommonConstant.CommonParam.SECKILL_COUNT-1);
        /*设置一个用户信息到redis，防止登陆拦截，找不到cookie*/
        redisUtil.add("secKill","seckill");
        list.forEach(userName ->{
            userInfo.setUserName(userName);
            /*设置请求头*/
            HttpHeaders headers = new HttpHeaders();
            /*设置cookie*/
            headers.set(RestConstant.REST_API_HEADER,"seckill");
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            /*转化json*/
            String userInfoJson = JSONObject.toJSONString(userInfo);
            JSONObject jsonObj = JSONObject.parseObject(userInfoJson);
            HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
            /*请求*/
            MessageResult seckillResult = (MessageResult) restTemplate.postForObject(SECKILL_URL,formEntity,MessageResult.class);
            if(seckillResult == null){
                throw new RuntimeException("扣减秒杀数量失败");
            }
            if(seckillResult.isError()){
                throw new RuntimeException("扣减秒杀数量失败");
            }
        });
    }

    @Override
    public MessageResult setIsEnough() {
        this.isEnough = true;
        return null;
    }

    @Override
    public MessageResult secKillByKafka(UserInfo userInfo) {
        kafkaTemplate.send("","","");
        return null;
    }
}
