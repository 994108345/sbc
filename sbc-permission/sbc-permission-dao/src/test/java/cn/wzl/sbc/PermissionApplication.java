package cn.wzl.sbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Properties;

/**
 * Description: manage启动类
 *
 * @author Liujy On 2018/9/4.
 * @version 1.0
 * @since JDK 1.8
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("cn.wzl.sbc.permission.dao.mapper")
public class PermissionApplication {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(PermissionApplication.class.getResourceAsStream("/log4j.properties"));
            properties.load(PermissionApplication.class.getResourceAsStream("/sql.properties"));

            SpringApplication app = new SpringApplication(PermissionApplication.class);
            app.setDefaultProperties(properties);
            app.run(args);
            System.out.println("success");
        } catch (Exception ex) {
            System.out.println("Fail to start ManageApplication due to exception:" + ex.toString());
        }
    }
}
