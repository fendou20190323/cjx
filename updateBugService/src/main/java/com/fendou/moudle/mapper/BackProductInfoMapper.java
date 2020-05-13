package com.fendou.moudle.mapper;


import com.fendou.moudle.model.BackProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BackProductInfoMapper {

    List<BackProductInfo> list(Map<String, Object> params);

    Integer listCount(Map<String, Object> params);

    BackProductInfo get(String id);

    int insert(BackProductInfo backProductInfo);

    int insertBatch(List<BackProductInfo> list);

    int update(BackProductInfo backProductInfo);

    int updateBatch(List<BackProductInfo> list);

    int updateSelective(BackProductInfo backProductInfo);

    int delete(String id);

    /**
     * 应返数量
     * @param orderSn
     * @return
     */
    int planBackQuantity(String orderSn);

    /**
     * 应返商品款号统计
     * @param orderSn
     * @return
     */
    int productStatistics(String orderSn);

    /**
     * 应返商品货号统计
     * @param orderSn
     * @return
     */
    int goodsStatistics(String orderSn);

    /**
     * 实返数量
     * @param orderSn
     * @return
     */
    int realityBackQuantity(String orderSn);

    /**
     * 实返款号统计
     * @param orderSn
     * @return
     */
    int realProductStatistics(String orderSn);

    /**
     * 实返货号统计
     * @param orderSn
     * @return
     */
    int realGoodsStatistics(String orderSn);

    /**
     * 获取一条实发数量
     * @param orderSn
     * @return
     */
    List<BackProductInfo> realityBackQtyByOrderSn(String orderSn);

    List<BackProductInfo> findInfoByOrderSn(@Param("orderSn") String orderSn);
}