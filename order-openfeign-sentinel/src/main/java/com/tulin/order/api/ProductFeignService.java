package com.tulin.order.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="product-service",path="/product")
public interface ProductFeignService {

    //必须指定@PathVariable("id")中的值
    @RequestMapping("/{id}}")
    public String get(@PathVariable("id") Integer id) ;


}
