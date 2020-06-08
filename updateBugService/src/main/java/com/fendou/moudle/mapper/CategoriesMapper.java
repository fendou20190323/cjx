package com.fendou.moudle.mapper;

import com.fendou.moudle.model.product.Categories;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoriesMapper {

    List<Categories> list(Map<String, Object> params);

    Integer listCount(Map<String, Object> params);

    List<Categories> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    Categories get(String id);

    int insert(Categories categories);

    int insertBatch(List<Categories> list);

    int update(Categories categories);

    int updateBatch(List<Categories> list);

    int updateSelective(Categories categories);

    int delete(String id);

}