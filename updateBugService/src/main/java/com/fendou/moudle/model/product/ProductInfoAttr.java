package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@ApiModel(description = "产品信息关联信息")
@Data
public class ProductInfoAttr extends BaseModel {

	@ApiModelProperty(value = "UUID")
	private String id;

	@ApiModelProperty(value = "产品ID")
	private String productId;
	@ApiModelProperty(value = "产品名称")
	private String productName;
	@ApiModelProperty(value = "信息ID")
	private String infoId;
	@ApiModelProperty(value = "信息名称")
	private String infoName;
	@ApiModelProperty(value = "信息属性ID")
	private String infoAttrId;
	@ApiModelProperty(value = "信息属性名称")
	private String infoAttrName;
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
	public ProductInfoAttr clone() {
		ProductInfoAttr instance = new ProductInfoAttr();
		instance.setId(this.id);
		instance.setProductId(this.productId);
		instance.setProductName(this.productName);
		instance.setInfoId(this.infoId);
		instance.setInfoName(this.infoName);
		instance.setInfoAttrId(this.infoAttrId);
		instance.setInfoAttrName(this.infoAttrName);
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