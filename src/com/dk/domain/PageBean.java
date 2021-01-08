package com.dk.domain;

import java.util.List;

public class PageBean {
    private int startIndex; //  起始索引
    private int pageNumber; //当前页数
    private int pageSize;   //每页条数
    private int totalPage;  //总页数
    private int totalCount; //总条数
    private List<Phone> plist;

    public int getTotalPage() {
        totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :totalCount / pageSize + 1;
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStartIndex() {
        startIndex = (pageNumber - 1) * pageSize;
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Phone> getPlist() {
        return plist;
    }

    public void setPlist(List<Phone> plist) {
        this.plist = plist;
    }

    public PageBean() {
    }

    public PageBean(int startIndex, int pageNumber, int pageSize, List<Phone> plist) {
        this.startIndex = startIndex;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.plist = plist;
    }
}
