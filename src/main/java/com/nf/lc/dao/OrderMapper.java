package com.nf.lc.dao;

import com.nf.lc.entity.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectAllIsUserId(int userId);

    int updateByPrimaryKey(Order record);
}