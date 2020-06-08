package com.fendou.moudle.dto;

import com.fendou.moudle.model.BaseModel;
import com.fendou.moudle.model.product.ProductGoods;
import com.fendou.moudle.model.product.ProductImage;
import com.fendou.moudle.model.product.ProductInfoAttr;
import com.fendou.moudle.model.product.ProductTag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@ApiModel(description = "标准产品")
@Data
public class ProductDto extends BaseModel {

    @ApiModelProperty(value = "UUID")
    private String id;
    @ApiModelProperty(value = "备注信息")
    private String remarks;

}