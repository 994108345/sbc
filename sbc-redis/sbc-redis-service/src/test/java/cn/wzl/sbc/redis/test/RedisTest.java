package cn.wzl.sbc.redis.test;

import cn.wzl.sbc.common.result.CommonResult;
import cn.wzl.sbc.redis.base.WzlBaseTest;
import cn.wzl.sbc.redis.service.TokenService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Author user
 * @Date 2018/11/21 18:14
 **/
public class RedisTest extends WzlBaseTest {
    @Resource
    private TokenService tokenService;

    @Test
    public void tokenTest(){
        CommonResult result = tokenService.setToken("111111");
        System.out.println(result);
    }

}
