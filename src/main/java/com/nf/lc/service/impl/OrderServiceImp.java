package com.nf.lc.service.impl;

import com.nf.lc.entity.Order;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;

import java.util.List;

public interface OrderServiceImp {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record) throws FailureException;

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectAllIsUserId(int userId) throws EmptyException;

    int updateByPrimaryKey(Order record);
}
