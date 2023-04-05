package com.jayning.lowercode.lowercodeportal.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Random;

/**
 * desc: 自定义负载均衡策略
 * createBy: Ningjianjian
 */
@Slf4j
public class MyRule extends AbstractLoadBalancerRule {

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null){
            return null;
        }
        if (key == null) {
            return null;
        }
        Server server = null;
        while(server == null){
            //表示启动的服务列表.(默认情况下单纯只用Ribbon时，不会对目标服务做心跳检测）
            List<Server> upList = lb.getReachableServers();
            //所有服务列表
            List<Server> allList = lb.getAllServers();
            int serverCount = upList.size();
            if(serverCount == 0){
                return null;
            }
//            int index = ipAddressHash(serverCount);
            int index = randomIndex(serverCount);
            log.info("index = " + index);
            server=upList.get(index);
        }
        return server;
    }

    private int randomIndex(int serverCount) {
        return new Random().nextInt(serverCount);
    }

    private int ipAddressHash(int serverCount){
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String remoteAddr=requestAttributes.getRequest().getRemoteAddr();
        int code=Math.abs(remoteAddr.hashCode());
        return code%serverCount;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
