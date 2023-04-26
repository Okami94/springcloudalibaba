package com.tulin.order.api.fallback;

import com.tulin.order.api.StockOpenFeignService;
import org.springframework.stereotype.Component;


@Component
public class StockOpenFeignServiceFallback implements StockOpenFeignService {
    @Override
    public String reduct(Integer productId) {
        return "代码报错";
    }
}
