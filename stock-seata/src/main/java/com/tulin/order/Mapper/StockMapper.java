package com.tulin.order.Mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockMapper {

    public void reduct(Integer productId);

}
