package com.fendou.moudle.model.product;


import com.fendou.moudle.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@ApiModel(description = "标准产品及标签关联")
@Data
public class ProductTag extends BaseModel {

	@ApiModelProperty(value = "UUID")
	private String id;
	@ApiModelProperty(value = "标准产品ID")
	private String productId;
	@ApiModelProperty(value = "匹配标签ID")
	private String tagId;
	@ApiModelProperty(value = "匹配标签名称")
	private String tagName;
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
	public ProductTag clone() {
		ProductTag instance = new ProductTag();
		instance.setId(this.id);
		instance.setProductId(this.productId);
		instance.setTagId(this.tagId);
		instance.setTagName(this.tagName);
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