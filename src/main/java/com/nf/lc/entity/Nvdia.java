package com.nf.lc.entity;

public class Nvdia {
    private Integer nvdiaId;

    private String nvdiaName;

    public Integer getNvdiaId() {
        return nvdiaId;
    }

    public void setNvdiaId(Integer nvdiaId) {
        this.nvdiaId = nvdiaId;
    }

    public String getNvdiaName() {
        return nvdiaName;
    }

    public void setNvdiaName(String nvdiaName) {
        this.nvdiaName = nvdiaName == null ? null : nvdiaName.trim();
    }
}