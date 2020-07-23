package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import com.lss.common.annotation.ExcelVOAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@ApiModel(description = "供应商信息")
@Data
public class Supplier extends BaseModel {

    @ApiModelProperty(value = "UUID")
    @ExcelVOAttribute(name="ID",column = "A")
    private String id;
    @ApiModelProperty(value = "供应商编码")
    @ExcelVOAttribute(name="CODE",column = "C")
    private String code;
    @ApiModelProperty(value = "供应商名称")
    @ExcelVOAttribute(name="NAME",column = "B")
    private String name;
    @ApiModelProperty(value = "供应商LOGO")
    private String logo;
    @ApiModelProperty(value = "是否推荐（0：否，1：是）")
    private Boolean recommend;
    @ApiModelProperty(value = "供应商地址")
    private String address;
    @ApiModelProperty(value = "收款账户")
    private String receivableAccount;
    @ApiModelProperty(value = "联系人员")
    private String contact;
    @ApiModelProperty(value = "联系电话")
    private String telephone;
    @ApiModelProperty(value = "入驻时间")
    private Date settledTime;
    @ApiModelProperty(value = "合作状态（0：否，1：是）")
    private Boolean cooperation;
    @ApiModelProperty(value = "组织机构ID")
    private String organizationId;
    @ApiModelProperty(value = "关键字词")
    private String keyword;
    @ApiModelProperty(value = "排列顺序")
    private Integer sort;
    @ApiModelProperty(value = "描述信息")
    @ExcelVOAttribute(name="DESCRIPTION",column = "D")
    private String description;
    @ApiModelProperty(value = "备注信息")
    private String remarks;
    @ApiModelProperty(value = "有效状态（0：否，1：是）")
    private Boolean valid;
    @ApiModelProperty(value = "状态信息")
    private Integer status;
    @ApiModelProperty(value = "创建人员")
    private String createBy;
    @ApiModelProperty(value = "更新人员")
    private String updateBy;
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;
    @ApiModelProperty(value = "更新时间")
    private Timestamp updateTime;
    @ApiModelProperty(value = "业务关联用户")
    private String relationUserId;
    @ApiModelProperty(value = "业务关联部门")
    private String relationDepId;
    @ApiModelProperty(value = "租户标识")
    private String tenantId;


}