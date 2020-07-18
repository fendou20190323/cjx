package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import com.lss.common.annotation.ExcelVOAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@ApiModel(description = "产品品牌")
@Data
public class ProductBrand extends BaseModel {

    @ApiModelProperty(value = "UUID")
    @ExcelVOAttribute(name="ID",column = "A")
    private String id;

    @ApiModelProperty(value = "品牌编码")
    @ExcelVOAttribute(name="BRANDCODE",column = "D")
    private String code;
    @ApiModelProperty(value = "品牌名称")
    @ExcelVOAttribute(name="BRANDNAME",column = "C")
    private String name;
    @ApiModelProperty(value = "品牌图片")
    private String logo;
    @ApiModelProperty(value = "品牌类型（0：自营，1：加盟）")
    @ExcelVOAttribute(name="PARENTID",column = "B")
    private Integer type;
    @ApiModelProperty(value = "是否推荐（0：否，1：是）")
    private Integer recommend;
    @ApiModelProperty(value = "展示方式（0：文字，1：图片）")
    private Integer show;
    @ApiModelProperty(value = "联系人员")
    private String contact;
    @ApiModelProperty(value = "联系电话")
    private String telephone;
    @ApiModelProperty(value = "品牌地址")
    private String address;
    @ApiModelProperty(value = "入驻时间")
    private Date settledTime;
    @ApiModelProperty(value = "合作状态（0：否，1：是）")
    private Boolean cooperation;
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

//    @ApiModelProperty(value = "品牌档案信息列表")
//    private List<EnterpriseArchivalInformation> productBrandProfiles;

    @Override
    public ProductBrand clone() {
        ProductBrand instance = new ProductBrand();
        instance.setId(this.id);
        instance.setCode(this.code);
        instance.setName(this.name);
        instance.setLogo(this.logo);
        instance.setType(this.type);
        instance.setRecommend(this.recommend);
        instance.setShow(this.show);
        instance.setContact(this.contact);
        instance.setTelephone(this.telephone);
        instance.setAddress(this.address);
        instance.setSettledTime(this.settledTime);
        instance.setCooperation(this.cooperation);
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