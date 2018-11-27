package com.nf.lc.entity;

public class ComputerSystem {
    private Integer computerSystemId;

    private String computerSystemName;

    public Integer getComputerSystemId() {
        return computerSystemId;
    }

    public void setComputerSystemId(Integer computerSystemId) {
        this.computerSystemId = computerSystemId;
    }

    public String getComputerSystemName() {
        return computerSystemName;
    }

    public void setComputerSystemName(String computerSystemName) {
        this.computerSystemName = computerSystemName == null ? null : computerSystemName.trim();
    }
}