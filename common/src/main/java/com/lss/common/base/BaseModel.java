package com.lss.common.base;

import com.alibaba.fastjson.JSONObject;
import com.lss.common.util.JWTUtils;
import com.lss.common.util.UUIDUtils;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.beans.Transient;
import java.io.Serializable;
import java.sql.Timestamp;

public class BaseModel implements Serializable {
    private static final int NORMAL_STATUS = 0;
    private static final int UPDATE_STATUS = 1;
    private static final int DELETE_STATUS = 9;

    /**
     * 线程安全类
     * 有些不是url请求的直接返回空
     *
     * @return HttpServletRequest
     */
    @Transient
    public String getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
            JSONObject jsonObject = JWTUtils.getInstance().getTokenSub(request.getHeader("accessToken"));
            return jsonObject.getString("userId");
        } catch (Exception e) {
            return null;
        }
    }
    @Transient
    public JSONObject getCurrentUserInfo() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
            return JWTUtils.getInstance().getTokenSub(request.getHeader("accessToken"));
        } catch (Exception e) {
            return null;
        }
    }


    @ApiModelProperty(value = "UUID")
    protected String id;
    @ApiModelProperty(value = "备注")
    protected String remarks;
    @ApiModelProperty(value = "状态")
    protected Integer status;
    @ApiModelProperty(value = "排序号")
    protected Integer sort;
    @ApiModelProperty(value = "操作人", hidden = true)
    protected String updateBy;
    @ApiModelProperty(value = "操作时间", hidden = true)
    protected Timestamp updateTime;
    @ApiModelProperty(value = "创建人", hidden = true)
    protected String createBy;
    @ApiModelProperty(value = "创建时间", hidden = true)
    protected Timestamp createTime;

    @ApiModelProperty(value = "租户ID")
    protected String tenantId;
    @ApiModelProperty(value = "业务关联用户")
    protected String relationUserId;
    @ApiModelProperty(value = "业务关联部门,机构")
    protected String relationDepId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void insertSet() {
        JSONObject jsonObject = getCurrentUserInfo();
        if (jsonObject != null && jsonObject.size() > 0) {
            setRelationUserId(jsonObject.get("userId").toString());
            if (jsonObject.get("departId") != null) setRelationDepId(jsonObject.get("departId").toString());
            if (jsonObject.get("tenantId") != null) setTenantId(jsonObject.get("tenantId").toString());
            setUpdateBy(jsonObject.get("userId").toString());
            setCreateBy(jsonObject.get("userId").toString());
        }
        setId(UUIDUtils.getUUID());
        setStatus(NORMAL_STATUS);
        setUpdateTime(new Timestamp(System.currentTimeMillis()));
        setCreateTime(new Timestamp(System.currentTimeMillis()));
    }

    public void updateSet() {
        setStatus(UPDATE_STATUS);
        setUpdateBy(getCurrentUser());
        setUpdateTime(new Timestamp(System.currentTimeMillis()));
    }

    public void deleteSet() {
        setStatus(DELETE_STATUS);
        setUpdateBy(getCurrentUser());
        setUpdateTime(new Timestamp(System.currentTimeMillis()));
    }

    public String getRelationUserId() {
        return relationUserId;
    }

    public void setRelationUserId(String relationUserId) {
        this.relationUserId = relationUserId;
    }

    public String getRelationDepId() {
        return relationDepId;
    }

    public void setRelationDepId(String relationDepId) {
        this.relationDepId = relationDepId;
    }
}
