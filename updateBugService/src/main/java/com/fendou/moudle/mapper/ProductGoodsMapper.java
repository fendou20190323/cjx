package com.fendou.moudle.mapper;

import com.fendou.moudle.model.WarehouseInventory;
import com.fendou.moudle.model.product.ProductGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductGoodsMapper {

    List<ProductGoods> list(Map<String, Object> params);

    Integer listCount(Map<String, Object> params);

    List<ProductGoods> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);


    Integer listProductGoodsCount(Map<String, Object> params);


    Integer listAvailableQuantityForProductGoodsCount(Map<String, Object> params);

    ProductGoods get(String id);


    void insert(ProductGoods productGoods);

    void insertBatch(List<ProductGoods> list);

    int update(ProductGoods productGoods);

    void updateBatch(List<ProductGoods> list);

    int updateSelective(ProductGoods productGoods);

    void delete(String id);


    List<ProductGoods> findBySPUCodes(Map<String, Object> params);

    List<ProductGoods> findByOwnerName(Map<String, Object> params);

    List<String> findSKUByStoreName(Map<String, Object> params);

    List<ProductGoods> findBySKUCodes(Map<String, Object> params2);

    List<String> queryWms(Map<String, Object> params);

    List<WarehouseInventory> listWMSInventory(Map<String, Object> params);

    int insertBatchWMSInventory(List<WarehouseInventory> list);
}