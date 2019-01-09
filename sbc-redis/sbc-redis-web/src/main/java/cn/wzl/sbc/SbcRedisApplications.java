package cn.wzl.sbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

/**
 * @Author wzl
 * @Date 2019/1/9 17:30
 * @doc SbcRedisApplications
 **/
public class SbcRedisApplications {
    private final static Logger log = LoggerFactory.getLogger(SbcRedisApplications.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(SbcRedisApplications.class, args);
            System.out.println("sbc-redis-run-success");
        } catch (Exception e) {
            log.error("sbc-redis-run-erroe",e);
        }
    }
}
