package com.nf.lc.service.impl;

import com.nf.lc.dao.OrderMapper;
import com.nf.lc.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration("/spring/spring-dao.xml")
public class OrderServiceImpTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectAllIsUserId() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectAllIsOrderState() {
        List<Order> orders = orderMapper.selectAllIsOrderState(0);
        System.out.println(orders.size());
    }


    @Test
    public void selectAllIsOrderStateCount() {
    }
}