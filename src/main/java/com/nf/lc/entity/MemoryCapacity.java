package com.nf.lc.entity;

public class MemoryCapacity {
    private Integer memoryCapacityId;

    private String memoryCapacityName;

    public Integer getMemoryCapacityId() {
        return memoryCapacityId;
    }

    public void setMemoryCapacityId(Integer memoryCapacityId) {
        this.memoryCapacityId = memoryCapacityId;
    }

    public String getMemoryCapacityName() {
        return memoryCapacityName;
    }

    public void setMemoryCapacityName(String memoryCapacityName) {
        this.memoryCapacityName = memoryCapacityName == null ? null : memoryCapacityName.trim();
    }
}