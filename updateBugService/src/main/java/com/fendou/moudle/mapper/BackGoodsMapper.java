package com.fendou.moudle.mapper;

import com.fendou.moudle.model.BackGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BackGoodsMapper {

    List<BackGoods> list(Map<String, Object> params);

    Integer listCount(Map<String, Object> params);

    BackGoods get(String id);

    int insert(BackGoods backGoods);

    int insertBatch(List<BackGoods> list);

    int update(BackGoods backGoods);

    int updateBatch(List<BackGoods> list);

    int updateSelective(BackGoods backGoods);

    int delete(String id);

    /**
     * 根据关联单号获取返货单
     * @param associateOrderSn
     * @return
     */
    BackGoods getByAssociateOrderSn(String associateOrderSn);

    /**
     * 获取返货总数量
     * @param storeId
     * @return
     */
    Object totalReturns(String storeId);

    BackGoods findByAssociateOrderSn(@Param("associateOrderSn") String associateOrderSn);
}