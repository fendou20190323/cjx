package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

@ApiModel(description = "产品关联图片信息")
@Data
public class ProductImage extends BaseModel {

	@ApiModelProperty(value = "UUID")
	private String id;
	@ApiModelProperty(value = "产品（SPU）ID")
	private String productId;
	@ApiModelProperty(value = "产品（SPU）编码")
	private String productCode;
	@ApiModelProperty(value = "产品（SPU）名称")
	private String productName;
	@ApiModelProperty(value = "图片ID")
	private String imageId;
	@ApiModelProperty(value = "图片名称")
	private String imageName;
	@ApiModelProperty(value = "图片类型")
	private String type;
	@ApiModelProperty(value = "图片地址")
	private String url;
	@ApiModelProperty(value = "缩略图地址")
	private String thumbnail;
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
	public ProductImage clone() {
		ProductImage instance = new ProductImage();
		instance.setId(this.id);
		instance.setProductId(this.productId);
		instance.setProductCode(this.productCode);
		instance.setProductName(this.productName);
		instance.setImageId(this.imageId);
		instance.setImageName(this.imageName);
		instance.setType(this.type);
		instance.setUrl(this.url);
		instance.setThumbnail(this.thumbnail);
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