package com.crm.util.responseUtil;

import java.util.List;

public class PageBean<T> {

    public static final Integer PAGESIZE = 10;

    /**
     * 当前页， 默认显示第一页
     */
    private Integer currntPage = 1;

    /**
     * 从当前记录开始，
     */
    private Integer pageNo = 0;

    /**
     * 查询返回的行数（每页显示的行数），默认每页显示10行
     */

    private Integer pageSize = 10;

    /**
     * 总记录数
     */
    private int totalCount;

    /**
     * 总页数 = 总记录数/每页显示的行数（+1）
     */
    private int totalPage;

    /**
     * 分页查询的数据,运用泛型，可以重复利用
     */
    private List<T> pageData;

    public int getTotalPage() {

        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }
        return totalPage;
    }

    public Integer getCurrntPage() {
        return currntPage;
    }

    public void setCurrntPage(Integer currntPage) {
        this.currntPage = currntPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
