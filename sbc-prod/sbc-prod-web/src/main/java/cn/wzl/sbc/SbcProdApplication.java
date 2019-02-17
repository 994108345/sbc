package cn.wzl.sbc;

import cn.wzl.sbc.common.util.SpringBeanUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author wzl
 * @Date 2019/1/9 17:30
 * @doc SbcRedisApplications
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.wzl.sbc.prod.dao.mapper")
@PropertySource({"classpath:sql.properties"})
@Import(SpringBeanUtil.class)
public class SbcProdApplication {
    private final static Logger log = LoggerFactory.getLogger(SbcProdApplication.class);
    public static void main(String[] args) {
        try {
            SpringApplication.run(SbcProdApplication.class, args);
            System.out.println("sbc-prod-run-success");
        } catch (Exception e) {
            log.error("sbc-prod-run-erroe",e);
        }
    }
}
