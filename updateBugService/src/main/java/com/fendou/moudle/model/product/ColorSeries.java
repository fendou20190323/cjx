package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@ApiModel(description = "颜色色系")
@Data
public class ColorSeries extends BaseModel {

	@ApiModelProperty(value = "UUID")
	private String id;

	@ApiModelProperty(value = "色系编码")
	private String code;
	@ApiModelProperty(value = "色系名称")
	private String name;
	@ApiModelProperty(value = "业务关联用户")
	private String relationUserId;
	@ApiModelProperty(value = "业务关联部门")
	private String relationDepId;
	@ApiModelProperty(value = "租户标识")
	private String tenantId;
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

	@Override
	public ColorSeries clone() {
		ColorSeries instance = new ColorSeries();
		instance.setId(this.id);
		instance.setCode(this.code);
		instance.setName(this.name);
		instance.setRelationUserId(this.relationUserId);
		instance.setRelationDepId(this.relationDepId);
		instance.setTenantId(this.tenantId);
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