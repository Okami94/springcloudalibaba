package com.tulin.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/config")
@RestController
@RefreshScope
public class ConfigController {


    @Value("${user.name}")
    String username;


    @RequestMapping("/show")
    public String show(){
        return username;
    }
}
