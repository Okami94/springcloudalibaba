package com.tulin.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
       String msg= restTemplate.getForObject("http://stock-service/stock/reduct",String.class);
        return "hello world"+msg;
    }

    @RequestMapping("/header")
    public String header(@RequestHeader("X-Request-color")  String color) {

        return color;
    }



    @RequestMapping("/err")
    public String err() {
        int a=2/0;
        return "hello";
    }


    @RequestMapping("/get")
    public String get() {
        System.out.println("查询成功");
        return "查询成功";
    }

    //QBS
    @RequestMapping("/flow")
    public String flow() {
        System.out.println("正常访问");
        return "正常访问";
    }


    //线程数
    @RequestMapping("/flowThread")
    public String flowThread() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("正常访问");
        return "正常访问";
    }


    @RequestMapping("/get/{id}")
    public String getById(@PathVariable("id") Integer id){
        System.out.println("正常访问");
        return "正常访问";
    }


}
