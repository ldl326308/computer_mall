package com.nf.lc.service;

import com.nf.lc.dao.ShoppingCartMapper;
import com.nf.lc.entity.ShoppingCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration("/spring/spring-dao.xml")
public class ShoppingCartServiceTest {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setComputerCount(1);
        shoppingCart.setUserId(1);
        shoppingCart.setComputerId(2);
        shoppingCartMapper.insert(shoppingCart);
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void updateByPrimaryKey() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setShoppingId(1);
        shoppingCart.setComputerCount(9);
        shoppingCart.setUserId(1);
        shoppingCart.setComputerId(2);
        shoppingCartMapper.updateByPrimaryKey(shoppingCart);
    }
}