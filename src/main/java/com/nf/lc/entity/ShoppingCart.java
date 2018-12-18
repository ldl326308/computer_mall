package com.nf.lc.entity;

import java.math.BigDecimal;

public class ShoppingCart {
    private Integer shoppingId;

    private Integer computerId;

    private Integer computerCount;

    private Integer shoppingCartState;

    private Integer userId;

    private String computerImage;

    private BigDecimal computerPrice;

    private Computer computer;

    private Type type;

    private Processor processor;

    private MemoryCapacity memoryCapacity;

    private HardDisk hardDisk;

    private ComputerSystem computerSystem;

    private Dimension dimension;

    private Nvdia nvdia;


    public Computer getComputer() {
        return computer;
    }

    public BigDecimal getComputerPrice() {
        return computerPrice;
    }

    public void setComputerPrice(BigDecimal computerPrice) {
        this.computerPrice = computerPrice;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public MemoryCapacity getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(MemoryCapacity memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public ComputerSystem getComputerSystem() {
        return computerSystem;
    }

    public void setComputerSystem(ComputerSystem computerSystem) {
        this.computerSystem = computerSystem;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Nvdia getNvdia() {
        return nvdia;
    }

    public void setNvdia(Nvdia nvdia) {
        this.nvdia = nvdia;
    }

    public String getComputerImage() {
        return computerImage;
    }

    public void setComputerImage(String computerImage) {
        this.computerImage = computerImage;
    }

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