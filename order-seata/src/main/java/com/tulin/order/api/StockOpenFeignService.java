package com.tulin.order.api;


import com.tulin.order.api.fallback.StockOpenFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//整合sentinel只能做服务降级，流控任然需要@SentinelResource
//@FeignClient(value="stock-seata",path="/stock",fallback = StockOpenFeignServiceFallback.class)
//开启openfeign降级服务，@GlobalTransactional会失效
@FeignClient(name="stock-seata",path="/stock")
public interface StockOpenFeignService {


    @RequestMapping("/reduct")
    public String reduct(@RequestParam(value = "productId") Integer productId) ;
}
