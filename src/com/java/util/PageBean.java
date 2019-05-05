package com.java.util;

public class PageBean {
    /**
     * 总条数
     */
    private int count;
    /**
     * 当前页
     */
    private int pageIndex = 1;
    /**
     * 每页条数
     */
    private int pageCount;

    public PageBean() {
    }

    /**
     * 获得总页数
     *
     * @return
     */
    public int getPages() {
        return (count + pageCount - 1) / pageCount;
    }

    /**
     * 获得select中的索引值
     *
     * @return
     */
    public int getIndex() {
        return (pageIndex - 1) * pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
