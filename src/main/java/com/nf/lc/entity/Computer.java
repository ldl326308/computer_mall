package com.nf.lc.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Computer {
    private Integer computerId;

    private String computerDescribe;

    private BigDecimal computerPrice;

    private Integer computerState;

    private Date computerCreateTime;

    private Brand brand;

    private Type type;

    private Processor processor;

    private MemoryCapacity memoryCapacity;

    private HardDisk hardDisk;

    private ComputerSystem computerSystem;

    private Dimension dimension;

    private Nvdia nvdia;

    private List<ComputerImage> computerImageList;

    public List<ComputerImage> getComputerImageList() {
        return computerImageList;
    }

    public void setComputerImageList(List<ComputerImage> computerImageList) {
        this.computerImageList = computerImageList;
    }

    public Integer getComputerId() {
        return computerId;
    }

    public void setComputerId(Integer computerId) {
        this.computerId = computerId;
    }

    public String getComputerDescribe() {
        return computerDescribe;
    }

    public void setComputerDescribe(String computerDescribe) {
        this.computerDescribe = computerDescribe;
    }

    public BigDecimal getComputerPrice() {
        return computerPrice;
    }

    public void setComputerPrice(BigDecimal computerPrice) {
        this.computerPrice = computerPrice;
    }

    public Integer getComputerState() {
        return computerState;
    }

    public void setComputerState(Integer computerState) {
        this.computerState = computerState;
    }

    public Date getComputerCreateTime() {
        return computerCreateTime;
    }

    public void setComputerCreateTime(Date computerCreateTime) {
        this.computerCreateTime = computerCreateTime;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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




}