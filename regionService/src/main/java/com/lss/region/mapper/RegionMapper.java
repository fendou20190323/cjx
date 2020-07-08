package com.lss.region.mapper;

import com.lss.region.model.Region;

import java.util.List;
import java.util.Map;

public interface RegionMapper {

    List<Region> list(Map<String, Object> params);

    Integer listCount(Map<String, Object> params);

    Region get(Integer id);

    int insert(Region region);

    int insertBatch(List<Region> list);

    int update(Region region);

    int updateBatch(List<Region> list);

    int updateSelective(Region region);

    int delete(Integer id);

}