package cn.wzl.sbc.common.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：wzl
 * @date ：Created in 2019/2/27 15:38
 * @description：编码生成工具类
 */
@Component
public class CodeUtil {

    @Resource
    private RedisUtil redisUtil;
    /**
     * 通过redis生成唯一的编码；规则为：种类+当前时间+当天redis的自增数
     * @param type 当前编码的种类
     * @return
     */
    public String createCodeByRedis(String type){
        Long num = redisUtil.addOne(type,1L);
        String code = type + num;
        return code;
    }
}
