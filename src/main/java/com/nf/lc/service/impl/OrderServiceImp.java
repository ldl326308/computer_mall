package com.nf.lc.service.impl;

import com.github.pagehelper.PageHelper;
import com.nf.lc.dao.OrderMapper;
import com.nf.lc.dao.ShoppingCartMapper;
import com.nf.lc.entity.Order;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public int deleteByPrimaryKey(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Order record) throws FailureException {
        record.setOrderNumber(UUID.randomUUID().toString());
        try {
            //生成订单
            int count = orderMapper.insert(record);
            if (count > 0) {
                //修改购物车状态
                int state = shoppingCartMapper.updateByPrimaryKeyIsState(record.getShoppingCartId());
                return count;
            }


        } catch (Exception e) {
            throw new FailureException("添加到订单失败了！");
        }
        throw new FailureException("添加到订单失败了！");
    }

    @Override
    public Order selectByPrimaryKey(Integer orderId) throws EmptyException {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(order == null){
            throw new EmptyException("没有找到该订单号信息！");
        }
        return order;
    }

    @Override
    public Order selectByOrderNumber(String orderNumber) throws EmptyException {
        Order order = orderMapper.selectByOrderNumber(orderNumber);
        if(order == null){
            throw new EmptyException("没有找到该订单号信息！");
        }
        return order;
    }

    @Override
    public List<Order> selectAllIsUserId(int userId) throws EmptyException {
        List<Order> orders = orderMapper.selectAllIsUserId(userId);
        if(orders.size() == 0){
            throw new EmptyException("没有订单信息哦！");
        }
        return orders;
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Order> selectAllIsOrderState(int orderState) throws EmptyException {
        List<Order> orders = orderMapper.selectAllIsOrderState(orderState);
        if(orders.size() ==0){
            throw new EmptyException("没有查询到订单数据！");
        }
        return orders;
    }

    @Override
    public int selectAllIsOrderStateCount(int orderState) {
        return orderMapper.selectAllIsOrderStateCount(orderState);
    }

    @Override
    public int updateByOrderNumberIsState(String orderNumber) throws FailureException {
        int count = orderMapper.updateByOrderNumberIsState(orderNumber);
        if(count > 0){
            return count;
        }
        throw new FailureException("修改操作失败了！");
    }
}
