package com.fendou.moudle.mapper;

import com.fendou.moudle.model.product.ColorSeries;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ColorSeriesMapper {

    List<ColorSeries> list(Map<String, Object> params);

    List<ColorSeries> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    ColorSeries get(String id);

    int insert(ColorSeries colorSeries);

    int insertBatch(List<ColorSeries> list);

    int update(ColorSeries colorSeries);

    int updateSelective(ColorSeries colorSeries);

    int updateBatch(List<ColorSeries> list);

    int delete(ColorSeries colorSeries);

    int deleteBatch(List<ColorSeries> list);

}