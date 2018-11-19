package cn.wzl.sbc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by 99410 on 2018/10/17.
 */
@SpringBootApplication
/* @EnableEurekaServer该注解，意思为：该类为eureka注册中心*/
@EnableEurekaServer
public class SbcEureApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbcEureApplication.class, args);
    }
}
