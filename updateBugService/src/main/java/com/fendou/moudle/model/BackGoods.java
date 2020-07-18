package com.fendou.moudle.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@ApiModel(description = "返货单")
@Data
public class BackGoods implements Serializable {

	@ApiModelProperty(value = "UUID")
	private String id;
	@ApiModelProperty(value = "返货单号")
	private String backNum;
	@ApiModelProperty(value = "关联单号")
	private String associateOrderSn;
	@ApiModelProperty(value = "订单状态")
	private Integer backStatus;
	@ApiModelProperty(value = "机构Id")
	private String organizationId;
	@ApiModelProperty(value = "所属机构名称")
	private String organizationName;
	@ApiModelProperty(value = "门店id")
	private String storeId;
	@ApiModelProperty(value = "门店名称")
	private String storeName;
	@ApiModelProperty(value = "门店类型")
	private String storeType;
	@ApiModelProperty(value = "物流公司编号")
	private String logisticsCode;
	@ApiModelProperty(value = "物流公司")
	private String logisticsCompany;
	@ApiModelProperty(value = "物流单号")
	private String logisticsNum;
	@ApiModelProperty(value = "divisionId（记录最后一级地址id）")
	private String divisionId;
	@ApiModelProperty(value = "省份code")
	private String provinceCode;
	@ApiModelProperty(value = "省份名称")
	private String provinceName;
	@ApiModelProperty(value = "城市code")
	private String cityCode;
	@ApiModelProperty(value = "城市名称")
	private String cityName;
	@ApiModelProperty(value = "区域code")
	private String areaCode;
	@ApiModelProperty(value = "区域名称")
	private String areaName;
	@ApiModelProperty(value = "详细地址")
	private String addressInfo;
	@ApiModelProperty(value = "返货人")
	private String backMan;
	@ApiModelProperty(value = "返货时间")
	private Date backTime;
	@ApiModelProperty(value = "返货数量")
	private Integer productNum;
	@ApiModelProperty(value = "实际返货数量")
	private Integer realityProductNum;
	@ApiModelProperty(value = "返货总金额")
	private BigDecimal totalPrice;
	@ApiModelProperty(value = "实收货值")
	private BigDecimal amount;
	@ApiModelProperty(value = "货主")
	private String goodsOwner;
	@ApiModelProperty(value = "收货人")
	private String receiveMan;
	@ApiModelProperty(value = "收货人电话")
	private String phone;
	@ApiModelProperty(value = "收货仓库编码")
	private String warehouseCode;
	@ApiModelProperty(value = "收货仓库名称")
	private String warehouseName;
	@ApiModelProperty(value = "发起人")
	private String createName;
	@ApiModelProperty(value = "订单类型")
	private Integer orderType;
	@ApiModelProperty(value = "用户id")
	private String relationUserId;
	@ApiModelProperty(value = "部门id")
	private String relationDepId;
	@ApiModelProperty(value = "部门名称")
	private String relationDepName;
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

	//接收数据
	@ApiModelProperty(value = "商品详情")
	private List<BackProductInfo> backProductInfoList;
	@ApiModelProperty(value = "应返商品件数")
	private Integer sumQuantity;
	@ApiModelProperty(value = "应返商品款号统计")
	private Integer productQuantity;
	@ApiModelProperty(value = "应返图片集合")
	private List<String> images;

	//实发数量
	@ApiModelProperty(value = "实返商品件数")
	private Integer realityBackQty;
	@ApiModelProperty(value = "实返商品款号统计")
	private Integer realityBackProductQty;
	@ApiModelProperty(value = "应返商品货号统计")
	private Integer realityBackGoodsQty;


	public List<BackProductInfo> getBackProductInfoList() {
		return backProductInfoList;
	}

	public void setBackProductInfoList(List<BackProductInfo> backProductInfoList) {
		this.backProductInfoList = backProductInfoList;
	}
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
	 * 返货单号
	 */
	public String getBackNum() {
		return backNum;
	}

	/**
	 * 返货单号
	 */
	public void setBackNum(String backNum) {
		this.backNum = backNum;
	}

	/**
	 * 关联单号
	 */
	public String getAssociateOrderSn() {
		return associateOrderSn;
	}

	/**
	 * 关联单号
	 */
	public void setAssociateOrderSn(String associateOrderSn) {
		this.associateOrderSn = associateOrderSn;
	}

	/**
	 * 订单状态
	 */
	public Integer getBackStatus() {
		return backStatus;
	}

	/**
	 * 订单状态
	 */
	public void setBackStatus(Integer backStatus) {
		this.backStatus = backStatus;
	}

	/**
	 * 机构Id
	 */
	public String getOrganizationId() {
		return organizationId;
	}

	/**
	 * 机构Id
	 */
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * 所属机构名称
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * 所属机构名称
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * 门店id
	 */
	public String getStoreId() {
		return storeId;
	}

