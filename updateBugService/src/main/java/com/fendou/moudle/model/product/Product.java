package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@ApiModel(description = "标准产品")
@Data
public class Product extends BaseModel {

    @ApiModelProperty(value = "UUID")
    private String id;
    @ApiModelProperty(value = "产品编码")
    private String code;
    @ApiModelProperty(value = "原始款号")
    private String originalCode;
    @ApiModelProperty(value = "产品名称")
    private String name;
    @ApiModelProperty(value = "组织机构ID")
    private String organizationId;
    @ApiModelProperty(value = "品牌商ID")
    private String brandOwnerId;
    @ApiModelProperty(value = "品牌商编码")
    private String brandOwnerCode;
    @ApiModelProperty(value = "品牌商名称")
    private String brandOwnerName;
    @ApiModelProperty(value = "品牌商地址")
    private String brandOwnerAddress;
    @ApiModelProperty(value = "品牌ID")
    private String brandId;
    @ApiModelProperty(value = "品牌编码")
    private String brandCode;
    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "打印品牌ID")
    private String tagBrandId;
    @ApiModelProperty(value = "打印品牌编码")
    private String tagBrandCode;
    @ApiModelProperty(value = "打印品牌名称")
    private String tagBrandName;
    @ApiModelProperty(value = "设计商ID")
    private String designCompanyId;
    @ApiModelProperty(value = "设计商编码")
    private String designCompanyCode;
    @ApiModelProperty(value = "设计商名称")
    private String designCompanyName;
    @ApiModelProperty(value = "产品分类ID")
    private String cateId;
    @ApiModelProperty(value = "分类编码")
    private String cateCode;
    @ApiModelProperty(value = "分类名称")
    private String cateName;
    @ApiModelProperty(value = "完整分类名称")
    private String fullCateName;
    @ApiModelProperty(value = "产品分类识别码")
    private String cateIdentifier;
    @ApiModelProperty(value = "面料信息")
    private String fabric;
    @ApiModelProperty(value = "里料信息")
    private String lining;
    @ApiModelProperty(value = "配料信息")
    private String ingredients;
    @ApiModelProperty(value = "填充物信息")
    private String filler;
    @ApiModelProperty(value = "流行年份")
    private String popularYear;
    @ApiModelProperty(value = "季节波段编码")
    private String seasonalStyleCode;
    @ApiModelProperty(value = "季节波段")
    private String seasonalStyle;
    @ApiModelProperty(value = "产品图片")
    private String image;
    @ApiModelProperty(value = "促销信息")
    private String promotionInfo;
    @ApiModelProperty(value = "采购价格（SKU最低价）")
    private BigDecimal purchasePrice;
    @ApiModelProperty(value = "批发价格（SKU最低价）")
    private BigDecimal wholesalePrice;
    @ApiModelProperty(value = "零售价格（SKU最低价）")
    private BigDecimal retailPrice;
    @ApiModelProperty(value = "产品库存")
    private Integer stock;
    @ApiModelProperty(value = "产品销量")
    private Integer salesVolume;
    @ApiModelProperty(value = "产品等级")
    private String level;
    @ApiModelProperty(value = "安全类别")
    private String safetyGrade;
    @ApiModelProperty(value = "执行标准")
    private String performanceStandard;
    @ApiModelProperty(value = "质检人员")
    private String qualityInspector;
    @ApiModelProperty(value = "邮政编码")
    private String postalCode;
    @ApiModelProperty(value = "商品状态")
    private String productStatus;
    @ApiModelProperty(value = "启用规格（0：否，1：是）")
    private Boolean enableSpecifications;
    @ApiModelProperty(value = "是否推荐（0：否，1：是）")
    private Boolean recommend;
    @ApiModelProperty(value = "产品描述")
    private String productDescription;
    @ApiModelProperty(value = "产品详情")
    private String productDetail;
    @ApiModelProperty(value = "是否预售（0：否，1：是）")
    private Boolean presale;
    @ApiModelProperty(value = "是否展示（0：否，1：是）")
    private Boolean show;
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
    @ApiModelProperty(value = "货主标识")
    private String ownerId;
    @ApiModelProperty(value = "货主名称")
    private String ownerName;
    @ApiModelProperty(value = "业务关联用户")
    private String relationUserId;
    @ApiModelProperty(value = "业务关联部门")
    private String relationDepId;
    @ApiModelProperty(value = "租户标识")
    private String tenantId;
    @ApiModelProperty(value = "创建人姓名")
    private String createByName;

    @ApiModelProperty(value = "标准货品列表")
    private List<ProductGoods> productGoodses;
    @ApiModelProperty(value = "产品图片列表")
    private List<ProductImage> productImages;
//    @ApiModelProperty(value = "产品视频列表")
//    private List<ProductVideo> productVideos;
    @ApiModelProperty(value = "产品信息关联信息列表")
    private List<ProductInfoAttr> productInfoAttrs;
    @ApiModelProperty(value = "匹配标签列表")
    private List<ProductTag> productTags;
    @ApiModelProperty(value = "颜色列表")
    private List<String> colors;
    @ApiModelProperty(value = "规格（尺寸）列表")
    private List<String> sizes;

    @Override
    public Product clone() {
        Product instance = new Product();
        instance.setId(this.id);
        instance.setCode(this.code);
        instance.setOriginalCode(this.originalCode);
        instance.setName(this.name);
        instance.setOrganizationId(this.organizationId);
        instance.setBrandOwnerId(this.brandOwnerId);
        instance.setBrandOwnerCode(this.brandOwnerCode);
        instance.setBrandOwnerName(this.brandOwnerName);
        instance.setBrandOwnerAddress(this.brandOwnerAddress);
        instance.setBrandId(this.brandId);
        instance.setBrandCode(this.brandCode);
        instance.setBrandName(this.brandName);
        instance.setTagBrandId(this.tagBrandId);
        instance.setTagBrandCode(this.tagBrandCode);
        instance.setTagBrandName(this.tagBrandName);
        instance.setDesignCompanyId(this.designCompanyId);
        instance.setDesignCompanyCode(this.designCompanyCode);
        instance.setDesignCompanyName(this.designCompanyName);
        instance.setCateId(this.cateId);
        instance.setCateCode(this.cateCode);
        instance.setCateName(this.cateName);
        instance.setFullCateName(this.fullCateName);
        instance.setCateIdentifier(this.cateIdentifier);
        instance.setFabric(this.fabric);
        instance.setLining(this.lining);
        instance.setIngredients(this.ingredients);
        instance.setFiller(this.filler);
        instance.setPopularYear(this.popularYear);
        instance.setSeasonalStyleCode(this.seasonalStyleCode);
        instance.setSeasonalStyle(this.seasonalStyle);
        instance.setImage(this.image);
        instance.setPromotionInfo(this.promotionInfo);
        instance.setPurchasePrice(this.purchasePrice);
        instance.setWholesalePrice(this.wholesalePrice);
        instance.setRetailPrice(this.retailPrice);
        instance.setStock(this.stock);
        instance.setSalesVolume(this.salesVolume);
        instance.setLevel(this.level);
        instance.setSafetyGrade(this.safetyGrade);
        instance.setPerformanceStandard(this.performanceStandard);
        instance.setQualityInspector(this.qualityInspector);
        instance.setPostalCode(this.postalCode);
        instance.setProductStatus(this.productStatus);
        instance.setEnableSpecifications(this.enableSpecifications);
        instance.setRecommend(this.recommend);
        instance.setProductDescription(this.productDescription);
        instance.setProductDetail(this.productDetail);
        instance.setPresale(this.presale);
        instance.setShow(this.show);
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