package com.tulin.order.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tulin.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.TimeUnit;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

   //限流链路模式  start  调用sericve中的方法
    @RequestMapping("/test1")
    public String test1() {
        return orderService.getUser();

    }

    @RequestMapping("/test2")
    public String test2() {
        return orderService.getUser();
    }
    //限流链路模式 end

    @RequestMapping("/err")
    public String err() {
        int a=2/0;
        return "hello";
    }




    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        return "下单成功";
    }

    @RequestMapping("/get")
    public String get() {
        System.out.println("查询成功");
        return "查询成功";
    }

    //QBS
    @RequestMapping("/flow")
    //@SentinelResource(value = "flow",blockHandler = "blockHandlerFlow")
    public String flow() {
        System.out.println("正常访问");
        return "正常访问";
    }

   //BlockException e必须要加
    public String blockHandlerFlow(BlockException e) {
        System.out.println("流控");
        return "流控";
    }

    //线程数
    @RequestMapping("/flowThread")
    //@SentinelResource(value = "flowThread",blockHandler = "blockHandlerFlow")
    public String flowThread() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("正常访问");
        return "正常访问";
    }


    @RequestMapping("/get/{id}")
    @SentinelResource(value = "getById",blockHandler = "HotBlockHandler")
    public String getById(@PathVariable("id") Integer id){
        System.out.println("正常访问");
        return "正常访问";
    }


    public String HotBlockHandler(@PathVariable("id") Integer id,BlockException e){
        System.out.println("异常处理");
        return "异常处理";
    }

}