	/**
	 * 门店id
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	/**
	 * 门店名称
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * 门店名称
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * 门店类型
	 */
	public String getStoreType() {
		return storeType;
	}

	/**
	 * 门店类型
	 */
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	/**
	 * 物流公司编号
	 */
	public String getLogisticsCode() {
		return logisticsCode;
	}

	/**
	 * 物流公司编号
	 */
	public void setLogisticsCode(String logisticsCode) {
		this.logisticsCode = logisticsCode;
	}

	/**
	 * 物流公司
	 */
	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	/**
	 * 物流公司
	 */
	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	/**
	 * 物流单号
	 */
	public String getLogisticsNum() {
		return logisticsNum;
	}

	/**
	 * 物流单号
	 */
	public void setLogisticsNum(String logisticsNum) {
		this.logisticsNum = logisticsNum;
	}

	/**
	 * divisionId（记录最后一级地址id）
	 */
	public String getDivisionId() {
		return divisionId;
	}

	/**
	 * divisionId（记录最后一级地址id）
	 */
	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	/**
	 * 省份code
	 */
	public String getProvinceCode() {
		return provinceCode;
	}

	/**
	 * 省份code
	 */
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	/**
	 * 省份名称
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * 省份名称
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	/**
	 * 城市code
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * 城市code
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * 城市名称
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * 城市名称
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * 区域code
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * 区域code
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * 区域名称
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 区域名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 详细地址
	 */
	public String getAddressInfo() {
		return addressInfo;
	}

