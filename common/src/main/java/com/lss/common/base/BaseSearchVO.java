package com.lss.common.base;

import com.lss.common.page.RePagination;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 功能描述
 *
 * @author HuWenhai
 * @title: BaseSearchVO
 * @projectName oasis
 * @description: TODO
 * @date 2019/08/01 12:00
 * @version: v1.0
 */
@Data
public class BaseSearchVO extends RePagination {

    @ApiModelProperty(value = "起始时间")
    protected Timestamp startTime;
    @ApiModelProperty(value = "结束时间")
    protected Timestamp endTime;
    @ApiModelProperty(value = "查询子集")
    protected Boolean subset;
    @ApiModelProperty(value = "有效状态")
    protected Boolean valid;
    @ApiModelProperty(value = "起始创建时间")
    protected Timestamp createTimeStart;
    @ApiModelProperty(value = "结束创建时间")
    protected Timestamp createTimeEnd;
    @ApiModelProperty(value = "起始更新时间")
    protected Timestamp updateTimeStart;
    @ApiModelProperty(value = "结束更新时间")
    protected Timestamp updateTimeEnd;
    @ApiModelProperty(value = "检索关键词")
    protected String searchWords;

}
