package cn.wzl.sbc;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

/**
 * Demo class
 * @author wenzailong
 * @date 2018/12/13
 */
@SpringBootApplication
/**该类为eureka的服务中心*/
@EnableEurekaClient
@MapperScan("cn.wzl.sbc.chatboard.dao.mapper")
@PropertySource("classpath:sql.properties")
public class SbcChatboardApplication {

    private final static Logger log = LoggerFactory.getLogger(SbcChatboardApplication.class);

    public static void main(String[] args) {

        try {
            SpringApplication.run(SbcChatboardApplication.class, args);
            System.out.println("sbc-permission-success");
        } catch (Exception e) {
            log.error("permission-run-erroe",e);
        }

    }
}
