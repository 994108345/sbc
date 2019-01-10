package cn.wzl.sbc;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

/**
 * @Author wzl
 * @Date 2019/1/9 17:30
 * @doc SbcRedisApplications
 **/
@SpringBootApplication
/**该类为eureka的服务中心*/
@EnableEurekaClient
@MapperScan("cn.wzl.sbc.redis.dao.mapper")
@PropertySource({"classpath:sql.properties","classpath:param.properties"})
/*关联我们写的均衡负载类*/
@RibbonClient(name = "sbc-permission", configuration = cn.wzl.sbc.config.LoadBalanced.class)
public class RedisApplication {
    private final static Logger log = LoggerFactory.getLogger(RedisApplication.class);
    public static void main(String[] args) {
        try {
            SpringApplication.run(RedisApplication.class, args);
            System.out.println("sbc-redis-run-success");
        } catch (Exception e) {
            log.error("sbc-redis-run-erroe",e);
        }
    }
}
