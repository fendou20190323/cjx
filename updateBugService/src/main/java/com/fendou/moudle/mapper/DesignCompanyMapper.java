package com.fendou.moudle.mapper;

import com.fendou.moudle.model.product.DesignCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DesignCompanyMapper {

    List<DesignCompany> list(Map<String, Object> params);

    Integer listCount(Map<String, Object> params);

    List<DesignCompany> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    DesignCompany get(String id);

    int insert(DesignCompany designCompany);

    int insertBatch(List<DesignCompany> list);

    int update(DesignCompany designCompany);

    int updateBatch(List<DesignCompany> list);

    int updateSelective(DesignCompany designCompany);

    int delete(String id);

}