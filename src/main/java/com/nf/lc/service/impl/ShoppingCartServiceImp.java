package com.nf.lc.service.impl;

import com.nf.lc.entity.ShoppingCart;
import com.nf.lc.exception.FailureException;

import java.util.List;

public interface ShoppingCartServiceImp {
    int deleteByPrimaryKey(Integer shoppingId);

    void insert(ShoppingCart record) throws FailureException;

    ShoppingCart selectByPrimaryKey(Integer shoppingId);

    List<ShoppingCart> selectAll();

    int updateByPrimaryKey(ShoppingCart record);
}
