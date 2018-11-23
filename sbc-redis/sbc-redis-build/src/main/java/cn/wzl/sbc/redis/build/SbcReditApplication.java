package cn.wzl.sbc.redis.build;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author user
 * @Date 2018/11/20 11:34
 **/
@SpringBootApplication
@EnableEurekaClient
public class SbcReditApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbcReditApplication.class, args);
    }
}
