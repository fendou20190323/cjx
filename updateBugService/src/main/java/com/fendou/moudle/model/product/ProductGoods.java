package com.fendou.moudle.model.product;

import com.fendou.moudle.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@ApiModel(description = "标准货品")
@Data
public class ProductGoods extends BaseModel {

    @ApiModelProperty(value = "UUID")
    private String id;
    @ApiModelProperty(value = "产品编码")
    private String productCode;
    @ApiModelProperty(value = "货品编码")
    private String code;
    @ApiModelProperty(value = "货品名称")
    private String name;
    @ApiModelProperty(value = "货品条码")
    private String barcode;
    @ApiModelProperty(value = "货品类型（1：成衣，2：样衣）")
    private Integer type;
    @ApiModelProperty(value = "货品图片")
    private String image;
    @ApiModelProperty(value = "色系ID")
    private String colorSeriesId;
    @ApiModelProperty(value = "色系编码")
    private String colorSeriesCode;
    @ApiModelProperty(value = "色系")
    private String colorSeries;
    @ApiModelProperty(value = "颜色编码")
    private String colorCode;
    @ApiModelProperty(value = "颜色")
    private String color;
    @ApiModelProperty(value = "尺码编码")
    private String sizeCode;
    @ApiModelProperty(value = "尺码")
    private String size;
    @ApiModelProperty(value = "尺码属性")
    private String sizeAttribute;
    @ApiModelProperty(value = "规格信息")
    private String specifications;
    @ApiModelProperty(value = "促销信息")
    private String promotionInfo;
    @ApiModelProperty(value = "产品ID")
    private String productId;
    @ApiModelProperty(value = "采购价格")
    private BigDecimal purchasePrice;
    @ApiModelProperty(value = "批发价格")
    private BigDecimal wholesalePrice;
    @ApiModelProperty(value = "零售价格")
    private BigDecimal retailPrice;
    @ApiModelProperty(value = "货品库存")
    private Long stock;
    @ApiModelProperty(value = "库存预警（0：否，1：是）")
    private Boolean stockEarlyWarning;
    @ApiModelProperty(value = "预警最小阈值")
    private Integer minThreshold;
    @ApiModelProperty(value = "预警最大阈值")
    private Integer maxThreshold;
    @ApiModelProperty(value = "默认货品（0：否，1：是）")
    private Boolean defaultGoods;
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

    @ApiModelProperty(value = "货品品牌")
    private String tagBrandName;
    @ApiModelProperty(value = "货品分类")
    private String fullCateName;

//    @ApiModelProperty(value = "货品规格关联信息列表")
//    private List<ProductGoodsSpecifications> productGoodsSpecifications;

}