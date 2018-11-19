package cn.wzl.sbc.redis.service;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @Author user
 * @Date 2018/11/19 11:13
 **/
public class TokenRedis {
    @Resource
    private StringRedisTemplate redisTemplate;

    public void setRedisTemplate(){

    }
}
