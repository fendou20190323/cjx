package com.fendou.moudle.mapper;

import com.fendou.moudle.model.product.ProductBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductBrandMapper {

    List<ProductBrand> list(Map<String, Object> params);

    List<ProductBrand> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    List<ProductBrand> listForCate(Map<String, Object> params);

    Integer listCount(Map<String, Object> params);

    Integer listForCateCount(Map<String, Object> params);

    ProductBrand get(String id);

    void insert(ProductBrand productBrand);

    int insertBatch(List<ProductBrand> list);

    int update(ProductBrand productBrand);

    void updateBatch(List<ProductBrand> list);

    int updateSelective(ProductBrand productBrand);

    void delete(String id);

}