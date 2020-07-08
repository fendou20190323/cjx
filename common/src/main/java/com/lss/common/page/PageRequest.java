package com.lss.common.page;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class PageRequest implements Serializable {

    protected int pageNo = 1;
    protected int pageSize = 10;
    protected String sort;
    protected String order;

    /**
     * 获得当前页的页号, 序号从1开始, 默认为1.
     */
    @JSONField(serialize = false)
    public int getPageNo() {
        return pageNo;
    }

    public int getStart() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 设置当前页的页号, 序号从1开始, 低于1时自动调整为1.
     */
    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;
        if (pageNo < 1) {
            this.pageNo = 1;
        }
    }

    /**
     * 获得每页的记录数量, 默认为10.
     */
    @JSONField(serialize = false)
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页的记录数量, 低于1时设为最大.
     */
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
        if (pageSize < 1) {
            this.pageSize = 10000;
        }
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


}
