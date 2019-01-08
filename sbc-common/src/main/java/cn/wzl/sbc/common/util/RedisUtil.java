package cn.wzl.sbc.common.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by 99410 on 2018/12/23.
 */
@Component
public class RedisUtil {
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 添加一个string键值对
     *
     * @param key
     * @param value
     */
    public void add(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据key获取一个值
     *
     * @param key
     * @return
     */
    public Object getByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 添加一个string键值对,带超时时间
     *
     * @param key
     * @param value
     */
    public void addWithTime(String key, Object value, Long time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    /**
     * 给指定key的值加1
     *
     * @param key
     */
    public void addOne(String key, Long num) {
        redisTemplate.opsForValue().increment(key, num);
    }

    /**
     * 根据key删除redis的键值对
     *
     * @param key
     */
    public void delByKey(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 给指定键重新设置超时时间
     *
     * @param key
     * @param timeOut
     * @param timeUnit
     */
    public void addOutTime(String key, Long timeOut, TimeUnit timeUnit) {
        redisTemplate.expire(key, timeOut, timeUnit);
    }
}
