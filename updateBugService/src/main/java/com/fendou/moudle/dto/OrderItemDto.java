package com.fendou.moudle.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author daoji.feng
 * @Date 2019/12/7 15:25
 * @ClassName OrderItemDto
 * @Description 订单调配中心订单商品明细DTO
 **/
@Data
public class OrderItemDto implements Serializable, Cloneable {

    /**
     * 商品款号
     */
    @NotBlank(message = "商品货号不可为空")
    private String productCode;

    /**
     * 商品货号
     */
    @NotBlank(message = "商品款号不可为空")
    private String goodsCode;
    /**
     *
     */
    @NotBlank(message = "商品名称不能为空")
    private String productGoodsName;
    /**
     *
     */
    @NotBlank(message = "商品品类不能为空")
    private String cateName;
    /**
     * 供应商编码
     */
    private String supplyCode;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 商品颜色
     */
    private String color;

    /**
     * 商品规格
     */
    private String specification;

    /**
     * 商品品牌
     */
    private String brand;
    /**
     *
     */
    @NotBlank(message = "商品品牌不能为空")
    private String brandCode;
    /**
     * 商品数量
     */
    @NotNull(message = "商品数量不可为空")
    private Integer orderQuantity;
    /**
     *
     */
    @NotBlank(message = "商品尺码不能为空")
    private String sizeName;
    /**
     * 商品等级，1 正品 2 残次品
     */
    private Integer skuLevel;

}
