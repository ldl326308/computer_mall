package com.nf.lc.entity;

public class Processor {
    private Integer processorId;

    private String processorName;

    public Integer getProcessorId() {
        return processorId;
    }

    public void setProcessorId(Integer processorId) {
        this.processorId = processorId;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName == null ? null : processorName.trim();
    }
}