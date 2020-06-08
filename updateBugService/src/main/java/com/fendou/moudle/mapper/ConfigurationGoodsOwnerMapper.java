package com.fendou.moudle.mapper;


import com.fendou.moudle.model.ConfigurationGoodsOwner;

import java.util.List;
import java.util.Map;

public interface ConfigurationGoodsOwnerMapper {

    List<ConfigurationGoodsOwner> list(Map<String, Object> params);

    Integer listCount(Map<String, Object> params);

    ConfigurationGoodsOwner get(String id);

    int insert(ConfigurationGoodsOwner configurationGoodsOwner);

    int insertBatch(List<ConfigurationGoodsOwner> list);

    int update(ConfigurationGoodsOwner configurationGoodsOwner);

    int updateBatch(List<ConfigurationGoodsOwner> list);

    int updateSelective(ConfigurationGoodsOwner configurationGoodsOwner);

    int delete(String id);

}