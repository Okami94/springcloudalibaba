package com.tulin.ribbon;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonRandomRuleConfig {


    @Bean
    //负载均衡策略随机
    public IRule iRule(){
        return new RandomRule();
    }
}
