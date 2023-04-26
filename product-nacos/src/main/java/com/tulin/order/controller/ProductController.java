package com.tulin.order.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {


    @Value("${server.port}")
    String port;


    @RequestMapping("/{id}}")
    public String get(@PathVariable Integer id) {
        System.out.println("查询商品id");
        return "查询商品"+id+":"+port;
    }
}
