package com.nf.lc.service;

import com.nf.lc.entity.Order;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;

import java.util.List;

public interface OrderService {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record) throws FailureException;

    Order selectByPrimaryKey(Integer orderId) throws EmptyException;

    Order selectByOrderNumber(String orderNumber) throws EmptyException;

    List<Order> selectAllIsUserId(int userId) throws EmptyException;

    int updateByPrimaryKey(Order record);

    List<Order> selectAllIsOrderState(int orderState) throws EmptyException;

    int selectAllIsOrderStateCount(int orderState);

    int updateByOrderNumberIsState(String orderNumber) throws FailureException;
}
