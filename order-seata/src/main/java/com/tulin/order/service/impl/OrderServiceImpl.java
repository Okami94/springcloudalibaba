package com.tulin.order.service.impl;

import com.tulin.order.Mapper.OrderMapper;
import com.tulin.order.api.StockOpenFeignService;
import com.tulin.order.pojo.Order;
import com.tulin.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderMapper OrderMapper;


    @Qualifier("com.tulin.order.api.StockOpenFeignService")
    @Autowired
    StockOpenFeignService stockOpenFeignService;

    @GlobalTransactional
    @Override
    //主键自增事务会失效
    public Order create(Order order) {
        OrderMapper.insert(order);
        stockOpenFeignService.reduct(order.getProductId());
        return order;

    }

    @Override
    @Trace
    @Tags({@Tag(key="Parm",value = "arg[0]") ,@Tag(key="result",value = "returnedObj")})
    public List<Order> query(Order order) {
        return OrderMapper.query(order);
    }

    @Override
    //自定义链路追中，追踪某个方法，用在service中
    @Trace
    //记录链路追踪返回值,key是调用方法，
    //arg[0]是返回参数
    //@Tag(key="queryAll",value = "arg[0]")
    //returnedObj是返回值
    @Tag(key="queryAll",value = "returnedObj")
    public List<Order> queryAll() {
        return OrderMapper.queryAll();
    }


}
