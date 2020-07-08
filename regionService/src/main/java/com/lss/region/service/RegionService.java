package com.lss.region.service;

import com.lss.region.model.Region;

import java.util.List;
import java.util.Map;

public interface RegionService {

    List<Region> list(Map<String, Object> params);

    Integer listCount(Map params);

    Region get(Integer id);

    void insert(Region region);

    void insertBatch(List<Region> list);

    void update(Region region);

    void updateBatch(List<Region> list);

    void updateSelective(Region region);

    void updateValid(Region region);

    void logicDelete(Region region);

    void delete(Integer id);

    void deleteBatch(List<Region> list);

}
