package com.tulin.order.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tulin.order.pojo.Order;
import com.tulin.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/add")
    //@SentinelResource(value = "add",blockHandler = "addBlockHandler")
    public String add() {
        Order order = new Order();
        order.setProductId((int)((Math.random()*9+1)*100000));
        order.setStatus(0);
        order.setTotalAmount(100);
        orderService.create(order);
        return "下单成功";
    }



    @RequestMapping("/test")
    //@SentinelResource(value = "test",blockHandler = "testblockHandler",fallback = "testFallback")
    public String test() {
        int a=2/0;
        return "下单成功";
    }


    public String testblockHandler(BlockException e){
        return "流控或降级";
    }

    public String testFallback(){
        return "除0异常";
    }


    public String addBlockHandler(@PathVariable("id") Integer id,BlockException e) {
        return "已被限制下单";
    }


    //@SentinelResource(value = "query",blockHandler = "queryBlockHandler")
    @RequestMapping("/query/{id}")
    public String query(@PathVariable("id") Integer id) {
        Order order = new Order();
        order.setProductId(id);
        List<Order> o = orderService.query(order);
        return "查询成功";
    }


    public String queryBlockHandler(@PathVariable("id") Integer id, BlockException e) {
        return "被流控了";

    }

    //@SentinelResource(value = "query",blockHandler = "queryBlockHandler")
    @RequestMapping("/all")
    public String all() {

        List<Order> o = orderService.queryAll();
        return "查询成功";
    }
}
