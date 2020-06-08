package com.fendou.moudle.mapper;

import com.fendou.moudle.model.WarehouseInventory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author daoji.feng
 * @Date 2019/12/10 13:49
 * @ClassName WarehouseInventoryMapper
 * @Description {@code WarehouseInventoryMapper} is warehouse's inventory operate mapping interface.
 **/
public interface WarehouseInventoryMapper {

    List<WarehouseInventory> list(Map<String, Object> params);


    Map<String, Object> summaryStatistics(Map<String, Object> params);

    Integer insertBatch(List<WarehouseInventory> list);

    Integer updateBatch(List<WarehouseInventory> list);

    List<WarehouseInventory> listByProductGoodsCodeSet(Map<String, Object> params);

    List<WarehouseInventory> listByCodeSet(@Param(value = "codes") List<String> codes);

}