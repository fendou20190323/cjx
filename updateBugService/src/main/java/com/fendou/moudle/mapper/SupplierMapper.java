package com.fendou.moudle.mapper;
import com.fendou.moudle.model.product.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SupplierMapper {

    List<Supplier> list(Map<String, Object> params);

    List<Supplier> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    Integer listCount(Map<String, Object> params);

    Supplier get(String id);

    void insert(Supplier supplier);

    void insertBatch(List<Supplier> list);

    int update(Supplier supplier);

    void updateBatch(List<Supplier> list);

    int updateSelective(Supplier supplier);

    void delete(String id);


}