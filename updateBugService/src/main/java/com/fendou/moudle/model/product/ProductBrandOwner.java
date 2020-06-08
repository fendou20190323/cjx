package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@ApiModel(description = "产品品牌商")
@Data
public class ProductBrandOwner extends BaseModel {

    @ApiModelProperty(value = "UUID")
    private String id;
    @ApiModelProperty(value = "品牌商编码")
    private String code;
    @ApiModelProperty(value = "品牌商名称")
    private String name;
    @ApiModelProperty(value = "品牌商LOGO")
    private String logo;
    @ApiModelProperty(value = "是否推荐（0：否，1：是）")
    private Boolean recommend;
    @ApiModelProperty(value = "品牌商地址")
    private String address;
    @ApiModelProperty(value = "联系人员")
    private String contact;
    @ApiModelProperty(value = "联系电话")
    private String telephone;
    @ApiModelProperty(value = "邮政编码")
    private String postalCode;
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

    @Override
    public ProductBrandOwner clone() {
        ProductBrandOwner instance = new ProductBrandOwner();
        instance.setId(this.id);
        instance.setCode(this.code);
        instance.setName(this.name);
        instance.setLogo(this.logo);
        instance.setRecommend(this.recommend);
        instance.setAddress(this.address);
        instance.setContact(this.contact);
        instance.setTelephone(this.telephone);
        instance.setPostalCode(this.postalCode);
        instance.setSettledTime(this.settledTime);
        instance.setCooperation(this.cooperation);
        instance.setOrganizationId(this.organizationId);
        instance.setKeyword(this.keyword);
        instance.setSort(this.sort);
        instance.setDescription(this.description);
        instance.setRemarks(this.remarks);
        instance.setValid(this.valid);
        instance.setStatus(this.status);
        instance.setCreateBy(this.createBy);
        instance.setUpdateBy(this.updateBy);
        instance.setCreateTime(this.createTime);
        instance.setUpdateTime(this.updateTime);
        instance.setTenantId(this.tenantId);
        return instance;
    }

}