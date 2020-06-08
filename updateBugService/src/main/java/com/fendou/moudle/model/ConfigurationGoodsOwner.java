package com.fendou.moudle.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@ApiModel(description = "货主管理")
@Data
public class ConfigurationGoodsOwner extends BaseModel {

	@ApiModelProperty(value = "UUID")
	private String id;
	@ApiModelProperty(value = "租户ID")
	private String tenantId;
	@ApiModelProperty(value = "货主编码")
	private String code;
	@ApiModelProperty(value = "货主名称")
	private String name;
	@ApiModelProperty(value = "联系人")
	private String contact;
	@ApiModelProperty(value = "联系电话")
	private String telephone;
	@ApiModelProperty(value = "联系地址")
	private String divisionId;
	@ApiModelProperty(value = "省")
	private String province;
	@ApiModelProperty(value = "市")
	private String city;
	@ApiModelProperty(value = "区")
	private String area;
	@ApiModelProperty(value = "详细地址")
	private String address;
	@ApiModelProperty(value = "货主备注")
	private String description;
	@ApiModelProperty(value = "是否启用")
	private Boolean isValid;
	@ApiModelProperty(value = "备注")
	private String remarks;
	@ApiModelProperty(value = "状态")
	private Integer status;
	@ApiModelProperty(value = "排序号")
	private Integer sort;
	@ApiModelProperty(value = "创建人")
	private String createBy;
	@ApiModelProperty(value = "操作人")
	private String updateBy;
	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;
	@ApiModelProperty(value = "操作时间")
	private Timestamp updateTime;


}