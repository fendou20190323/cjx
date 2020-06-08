package com.fendou.moudle.mapper;

import com.fendou.moudle.model.product.ProductBrandOwner;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductBrandOwnerMapper {

    List<ProductBrandOwner> list(Map<String, Object> params);

    List<ProductBrandOwner> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    Integer listCount(Map<String, Object> params);

    ProductBrandOwner get(String id);

    int insert(ProductBrandOwner productBrandOwner);

    int insertBatch(List<ProductBrandOwner> list);

    int update(ProductBrandOwner productBrandOwner);

    int updateBatch(List<ProductBrandOwner> list);

    int updateSelective(ProductBrandOwner productBrandOwner);

    int delete(String id);

}