package cn.wzl.sbc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wzl
 * @Date 2019/1/10 14:26
 * @doc RestConfig
 **/
@Configuration
public class RestConfig {
    @Bean
    /**
     * 开启均衡负载
     */
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
