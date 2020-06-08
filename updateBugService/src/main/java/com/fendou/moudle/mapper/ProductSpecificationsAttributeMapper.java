package com.fendou.moudle.mapper;

import com.fendou.moudle.model.product.ProductSpecificationsAttribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductSpecificationsAttributeMapper {

    List<ProductSpecificationsAttribute> list(Map<String, Object> params);

    List<ProductSpecificationsAttribute> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    Integer listCount(Map<String, Object> params);

    ProductSpecificationsAttribute get(String id);

    void insert(ProductSpecificationsAttribute productSpecificationsAttribute);

    int insertBatch(List<ProductSpecificationsAttribute> list);

    int update(ProductSpecificationsAttribute productSpecificationsAttribute);

    void updateBatch(List<ProductSpecificationsAttribute> list);

    int updateSelective(ProductSpecificationsAttribute productSpecificationsAttribute);

    void delete(String id);

}