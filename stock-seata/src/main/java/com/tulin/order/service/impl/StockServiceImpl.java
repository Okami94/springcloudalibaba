package com.tulin.order.service.impl;

import com.tulin.order.Mapper.StockMapper;
import com.tulin.order.service.StockService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockMapper stockMapper;


    @Override
    @GlobalTransactional
    public void reduct(Integer productId) {
        System.out.println("更新商品："+productId);
        stockMapper.reduct(productId);
    }
}
