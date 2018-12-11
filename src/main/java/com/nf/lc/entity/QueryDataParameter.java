package com.nf.lc.entity;

public class QueryDataParameter {
    int brand; //品牌
    int type; //类型
    int processor; //处理器
    int memoryCapacity; //内存容量
    int hardDisk; //硬盘容量
    int computerSystem; //系统
    int dimension; //尺寸
    int nvdia; //显卡
    int count; //每页条数
    int page; //页

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getProcessor() {
        return processor;
    }

    public void setProcessor(int processor) {
        this.processor = processor;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(int memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }

    public int getComputerSystem() {
        return computerSystem;
    }

    public void setComputerSystem(int computerSystem) {
        this.computerSystem = computerSystem;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getNvdia() {
        return nvdia;
    }

    public void setNvdia(int nvdia) {
        this.nvdia = nvdia;
    }
}
