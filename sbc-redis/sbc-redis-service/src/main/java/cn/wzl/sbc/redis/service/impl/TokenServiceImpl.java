package cn.wzl.sbc.redis.service.impl;

import cn.wzl.sbc.common.result.CommonResult;
import cn.wzl.sbc.common.result.ResultConstant;
import cn.wzl.sbc.redis.service.TokenService;
import cn.wzl.sbc.redis.service.config.RedisTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author user
 * @Date 2018/11/20 10:50
 **/
@Service("tokenService")
public class TokenServiceImpl implements TokenService {

    private Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);

    @Value("${redis_token_name}")
    String tokenName;

    @Resource
    private StringRedisTemplate redis;


    @Override
    public CommonResult setToken(String token) {
        CommonResult result = new CommonResult();
        try {
            /*RedisTemplateUtil.addStr(tokenName,token);*/
            redis.opsForValue().set(tokenName,token);
        } catch (Exception e) {
            logger.error("tokenservice setToken has a error",e);
            result.setMessage(ResultConstant.MESSAGE.DEFAULT_ERROR_MESSAGE);
            result.setStatus(ResultConstant.CODE.ERROR);
            result.setException(e);
        }
        return result;
    }
}
