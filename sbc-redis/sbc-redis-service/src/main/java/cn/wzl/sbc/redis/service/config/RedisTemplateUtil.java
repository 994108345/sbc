package cn.wzl.sbc.redis.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by 99410 on 2018/10/30.
 */
public class RedisTemplateUtil {

    @Autowired
    private static RedisTemplate<String,String> redisTemplate;

    /**
     * 给对应key设置值（String结构）
     * @param key
     * @param value
     */
    public static void addStr(String key,String value){
        redisTemplate.opsForSet().add(key,value);
    }

    /**
     * 根据key设置值和超时时间（String结构）
     * @param key
     * @param value
     * @param time
     * @param type
     */
    public static void addStrAndTime(String key,String value,int time,TimeUnit type){
        redisTemplate.opsForValue().set(key,value,time,type);
    }
    /**
     * 根据对应key获取值（String结构）
     * @param key
     * @return
     */
    public static String getStr(String key){
        String result = redisTemplate.opsForValue().get(key);
        return result;
    }
}
