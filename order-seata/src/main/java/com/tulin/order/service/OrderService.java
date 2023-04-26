package com.tulin.order.service;

import com.tulin.order.pojo.Order;

import java.util.List;

public interface OrderService {
    public Order create(Order order);

    public List<Order> query(Order order);


    public List<Order> queryAll();

}
