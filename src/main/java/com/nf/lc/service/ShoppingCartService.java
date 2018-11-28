package com.nf.lc.service;

import com.nf.lc.dao.ShoppingCartMapper;
import com.nf.lc.entity.ShoppingCart;
import com.nf.lc.service.impl.ShoppingCartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService implements ShoppingCartServiceImp {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;


    @Override
    public int deleteByPrimaryKey(Integer shoppingId) {
        return shoppingCartMapper.deleteByPrimaryKey(shoppingId);
    }

    @Override
    public int insert(ShoppingCart record) {
        return shoppingCartMapper.insert(record);
    }

    @Override
    public ShoppingCart selectByPrimaryKey(Integer shoppingId) {
        return shoppingCartMapper.selectByPrimaryKey(shoppingId);
    }

    @Override
    public List<ShoppingCart> selectAll() {
        return shoppingCartMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ShoppingCart record) {
        return shoppingCartMapper.updateByPrimaryKey(record);
    }
}
