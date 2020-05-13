package com.fendou.moudle.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author daoji.feng
 * @Date 2019/12/7 15:25
 * @ClassName ReceiveOrderDto
 * @Description 调配中心收货单DTO
 **/
@Data
public class ReceiveOrderDto implements Serializable, Cloneable {

    /**
     * 租户UUID
     */
    @NotBlank(message = "租户UUID不可为空")
    private String tenantId;

    /**
     * 单号
     */
    @NotBlank(message = "订单号不可为空")
    private String orderSn;

    /**
     * 单据类型
     */
    @NotBlank(message = "单据类型不可为空")
    private String orderType;

    /**
     * 单据来源
     */
    @NotBlank(message = "单据来源不可为空")
    private String orderSource;

    /**
     * 收货仓库
     */
    @NotBlank(message = "收货仓库不可为空")
    private String warehouseCode;

    /**
     * 收货仓库
     */
    private String warehouseName;

    /**
     * 货主
     */
    private String goodsOwner;

    /**
     * 承运商
     */
    private String logisticsCode;

    /**
     * 承运单号
     */
    private String logisticsSn;

    /**
     * 收货详情
     */
    @NotEmpty(message = "收货单明细不可为空")
    private List<OrderItemDto> orderItemDtoList;

    /**
     * 收货备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Timestamp createTime;

}
