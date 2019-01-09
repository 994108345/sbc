package cn.wzl.sbc.common.util;

import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by 99410 on 2018/12/23.
 */
@Component
public class RedisUtil {
    @Resource
    private RedisTemplate redisTemplate;


    /*-------------------------------------------string-----------------------------------------------*/

    /**
     * 添加一个string键值对
     *
     * @param key
     * @param value
     */
    public void add(Object key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据key获取一个值
     *
     * @param key
     * @return
     */
    public Object getByKey(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 添加一个string键值对,带超时时间
     *
     * @param key
     * @param value
     */
    public void addWithTime(Object key, Object value, Long time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    /**
     * 给指定key的值加1
     *
     * @param key
     */
    public void addOne(Object key, Long num) {
        redisTemplate.opsForValue().increment(key, num);
    }

    /*----------------------------------------------hash------------------------------------------------------------*/

    /**
     * 存一个hash的键值对
     *
     * @param key
     * @param hashMap
     */
    public void hPutAll(Object key, Map hashMap) {
        redisTemplate.opsForHash().putAll(key, hashMap);
    }

    /**
     * 取一个hash的键值对
     *
     * @param key
     * @return
     */
    public Map hGetByKey(Object key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取hash类型的所有键
     *
     * @param pattern
     * @return
     */
    public Set hKeys(Object pattern) {
        return redisTemplate.opsForHash().keys(pattern);
    }
    /*----------------------------------------------list------------------------------------------------------------*/

    /**
     *  获取list类型的键值对
     * @param key
     * @return
     */
    public List lGetByKey(Object key) {
        return null;
    }

    /*----------------------------------------------set------------------------------------------------------------*/

    /**
     * 添加一个Set结构的键值对
     *
     * @param key
     * @return
     */
    public Long sSet(Object key,Object[] objs){
        Long count = redisTemplate.opsForSet().add(key,objs);
        return count;
    }

    /**
     * 获取set结果的一个键值对
     * @param key
     * @return
     */
    public Set sGetByKey(Object key){
        Set set = redisTemplate.opsForSet().members(key);
        return set;
    }

    /*----------------------------------------------zset------------------------------------------------------------*/

    /**
     * 新增一个set集合
     * @param key
     * @param objs
     * @return
     */
    public Long zSets(Object key ,Set<ZSetOperations.TypedTuple> objs){
       return redisTemplate.opsForZSet().add(key,objs);
    }

    /**
     * 往指定key 的集合中插入一条数据，存在就更新，不存在就插入
     * @param key
     * @param obj
     * @param d
     * @return
     */
    public Boolean zSet(Object key ,Object obj ,Double d){
        return redisTemplate.opsForZSet().add(key,obj,d);
    }


    /*----------------------------------------------通用------------------------------------------------------------*/
    /**
     * 根据key删除redis的键值对
     *
     * @param key
     */
    public void delByKey(Object key) {
        redisTemplate.delete(key);
    }

    /**
     * 给指定键重新设置超时时间
     *
     * @param key
     * @param timeOut
     * @param timeUnit
     */
    public void addOutTime(Object key, Long timeOut, TimeUnit timeUnit) {
        redisTemplate.expire(key, timeOut, timeUnit);
    }

    /**
     * 获取与之匹配的keys
     *
     * @return
     */
    public Set<Object> keysAll(Object pattern) {
        Set<Object> keySet = redisTemplate.keys(pattern);
        return keySet;
    }

    /**
     * 获取key的数据类型
     *
     * @param key
     * @return
     */
    public String getTypeOfKey(Object key) {
        DataType dataType = redisTemplate.type(key);
        String type = dataType.name();
        return type;
    }


}
