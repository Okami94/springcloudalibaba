package com.tulin.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tulin.order.service.IOrderService;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements IOrderService {
    @Override
    @SentinelResource(value  ="getUser",blockHandler = "blockHandlerGetUser")
    public String getUser() {
        return "查询用户";
    }

    public String blockHandlerGetUser(BlockException e) {
        return "流控用户";
    }
}
