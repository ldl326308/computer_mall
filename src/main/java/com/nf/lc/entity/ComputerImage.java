package com.nf.lc.entity;

public class ComputerImage {
    private Integer computerImageId;

    private Integer computerId;

    private String computerImageUrl;

    public Integer getComputerImageId() {
        return computerImageId;
    }

    public void setComputerImageId(Integer computerImageId) {
        this.computerImageId = computerImageId;
    }

    public Integer getComputerId() {
        return computerId;
    }

    public void setComputerId(Integer computerId) {
        this.computerId = computerId;
    }

    public String getComputerImageUrl() {
        return computerImageUrl;
    }

    public void setComputerImageUrl(String computerImageUrl) {
        this.computerImageUrl = computerImageUrl == null ? null : computerImageUrl.trim();
    }
}