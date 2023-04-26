package com.tulin.order.controller;


import com.tulin.order.api.ProductFeignService;
import com.tulin.order.api.StockOpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {


    @Qualifier("com.tulin.order.api.StockOpenFeignService")
    @Autowired
    StockOpenFeignService stockOpenFeignService;




    @Autowired
    ProductFeignService productFeignService;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        String msg = stockOpenFeignService.reduct2();


        return "hello feign" + msg;
    }
}
