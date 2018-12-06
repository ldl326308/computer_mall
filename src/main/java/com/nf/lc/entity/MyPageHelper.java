package com.nf.lc.entity;

public class MyPageHelper {

    private int page;
    private int count;

    public MyPageHelper() {
    }

    public MyPageHelper(int page, int count) {
        //算法
        //  page = (page -1) * count
        // count = 16

        this.page = (page - 1) * count;
        this.count = count;
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
