package com.nf.lc.service.impl;

import com.nf.lc.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartServiceImp {
    int deleteByPrimaryKey(Integer shoppingId);

    int insert(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer shoppingId);

    List<ShoppingCart> selectAll();

    int updateByPrimaryKey(ShoppingCart record);
}
