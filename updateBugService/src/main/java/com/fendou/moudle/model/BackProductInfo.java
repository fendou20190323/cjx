package com.fendou.moudle.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@ApiModel(description = "返货商品详情")
public class BackProductInfo  {

	@ApiModelProperty(value = "UUID")
	private String id;
	@ApiModelProperty(value = "返货单单号")
	private String orderSn;
	@ApiModelProperty(value = "货品编码")
	private String goodsCode;
	@ApiModelProperty(value = "货品名称")
	private String goodsName;
	@ApiModelProperty(value = "商品编码")
	private String productCode;
	@ApiModelProperty(value = "商品类型")
	private String productType;
	@ApiModelProperty(value = "商品图片")
	private String image;
	@ApiModelProperty(value = "品牌编码")
	private String brandCode;
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	@ApiModelProperty(value = "设计商编码")
	private String designCompanyCode;
	@ApiModelProperty(value = "设计商名称")
	private String designCompanyName;
	@ApiModelProperty(value = "尺码")
	private String size;
	@ApiModelProperty(value = "颜色")
	private String color;
	@ApiModelProperty(value = "色系")
	private String colorSeries;
	@ApiModelProperty(value = "吊牌价（零售价）")
	private BigDecimal retailPrice;
	@ApiModelProperty(value = "返货数量")
	private Integer planBackQuantity;
	@ApiModelProperty(value = "返货单价")
	private BigDecimal backUnitPrice;
	@ApiModelProperty(value = "实际返货数量")
	private Integer realityBackQuantity;
	@ApiModelProperty(value = "排序号")
	private Integer sort;
	@ApiModelProperty(value = "状态")
	private Integer status;
	@ApiModelProperty(value = "备注")
	private String remarks;
	@ApiModelProperty(value = "操作人")
	private String updateBy;
	@ApiModelProperty(value = "操作时间")
	private Timestamp updateTime;
	@ApiModelProperty(value = "创建人")
	private String createBy;
	@ApiModelProperty(value = "创建时间")
	private Timestamp createTime;
	@ApiModelProperty(value = "租户ID")
	private String tenantId;

	/**
	 * UUID
	 */
	public String getId() {
		return id;
	}

	/**
	 * UUID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 返货单单号
	 */
	public String getOrderSn() {
		return orderSn;
	}

	/**
	 * 返货单单号
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	/**
	 * 货品编码
	 */
	public String getGoodsCode() {
		return goodsCode;
	}

	/**
	 * 货品编码
	 */
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	/**
	 * 货品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * 货品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * 商品编码
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * 商品编码
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * 商品类型
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * 商品类型
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * 商品图片
	 */
	public String getImage() {
		return image;
	}

	/**
	 * 商品图片
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * 品牌编码
	 */
	public String getBrandCode() {
		return brandCode;
	}

	/**
	 * 品牌编码
	 */
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	/**
	 * 品牌名称
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * 品牌名称
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * 设计商编码
	 */
	public String getDesignCompanyCode() {
		return designCompanyCode;
	}

	/**
	 * 设计商编码
	 */
	public void setDesignCompanyCode(String designCompanyCode) {
		this.designCompanyCode = designCompanyCode;
	}

	/**
	 * 设计商名称
	 */
	public String getDesignCompanyName() {
		return designCompanyName;
	}

	/**
	 * 设计商名称
	 */
	public void setDesignCompanyName(String designCompanyName) {
		this.designCompanyName = designCompanyName;
	}

	/**
	 * 尺码
	 */
	public String getSize() {
		return size;
	}

	/**
	 * 尺码
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * 颜色
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 颜色
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 色系
	 */
	public String getColorSeries() {
		return colorSeries;
	}

	/**
	 * 色系
	 */
	public void setColorSeries(String colorSeries) {
		this.colorSeries = colorSeries;
	}

	/**
	 * 吊牌价（零售价）
	 */
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	/**
	 * 吊牌价（零售价）
	 */
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	/**
	 * 返货数量
	 */
	public Integer getPlanBackQuantity() {
		return planBackQuantity;
	}

