package com.tulin.order.controller;


import com.tulin.order.api.ProductFeignService;
import com.tulin.order.api.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    StockFeignService stockFeignService;




    @Autowired
    ProductFeignService productFeignService;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        String msg = stockFeignService.reduct();

        String p = productFeignService.get(1);
        return "hello feign" + msg+p;
    }
}
