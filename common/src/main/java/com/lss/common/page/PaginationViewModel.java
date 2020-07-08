package com.lss.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangyg
 */
@ApiModel(value = "PaginationViewModel", description = "数据集")
public class PaginationViewModel<T>  {

    @ApiModelProperty(value = "当前页码", required = true)
    protected int pageIndex;

    @ApiModelProperty(value = "每页条数", required = true)
    protected int pageSize;

    @ApiModelProperty(value = "数据条数")
    protected long count;

    @ApiModelProperty(value = "总数据条数", required = true)
    protected long totalCount;

    @ApiModelProperty(value = "总页码数", required = true)
    long totalPages;

    protected List<T> data;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
