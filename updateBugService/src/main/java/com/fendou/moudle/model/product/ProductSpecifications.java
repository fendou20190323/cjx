package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@ApiModel(description = "产品规格")
@Data
public class ProductSpecifications extends BaseModel {

    @ApiModelProperty(value = "UUID")
    private String id;

    @ApiModelProperty(value = "规格编码")
    private String code;
    @ApiModelProperty(value = "规格名称")
    private String name;
    @ApiModelProperty(value = "规格类型（0：文字，1：图片）")
    private Integer type;
    @ApiModelProperty(value = "产品分类ID")
    private String cateId;
    @ApiModelProperty(value = "产品分类名称")
    private String cateName;
    @ApiModelProperty(value = "产品分类识别码")
    private String cateIdentifier;
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

//    @ApiModelProperty(value = "产品规格属性列表")
//    private List<ProductSpecificationsAttribute> productSpecificationsAttributes;

    @Override
    public ProductSpecifications clone() {
        ProductSpecifications instance = new ProductSpecifications();
        instance.setId(this.id);
        instance.setCode(this.code);
        instance.setName(this.name);
        instance.setType(this.type);
        instance.setCateId(this.cateId);
        instance.setCateName(this.cateName);
        instance.setCateIdentifier(this.cateIdentifier);
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
        return instance;
    }

}