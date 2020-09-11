package com.fendou.modle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: cjx
 * @Date: 2020-09-10 10:59
 * @Description; u+商品同步到es，sku维度
 */
@Data
@Document(indexName = "productgoods", type = "uplus")
public class UPlusProductGoodsSynESDTO implements Serializable {

    @Id
    @ApiModelProperty(value = "skuId")
    private String productGoodsId;

    @ApiModelProperty(value = "spuId")
    private String productId;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "产品编码")
    private String productCode;

    @ApiModelProperty(value = "货品编码")
    private String code;

    @ApiModelProperty(value = "货品名称")
    private String name;

    @ApiModelProperty(value = "商品编号")
    private String numbering;

    @ApiModelProperty(value = "spu货品图片")
    private List<String> productImages;

    @ApiModelProperty(value = "sku货品图片")
    private String image;

    @ApiModelProperty(value = "颜色")
    private String color;

    @ApiModelProperty(value = "尺码")
    private String size;

    @ApiModelProperty(value = "零售价格")
    private BigDecimal retailPrice;

    @ApiModelProperty(value = "折扣类型")
    private String discountType;

    @ApiModelProperty(value = "折扣值")
    private String discountValue;

    @ApiModelProperty(value = "商品信息")
    private String productInfos;

    @ApiModelProperty(value = "商品详情图片")
    private String productInfoImage;

    @ApiModelProperty(value = "有效状态（0：否，1：是）")
    private Boolean valid;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;

    @ApiModelProperty(value = "租户ID")
    private String tenantId;

}
