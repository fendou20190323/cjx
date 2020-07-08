package com.lss.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author wangyg
 */
@ApiModel(value = "RePagination", description = "翻页信息")
public class RePagination implements Serializable {
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页码")
    int pageIndex;
    /**
     * 每页条数
     */
    @ApiModelProperty(value = "每页数量")
    int pageSize;
    /**
     * 排序字段
     */
    @ApiModelProperty(value = "排序字段")
    String orderBy;

    /**
     * 启始数量
     */
    @ApiModelProperty(value = "启始数量")
    int pageStart;

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageSize * (pageIndex - 1) ;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        this.pageStart = pageSize * (pageIndex - 1) ;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.pageStart = pageSize * (pageIndex - 1) ;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
