package com.nf.lc.entity;

public class HardDisk {
    private Integer hardDiskId;

    private String hardDiskName;

    public Integer getHardDiskId() {
        return hardDiskId;
    }

    public void setHardDiskId(Integer hardDiskId) {
        this.hardDiskId = hardDiskId;
    }

    public String getHardDiskName() {
        return hardDiskName;
    }

    public void setHardDiskName(String hardDiskName) {
        this.hardDiskName = hardDiskName == null ? null : hardDiskName.trim();
    }
}