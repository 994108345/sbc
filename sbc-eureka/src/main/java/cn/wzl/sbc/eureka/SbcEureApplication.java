package cn.wzl.sbc.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by 99410 on 2018/10/17.
 */
@SpringBootApplication
/**@EnableEurekaServer该注解，意思为：该类为eureka注册中心*/
@EnableEurekaServer
public class SbcEureApplication {
    private final static Logger log = LoggerFactory.getLogger(SbcEureApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(SbcEureApplication.class, args);
            System.out.println("sbc-eureka-success");
        } catch (Exception e) {
            log.error("sbc-eureka-erroe",e);
        }
    }

}
