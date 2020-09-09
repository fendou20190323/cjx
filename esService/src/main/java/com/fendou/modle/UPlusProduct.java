package com.fendou.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel(description = "u+标准产品")
@Data
public class UPlusProduct  {

	@ApiModelProperty(value = "UUID")
	private String id;
	@ApiModelProperty(value = "店铺id")
	private String supplierStoreId;
	@ApiModelProperty(value = "店铺名称")
	private String supplierStoreName;
	@ApiModelProperty(value = "模板分类id(运营平台)")
	private String templateCateId;
	@ApiModelProperty(value = "模板分类名称")
	private String templateCateName;
	@ApiModelProperty(value = "spuId")
	private String productId;
	@ApiModelProperty(value = "产品编码")
	private String code;
	@ApiModelProperty(value = "产品名称")
	private String name;
	@ApiModelProperty(value = "品牌编码")
	private String brandCode;
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	@ApiModelProperty(value = "分类编码")
	private String cateCode;
	@ApiModelProperty(value = "分类名称")
	private String cateName;
	@ApiModelProperty(value = "完整分类名称")
	private String fullCateName;
	@ApiModelProperty(value = "产品分类识别码")
	private String cateIdentifier;
	@ApiModelProperty(value = "商品状态编码")
	private String busStatusCode;
	@ApiModelProperty(value = "商品状态名称")
	private String busStatusName;
	@ApiModelProperty(value = "面料信息")
	private String fabric;
	@ApiModelProperty(value = "里料信息")
	private String lining;
	@ApiModelProperty(value = "配料信息")
	private String ingredients;
	@ApiModelProperty(value = "填充物信息")
	private String filler;
	@ApiModelProperty(value = "季节波段编码")
	private String seasonalStyleCode;
	@ApiModelProperty(value = "季节波段")
	private String seasonalStyle;
	@ApiModelProperty(value = "产品图片")
	private String image;
	@ApiModelProperty(value = "零售价格（SKU最低价）")
	private BigDecimal retailPrice;
	@ApiModelProperty(value = "产品销量")
	private Integer salesVolume;
	@ApiModelProperty(value = "产品等级")
	private String level;
	@ApiModelProperty(value = "产品描述")
	private String productDescription;
	@ApiModelProperty(value = "产品详情")
	private String productDetail;
	@ApiModelProperty(value = "租户ID")
	private String tenantId;


}