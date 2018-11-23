package cn.wzl.sbc.pay.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author user
 * @Date 2018/11/20 11:34
 **/
@SpringBootApplication
@EnableEurekaClient
public class SbcPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbcPayApplication.class, args);
    }
}
