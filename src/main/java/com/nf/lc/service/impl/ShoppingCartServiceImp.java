package com.nf.lc.service.impl;

import com.nf.lc.dao.ShoppingCartMapper;
import com.nf.lc.entity.ShoppingCart;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.exception.FrozenAccountsException;
import com.nf.lc.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImp implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;


    @Override
    public int deleteByPrimaryKey(Integer shoppingId) throws FrozenAccountsException {
        int count = shoppingCartMapper.deleteByPrimaryKey(shoppingId);
        if (count <= 0) {
            throw new FrozenAccountsException("移除失败！");
        }
        return count;
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
            shoppingCart.setComputerCount(shoppingCart.getComputerCount() + record.getComputerCount());
            if (shoppingCartMapper.updateByPrimaryKey(shoppingCart) < 0) {
                throw new FailureException("加入购物车时意外失败了，请重试！");
            }
        }
    }

    @Override
    public ShoppingCart selectByPrimaryKey(Integer shoppingId) {
        return shoppingCartMapper.selectByPrimaryKey(shoppingId);
    }

    @Override
    public List<ShoppingCart> selectAll(int userId) throws EmptyException {
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectAll(userId);
        if (shoppingCarts.size() == 0) {
            throw new EmptyException("购物车没有信息");
        }
        return shoppingCarts;
    }

    @Override
    public int updateByPrimaryKey(ShoppingCart record) throws FrozenAccountsException {
        int count = shoppingCartMapper.updateByPrimaryKey(record);
        if (count > 0) {
            return count;
        }
        throw new FrozenAccountsException("修改失败了，请重试！");
    }

    @Override
    public BigDecimal selectShoppingCartIsTotalPrice(String shoppingIds) throws EmptyException {
        if(shoppingIds.equals("") || shoppingIds == null){
            throw new EmptyException("没有选中");
        }

        String[] idsStr = shoppingIds.split(",");
        int[] idsInt = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            idsInt[i] = Integer.parseInt(idsStr[i]);
        }

        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectShoppingCartIsTotalPrice(idsInt);

        BigDecimal computerPrice = new BigDecimal(0);
        for (ShoppingCart shoppingCart : shoppingCarts) {
            BigDecimal count = new BigDecimal(shoppingCart.getComputerCount());
            BigDecimal price = shoppingCart.getComputerPrice();
            BigDecimal totalPrice = count.multiply(price);
            computerPrice = computerPrice.add(totalPrice);
        }
        return computerPrice;
    }

    @Override
    public List<ShoppingCart> selectShoppingCartIsIds(String shoppingIds, int currentId) throws EmptyException {
        if(shoppingIds.equals("") || shoppingIds == null){
            throw new EmptyException("没有选中");
        }

        String[] idsStr = shoppingIds.split(",");
        int[] idsInt = new int[idsStr.length];
        for (int i = 0; i < idsStr.length; i++) {
            idsInt[i] = Integer.parseInt(idsStr[i]);
        }

        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectAll(currentId);
        List<ShoppingCart> newShoppingCarts = new ArrayList<>();


        for (ShoppingCart shoppingCart : shoppingCarts) {
            for (int i = 0;i<idsInt.length;i++) {
                if(shoppingCart.getShoppingId() == idsInt[i]){
                    newShoppingCarts.add(shoppingCart);
                    break;
                }
            }
        }

        if(newShoppingCarts.size() == 0){
            throw new EmptyException("发生错误了，没有查询的数据！");
        }

        return newShoppingCarts;
    }
}
