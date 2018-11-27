package com.nf.lc.entity;

public class ShoppingCart {
    private Integer shoppingId;

    private Integer computerId;

    private Integer computerCount;

    private Integer shoppingCartState;

    private Integer userId;

    public Integer getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(Integer shoppingId) {
        this.shoppingId = shoppingId;
    }

    public Integer getComputerId() {
        return computerId;
    }

    public void setComputerId(Integer computerId) {
        this.computerId = computerId;
    }

    public Integer getComputerCount() {
        return computerCount;
    }

    public void setComputerCount(Integer computerCount) {
        this.computerCount = computerCount;
    }

    public Integer getShoppingCartState() {
        return shoppingCartState;
    }

    public void setShoppingCartState(Integer shoppingCartState) {
        this.shoppingCartState = shoppingCartState;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}