package cn.wzl.sbc.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * Created by 99410 on 2018/10/19.
 */
public class MyBalanceRule implements IRule {
    private ILoadBalancer loadBalancer;

    @Override
    /*均衡负载的逻辑*/
    public Server choose(Object o) {
        List<Server> servers= loadBalancer.getAllServers();
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.loadBalancer=iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.loadBalancer;
    }
}
