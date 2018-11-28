package com.nf.lc.service;

import com.nf.lc.dao.OrderMapper;
import com.nf.lc.entity.Order;
import com.nf.lc.service.impl.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements OrderServiceImp {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public Order selectByPrimaryKey(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }
}
