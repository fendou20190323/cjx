package com.fendou.moudle.mapper;

import com.fendou.moudle.model.product.Color;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ColorMapper {

    List<Color> list(Map<String, Object> params);

    List<Color> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    Color get(String id);

    int insert(Color color);

    int insertBatch(List<Color> list);

    int update(Color color);

    int updateSelective(Color color);

    int updateBatch(List<Color> list);

    int delete(Color color);

    int deleteBatch(List<Color> list);

}