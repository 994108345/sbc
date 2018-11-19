package cn.wzl.sbc.redis.service.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 99410 on 2018/10/30.
 */
@Repository
public class RedisTemplateUtil<T> {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /*public void add(String key,Long time,T t){
        redisTemplate.opsForValue().set(key, JSONObject.toJSONString(t),time, TimeUnit.MINUTES);
    }

    public T get(String key){
        T user = null;
        String userJson = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(userJson)){
            user = JSONObject.parseObject(userJson,T.class);

        }
        return user;
    }

    public List<T> getList(String key){
        List<T> ts = null;
        String listJson = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(listJson)){
            ts = JSONObject.parseArray(listJson,T.class);
        }
        return ts;
    }

    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }*/

}
