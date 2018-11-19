package cn.wzl.sbc.redis.build;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author user
 * @Date 2018/11/16 10:21
 **/

@SpringBootApplication
@EnableEurekaClient
public class SbcRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbcRedisApplication.class,args);
    }
}
