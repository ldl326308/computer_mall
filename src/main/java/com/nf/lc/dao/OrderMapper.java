package com.nf.lc.dao;

import com.nf.lc.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    Order selectByPrimaryKey(Integer orderId);

    Order selectByOrderNumber(String orderNumber);

    List<Order> selectAllIsUserId(int userId);

    int updateByPrimaryKey(Order record);

    List<Order> selectAllIsOrderState(@Param("orderState") int orderState);

    int selectAllIsOrderStateCount(@Param("orderState") int orderState);

    int updateByOrderNumberIsState(String orderNumber);

}