package com.tulin.order.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


//name 制定调用rest接口所对应的服务名
//path 制定调用rest接口所在controller制定的@RequestMapping
@FeignClient(value="stock-nacos",path="/stock",fallback = StockFeignServiceFallback.class)
public interface StockOpenFeignService {

    @RequestMapping("/reduct2")
    public String reduct2() ;




}


/*@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        String msg= restTemplate.getForObject("http://stock-service/stock/reduct",String.class);
        return "hello world"+msg;
    }
}*/
