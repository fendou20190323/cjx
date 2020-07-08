package com.lss.common.page;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

public class PageResponse<T> extends PageRequest {

    private List<T> rows = null;
    private long total = -1;
    private Integer totalPage = 0;

    public PageResponse() {

    }

    public PageResponse(PageRequest request) {
        this.pageNo = request.pageNo;
        this.pageSize = request.pageSize;
        this.order = request.order;
        this.sort = request.sort;
    }

    /**
     * 获得页内的记录列表.
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * 设置页内的记录列表.
     */
    public void setRows(final List<T> rows) {
        this.rows = rows;
    }

    /**
     * 获得总记录数, 默认值为-1.
     */
    public long getTotal() {
        return total;
    }

    /**
     * 设置总记录数.
     */
    public void setTotal(final long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        if (total > 0) {
            if (total % 10 == 0) {
                return (int) (total / 10);
            } else {
                return (int) (total / 10 + 1);
            }
        }
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }


    /**
     * 根据pageSize与totalItems计算总页数.
     */
    @JSONField(serialize = false)
    public int getTotalPages() {
        return (int) Math.ceil((double) total / (double) getPageSize());

    }

    /**
     * 是否还有下一页.
     */
    @JSONField(serialize = false)
    public boolean hasNextPage() {
        return (getPageNo() + 1 <= getTotalPages());
    }

    /**
     * 是否最后一页.
     */
    @JSONField(serialize = false)
    public boolean isLastPage() {
        return !hasNextPage();
    }

    /**
     * 取得下页的页号, 序号从1开始.
     * 当前页为尾页时仍返回尾页序号.
     */
    @JSONField(serialize = false)
    public int getNextPage() {
        if (hasNextPage()) {
            return getPageNo() + 1;
        } else {
            return getPageNo();
        }
    }

    /**
     * 是否还有上一页.
     */
    @JSONField(serialize = false)
    public boolean hasPrePage() {
        return (getPageNo() > 1);
    }

    /**
     * 是否第一页.
     */
    @JSONField(serialize = false)
    public boolean isFirstPage() {
        return !hasPrePage();
    }

    /**
     * 取得上页的页号, 序号从1开始.
     * 当前页为首页时返回首页序号.
     */
    @JSONField(serialize = false)
    public int getPrePage() {
        if (hasPrePage()) {
            return getPageNo() - 1;
        } else {
            return getPageNo();
        }
    }

    /**
     * 计算以当前页为中心的页面列表,如"首页,23,24,25,26,27,末页"
     *
     * @param count 需要计算的列表大小
     * @return pageNo列表
     */
    @JSONField(serialize = false)
    public List<Integer> getSlider(int count) {
        int halfSize = count / 2;
        int totalPage = getTotalPages();

        int startPageNo = Math.max(getPageNo() - halfSize, 1);
        int endPageNo = Math.min(startPageNo + count - 1, totalPage);

        if (endPageNo - startPageNo < count) {
            startPageNo = Math.max(endPageNo - count, 1);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = startPageNo; i <= endPageNo; i++) {
            result.add(i);
        }
        return result;
    }

    /**
     * 设置当页的起始点
     *
     * @param start
     */
    public void setStartAndLimit(int start, int limit) {
        this.setPageSize(limit);
        int pageNo = start / getPageSize() + 1;
        this.setPageNo(pageNo);
    }
}
