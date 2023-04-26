package com.tulin.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stock")
@RestController
public class StockController {


    @RequestMapping("/reduct")
    public String reduct(){
        System.out.println("扣减库存");
        return "扣减库存";
    }
}