	/**
	 * 返货数量
	 */
	public void setPlanBackQuantity(Integer planBackQuantity) {
		this.planBackQuantity = planBackQuantity;
	}

	/**
	 * 返货单价
	 */
	public BigDecimal getBackUnitPrice() {
		return backUnitPrice;
	}

	/**
	 * 返货单价
	 */
	public void setBackUnitPrice(BigDecimal backUnitPrice) {
		this.backUnitPrice = backUnitPrice;
	}

	/**
	 * 实际返货数量
	 */
	public Integer getRealityBackQuantity() {
		return realityBackQuantity;
	}

	/**
	 * 实际返货数量
	 */
	public void setRealityBackQuantity(Integer realityBackQuantity) {
		this.realityBackQuantity = realityBackQuantity;
	}

	/**
	 * 排序号
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 排序号
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 状态
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 备注
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 操作人
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 操作人
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 操作时间
	 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * 操作时间
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 创建人
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 创建时间
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 租户ID
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * 租户ID
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public BackProductInfo clone() {
		BackProductInfo instance = new BackProductInfo();
		instance.setId(this.id);
		instance.setOrderSn(this.orderSn);
		instance.setGoodsCode(this.goodsCode);
		instance.setGoodsName(this.goodsName);
		instance.setProductCode(this.productCode);
		instance.setProductType(this.productType);
		instance.setImage(this.image);
		instance.setBrandCode(this.brandCode);
		instance.setBrandName(this.brandName);
		instance.setDesignCompanyCode(this.designCompanyCode);
		instance.setDesignCompanyName(this.designCompanyName);
		instance.setSize(this.size);
		instance.setColor(this.color);
		instance.setRetailPrice(this.retailPrice);
		instance.setPlanBackQuantity(this.planBackQuantity);
		instance.setBackUnitPrice(this.backUnitPrice);
		instance.setRealityBackQuantity(this.realityBackQuantity);
		instance.setSort(this.sort);
		instance.setStatus(this.status);
		instance.setRemarks(this.remarks);
		instance.setUpdateBy(this.updateBy);
		instance.setUpdateTime(this.updateTime);
		instance.setCreateBy(this.createBy);
		instance.setCreateTime(this.createTime);
		instance.setTenantId(this.tenantId);
		return instance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof BackProductInfo)) {
			return false;
		}
		BackProductInfo that = (BackProductInfo) o;
		return Objects.equals(id, that.id)
        		&& Objects.equals(orderSn, that.orderSn)
        		&& Objects.equals(goodsCode, that.goodsCode)
        		&& Objects.equals(goodsName, that.goodsName)
        		&& Objects.equals(productCode, that.productCode)
        		&& Objects.equals(productType, that.productType)
        		&& Objects.equals(image, that.image)
        		&& Objects.equals(brandCode, that.brandCode)
        		&& Objects.equals(brandName, that.brandName)
        		&& Objects.equals(designCompanyCode, that.designCompanyCode)
        		&& Objects.equals(designCompanyName, that.designCompanyName)
        		&& Objects.equals(size, that.size)
        		&& Objects.equals(color, that.color)
        		&& Objects.equals(retailPrice, that.retailPrice)
        		&& Objects.equals(planBackQuantity, that.planBackQuantity)
        		&& Objects.equals(backUnitPrice, that.backUnitPrice)
        		&& Objects.equals(realityBackQuantity, that.realityBackQuantity)
        		&& Objects.equals(sort, that.sort)
        		&& Objects.equals(status, that.status)
        		&& Objects.equals(remarks, that.remarks)
        		&& Objects.equals(updateBy, that.updateBy)
        		&& Objects.equals(updateTime, that.updateTime)
        		&& Objects.equals(createBy, that.createBy)
        		&& Objects.equals(createTime, that.createTime)
        		&& Objects.equals(tenantId, that.tenantId)
				;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, orderSn, goodsCode, goodsName, productCode, productType, image, brandCode, brandName, designCompanyCode, designCompanyName, size, color, retailPrice, planBackQuantity, backUnitPrice, realityBackQuantity, sort, status, remarks, updateBy, updateTime, createBy, createTime, tenantId);
	}
	
}