package com.tulin.order.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;


//@Configuration全局配置,不使用局部配置
//@Configuration
//局部配置两种方式，配置类与配置文件
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {

        return Logger.Level.FULL;

    }
}