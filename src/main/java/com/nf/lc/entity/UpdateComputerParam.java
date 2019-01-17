package com.nf.lc.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 修改参数载体
 */
public class UpdateComputerParam {

    private Integer computerId;

    private BigDecimal computerPrice;

    private Integer computerState;

    private Integer brandId;

    private Integer typeId;

    private Integer processorId;

    private Integer memoryCapacityId;

    private Integer hardDiskId;

    private Integer computerSystemId;

    private Integer dimensionId;

    private Integer nvdiaId;

    private List<ComputerImage> computerImageList;


    public Integer getComputerId() {
        return computerId;
    }

    public void setComputerId(Integer computerId) {
        this.computerId = computerId;
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

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getProcessorId() {
        return processorId;
    }

    public void setProcessorId(Integer processorId) {
        this.processorId = processorId;
    }

    public Integer getMemoryCapacityId() {
        return memoryCapacityId;
    }

    public void setMemoryCapacityId(Integer memoryCapacityId) {
        this.memoryCapacityId = memoryCapacityId;
    }

    public Integer getHardDiskId() {
        return hardDiskId;
    }

    public void setHardDiskId(Integer hardDiskId) {
        this.hardDiskId = hardDiskId;
    }

    public Integer getComputerSystemId() {
        return computerSystemId;
    }

    public void setComputerSystemId(Integer computerSystemId) {
        this.computerSystemId = computerSystemId;
    }

    public Integer getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(Integer dimensionId) {
        this.dimensionId = dimensionId;
    }

    public Integer getNvdiaId() {
        return nvdiaId;
    }

    public void setNvdiaId(Integer nvdiaId) {
        this.nvdiaId = nvdiaId;
    }

    public List<ComputerImage> getComputerImageList() {
        return computerImageList;
    }

    public void setComputerImageList(List<ComputerImage> computerImageList) {
        this.computerImageList = computerImageList;
    }
}
