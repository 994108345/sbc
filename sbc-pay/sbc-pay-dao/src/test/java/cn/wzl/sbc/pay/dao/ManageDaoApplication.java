package cn.wzl.sbc.pay.dao;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.Properties;

/**
 * Description: manage启动类
 *
 * @author waw
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.wzl.sbc.pay.dao.mapper","classpath:mapper/*.xml"})
@ComponentScan(basePackages = {"cn.wzl.sbc.pay.dao.bean"})
public class ManageDaoApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ManageDaoApplication.class);
    }
}

