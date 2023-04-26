package com.tulin.order.api;


import org.springframework.stereotype.Component;

@Component
public class StockFeignServiceFallback implements StockOpenFeignService {
    @Override
    public String reduct2() {
        return "降级啦！！！！";
    }
}
