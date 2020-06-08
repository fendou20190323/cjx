package com.fendou.moudle.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author daoji.feng
 * @Date 2019/12/10 10:58
 * @ClassName WarehouseInventory
 * @Description {@code WarehouseInventory} is warehouse inventory database object.
 **/
@ApiModel(description = "商品库存明细信息")
@Data
public class WarehouseInventory extends BaseModel {

    @ApiModelProperty(value = "UUID")
    private String id;
    @ApiModelProperty(value = "租户标识")
    private String tenantId;
    @ApiModelProperty(value = "货品款号")
    private String productCode;
    @ApiModelProperty(value = "货品编码")
    private String productGoodsCode;
    @ApiModelProperty(value = "仓库编码")
    private String warehouseCode;
    @ApiModelProperty(value = "货主标识")
    private String ownerId;
    @ApiModelProperty(value = "货主名称")
    private String ownerName;
    @ApiModelProperty(value = "库存总量")
    private Long totalQuantity;
    @ApiModelProperty(value = "可用数量")
    private Long availableQuantity;
    @ApiModelProperty(value = "锁定数量")
    private Long blockedQuantity;
    @ApiModelProperty(value = "库存状态（0：未知，1：合格，2：残次）")
    private Integer inventoryStatus;
    @ApiModelProperty(value = "库存状态（0：未知，1：合格，2：残次）")
    private String inventoryStatusName;
    @ApiModelProperty(value = "业务关联用户")
    private String relationUserId;
    @ApiModelProperty(value = "业务关联部门")
    private String relationDepId;
    @ApiModelProperty(value = "备注信息")
    private String remarks;
    @ApiModelProperty(value = "状态信息")
    private Integer status;
    @ApiModelProperty(value = "创建人员标识")
    private String createBy;
    @ApiModelProperty(value = "创建人员名称")
    private String creatorName;
    @ApiModelProperty(value = "更新人员标识")
    private String updateBy;
    @ApiModelProperty(value = "更新人员名称")
    private String updatorName;
    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;
    @ApiModelProperty(value = "更新时间")
    private Timestamp updateTime;

}