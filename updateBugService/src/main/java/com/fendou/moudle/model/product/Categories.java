package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@ApiModel(description = "产品分类")
@Data
public class Categories extends BaseModel {

    @ApiModelProperty(value = "UUID")
    private String id;
    @ApiModelProperty(value = "分类编码")
    private String code;
    @ApiModelProperty(value = "分类识别码")
    private String identifier;
    @ApiModelProperty(value = "分类名称")
    private String name;
    @ApiModelProperty(value = "分类级别")
    private Integer level;
    @ApiModelProperty(value = "父级分类ID")
    private String parentId;
    @ApiModelProperty(value = "父级分类名称")
    private String parentName;
    @ApiModelProperty(value = "完整分类名称")
    private String fullCateName;
    @ApiModelProperty(value = "分类类型（1：标准分类，2：定制分类，3：原料分类）")
    private Integer type;
    @ApiModelProperty(value = "定制类型（1：套装，2：单品）")
    private Integer customizedType;
    @ApiModelProperty(value = "分类图片")
    private String image;
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
    public Categories clone() {
        Categories instance = new Categories();
        instance.setId(this.id);
        instance.setCode(this.code);
        instance.setIdentifier(this.identifier);
        instance.setName(this.name);
        instance.setLevel(this.level);
        instance.setParentId(this.parentId);
        instance.setParentName(this.parentName);
        instance.setFullCateName(this.fullCateName);
        instance.setType(this.type);
        instance.setCustomizedType(this.customizedType);
        instance.setImage(this.image);
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