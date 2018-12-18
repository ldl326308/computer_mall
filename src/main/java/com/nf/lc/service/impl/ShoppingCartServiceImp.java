package com.nf.lc.service.impl;

import com.nf.lc.entity.ShoppingCart;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.exception.FrozenAccountsException;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCartServiceImp {
    int deleteByPrimaryKey(Integer shoppingId) throws FrozenAccountsException;

    void insert(ShoppingCart record) throws FailureException;

    ShoppingCart selectByPrimaryKey(Integer shoppingId);

    List<ShoppingCart> selectAll(int userId) throws EmptyException;

    int updateByPrimaryKey(ShoppingCart record) throws FrozenAccountsException;

    BigDecimal selectShoppingCartIsTotalPrice(String shoppingIds) throws EmptyException;

    List<ShoppingCart> selectShoppingCartIsIds(String shoppingIds, int currentId) throws EmptyException;
}
