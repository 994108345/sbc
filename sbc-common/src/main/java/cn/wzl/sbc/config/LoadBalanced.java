package cn.wzl.sbc.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**通过代码的方式自定义负责均衡策略时需要注意的是，注意避免SpringBoot的包扫描，
 * 因为自定义的规则必须在Eureka的规则实例化以后再实例化才会生效
 * Created by 99410 on 2018/10/18.
 */
@Configuration
public class LoadBalanced {
    @Bean
    public IRule ribbonRule() {
        //return new RoundRobinRule();                //轮询
        // return new WeightedResponseTimeRule();    //加权权重
        //return new RetryRule();                    //带有重试机制的轮训
        return new RandomRule();                   //随机
        //return new MyBalanceRule();                     //自定义规则
    }
}
