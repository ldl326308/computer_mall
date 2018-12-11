package com.nf.lc.entity;

public class SelectLikePrams {
    String likeStr;
    int page;
    int count;

    public String getLikeStr() {
        return likeStr;
    }

    public void setLikeStr(String likeStr) {
        this.likeStr = "%"+likeStr+"%";
    }

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
}
