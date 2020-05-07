package com.xdc.sparrowShop.entity;

import java.util.List;

public class PageResponse<T> {
    private int pageNum;
    private int pageSize;
    private int totalCounts;
    private List<T> data;

    public PageResponse() {
    }

    public static <T> PageResponse<T> pagedData(int totalPage, List<T> data) {
        PageResponse<T> result = new PageResponse<>();
        result.setTotalCounts(totalPage);
        result.setData(data);
        return result;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
