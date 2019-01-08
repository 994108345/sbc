package cn.wzl.sbc.test;

import cn.wzl.sbc.SbcPermissionApplication;
import cn.wzl.sbc.common.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2019/1/8 17:10
 * @doc RedisUtilTest
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SbcPermissionApplication.class)
public class RedisUtilTest {

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void addTest(){
        try {
            redisUtil.add("1","momomomomom");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
