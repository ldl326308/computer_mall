package com.nf.lc.service;

import com.nf.lc.dao.ShoppingCartMapper;
import com.nf.lc.entity.ShoppingCart;
import com.nf.lc.exception.FailureException;
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
    public void insert(ShoppingCart record) throws FailureException {
        //查询商品id 以及用户id一致的购物车数据
        ShoppingCart shoppingCart = shoppingCartMapper.selectShoppingCartIsComputerIdAndUserId(record);

        if (shoppingCart == null) {
            //不存在，添加新的数据
            if (shoppingCartMapper.insert(record) < 0) {
                throw new FailureException("加入购物车时意外失败了，请重试！");
            }
        } else { //存在，增加数量
            shoppingCart.setComputerCount(shoppingCart.getComputerCount() + 1);
            if(shoppingCartMapper.updateByPrimaryKey(shoppingCart)< 0){
                throw new FailureException("加入购物车时意外失败了，请重试！");
            }
        }


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
