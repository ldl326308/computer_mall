package com.nf.lc.service.impl;

import com.nf.lc.entity.Order;

import java.util.List;

public interface OrderServiceImp {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}