	/**
	 * 详细地址
	 */
	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}

	/**
	 * 返货人
	 */
	public String getBackMan() {
		return backMan;
	}

	/**
	 * 返货人
	 */
	public void setBackMan(String backMan) {
		this.backMan = backMan;
	}

	/**
	 * 返货时间
	 */
	public Date getBackTime() {
		return backTime;
	}

	/**
	 * 返货时间
	 */
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	/**
	 * 返货数量
	 */
	public Integer getProductNum() {
		return productNum;
	}

	/**
	 * 返货数量
	 */
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	/**
	 * 实际返货数量
	 */
	public Integer getRealityProductNum() {
		return realityProductNum;
	}

	/**
	 * 实际返货数量
	 */
	public void setRealityProductNum(Integer realityProductNum) {
		this.realityProductNum = realityProductNum;
	}

	/**
	 * 返货总金额
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 返货总金额
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * 货主
	 */
	public String getGoodsOwner() {
		return goodsOwner;
	}

	/**
	 * 货主
	 */
	public void setGoodsOwner(String goodsOwner) {
		this.goodsOwner = goodsOwner;
	}

	/**
	 * 收货人
	 */
	public String getReceiveMan() {
		return receiveMan;
	}

	/**
	 * 收货人
	 */
	public void setReceiveMan(String receiveMan) {
		this.receiveMan = receiveMan;
	}

	/**
	 * 收货人电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 收货人电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 收货仓库编码
	 */
	public String getWarehouseCode() {
		return warehouseCode;
	}

	/**
	 * 收货仓库编码
	 */
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	/**
	 * 收货仓库名称
	 */
	public String getWarehouseName() {
		return warehouseName;
	}

	/**
	 * 收货仓库名称
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	/**
	 * 发起人
	 */
	public String getCreateName() {
		return createName;
	}

	/**
	 * 发起人
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}

	/**
	 * 订单类型
	 */
	public Integer getOrderType() {
		return orderType;
	}

	/**
	 * 订单类型
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	/**
	 * 用户id
	 */
	public String getRelationUserId() {
		return relationUserId;
	}

	/**
	 * 用户id
	 */
	public void setRelationUserId(String relationUserId) {
		this.relationUserId = relationUserId;
	}

	/**
	 * 部门id
	 */
	public String getRelationDepId() {
		return relationDepId;
	}

	/**
	 * 部门id
	 */
	public void setRelationDepId(String relationDepId) {
		this.relationDepId = relationDepId;
	}

	/**
	 * 部门名称
	 */
	public String getRelationDepName() {
		return relationDepName;
	}

	/**
	 * 部门名称
	 */
	public void setRelationDepName(String relationDepName) {
		this.relationDepName = relationDepName;
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

	public Integer getSumQuantity() {
		return sumQuantity;
	}

	public void setSumQuantity(Integer sumQuantity) {
		this.sumQuantity = sumQuantity;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Integer getRealityBackQty() {
		return realityBackQty;
	}

	public void setRealityBackQty(Integer realityBackQty) {
		this.realityBackQty = realityBackQty;
	}

	public Integer getRealityBackProductQty() {
		return realityBackProductQty;
	}

	public void setRealityBackProductQty(Integer realityBackProductQty) {
		this.realityBackProductQty = realityBackProductQty;
	}

	public Integer getRealityBackGoodsQty() {
		return realityBackGoodsQty;
	}

	public void setRealityBackGoodsQty(Integer realityBackGoodsQty) {
		this.realityBackGoodsQty = realityBackGoodsQty;
	}

	@Override
	public BackGoods clone() {
		BackGoods instance = new BackGoods();
		instance.setId(this.id);
		instance.setBackNum(this.backNum);
		instance.setAssociateOrderSn(this.associateOrderSn);
		instance.setBackStatus(this.backStatus);
		instance.setOrganizationId(this.organizationId);
		instance.setOrganizationName(this.organizationName);
		instance.setStoreId(this.storeId);
		instance.setStoreName(this.storeName);
		instance.setStoreType(this.storeType);
		instance.setLogisticsCode(this.logisticsCode);
		instance.setLogisticsCompany(this.logisticsCompany);
		instance.setLogisticsNum(this.logisticsNum);
		instance.setDivisionId(this.divisionId);
		instance.setProvinceCode(this.provinceCode);
		instance.setProvinceName(this.provinceName);
		instance.setCityCode(this.cityCode);
		instance.setCityName(this.cityName);
		instance.setAreaCode(this.areaCode);
		instance.setAreaName(this.areaName);
		instance.setAddressInfo(this.addressInfo);
		instance.setBackMan(this.backMan);
		instance.setBackTime(this.backTime);
		instance.setProductNum(this.productNum);
		instance.setRealityProductNum(this.realityProductNum);
		instance.setTotalPrice(this.totalPrice);
		instance.setGoodsOwner(this.goodsOwner);
		instance.setReceiveMan(this.receiveMan);
		instance.setPhone(this.phone);
		instance.setWarehouseCode(this.warehouseCode);
		instance.setWarehouseName(this.warehouseName);
		instance.setCreateName(this.createName);
		instance.setOrderType(this.orderType);
		instance.setRelationUserId(this.relationUserId);
		instance.setRelationDepId(this.relationDepId);
		instance.setRelationDepName(this.relationDepName);
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
		if (!(o instanceof BackGoods)) {
			return false;
		}
		BackGoods that = (BackGoods) o;
		return Objects.equals(id, that.id)
        		&& Objects.equals(backNum, that.backNum)
        		&& Objects.equals(associateOrderSn, that.associateOrderSn)
        		&& Objects.equals(backStatus, that.backStatus)
        		&& Objects.equals(organizationId, that.organizationId)
        		&& Objects.equals(organizationName, that.organizationName)
        		&& Objects.equals(storeId, that.storeId)
        		&& Objects.equals(storeName, that.storeName)
        		&& Objects.equals(storeType, that.storeType)
        		&& Objects.equals(logisticsCode, that.logisticsCode)
        		&& Objects.equals(logisticsCompany, that.logisticsCompany)
        		&& Objects.equals(logisticsNum, that.logisticsNum)
        		&& Objects.equals(divisionId, that.divisionId)
        		&& Objects.equals(provinceCode, that.provinceCode)
        		&& Objects.equals(provinceName, that.provinceName)
        		&& Objects.equals(cityCode, that.cityCode)
        		&& Objects.equals(cityName, that.cityName)
        		&& Objects.equals(areaCode, that.areaCode)
        		&& Objects.equals(areaName, that.areaName)
        		&& Objects.equals(addressInfo, that.addressInfo)
        		&& Objects.equals(backMan, that.backMan)
        		&& Objects.equals(backTime, that.backTime)
        		&& Objects.equals(productNum, that.productNum)
        		&& Objects.equals(realityProductNum, that.realityProductNum)
        		&& Objects.equals(totalPrice, that.totalPrice)
        		&& Objects.equals(goodsOwner, that.goodsOwner)
        		&& Objects.equals(receiveMan, that.receiveMan)
        		&& Objects.equals(phone, that.phone)
        		&& Objects.equals(warehouseCode, that.warehouseCode)
        		&& Objects.equals(warehouseName, that.warehouseName)
        		&& Objects.equals(createName, that.createName)
        		&& Objects.equals(orderType, that.orderType)
        		&& Objects.equals(relationUserId, that.relationUserId)
        		&& Objects.equals(relationDepId, that.relationDepId)
        		&& Objects.equals(relationDepName, that.relationDepName)
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
		return Objects.hash(id, backNum, associateOrderSn, backStatus, organizationId, organizationName, storeId, storeName, storeType, logisticsCode, logisticsCompany, logisticsNum, divisionId, provinceCode, provinceName, cityCode, cityName, areaCode, areaName, addressInfo, backMan, backTime, productNum, realityProductNum, totalPrice, goodsOwner, receiveMan, phone, warehouseCode, warehouseName, createName, orderType, relationUserId, relationDepId, relationDepName, sort, status, remarks, updateBy, updateTime, createBy, createTime, tenantId);
	}
	
}