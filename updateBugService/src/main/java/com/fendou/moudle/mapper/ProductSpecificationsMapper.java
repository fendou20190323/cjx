package com.fendou.moudle.mapper;

import com.fendou.moudle.model.product.ProductSpecifications;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductSpecificationsMapper {

    List<ProductSpecifications> list(Map<String, Object> params);

    List<ProductSpecifications> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    Integer listCount(Map<String, Object> params);

    ProductSpecifications get(String id);

    void insert(ProductSpecifications productSpecifications);

    int insertBatch(List<ProductSpecifications> list);

    int update(ProductSpecifications productSpecifications);

    void updateBatch(List<ProductSpecifications> list);

    int updateSelective(ProductSpecifications productSpecifications);

    void delete(String id);

}