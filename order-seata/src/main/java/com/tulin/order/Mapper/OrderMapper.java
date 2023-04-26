package com.tulin.order.Mapper;

import com.tulin.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderMapper {

    public void insert(Order order);

    public List<Order> query(Order order);

    public List<Order> queryAll();
}
