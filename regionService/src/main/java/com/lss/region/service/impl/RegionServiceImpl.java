package com.lss.region.service.impl;

import com.lss.common.base.*;
import com.lss.common.exception.BusinessException;
import com.lss.common.exception.LssErrorMessage;
import com.lss.region.mapper.RegionMapper;
import com.lss.region.model.Region;
import com.lss.region.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = Exception.class)
@Service("regionService")
public class RegionServiceImpl extends BaseServiceImpl implements RegionService {

    private final String MODULE_NAME = "行政区域";
    private final int DELETE_STATUS = 9;

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Region> list(Map<String, Object> params) {
        return regionMapper.list(params);
    }

    @Override
    public Integer listCount(Map params) {
        return regionMapper.listCount(params);
    }

    @Override
    public Region get(Integer id) {
        return regionMapper.get(id);
    }

    @Override
    public void insert(Region region) {
        check(region);
        int affectedRows = regionMapper.insert(region);
        if (affectedRows == 0) {
            throw new BusinessException(MODULE_NAME, LssErrorMessage.NOT_INSERT_CODE, LssErrorMessage.NOT_INSERT_MESSAGE);
        }
    }

    @Override
    public void insertBatch(List<Region> list) {
//        list.forEach(t -> {
//            check(t);
//            t.insertSet();
//        });
        regionMapper.insertBatch(list);
    }

    @Override
    public void update(Region region) {
        check(region);
        int affectedRows = regionMapper.update(region);
        if (affectedRows == 0) {
            throw new BusinessException(MODULE_NAME, LssErrorMessage.NOT_UPDATE_CODE, LssErrorMessage.NOT_UPDATE_MESSAGE);
        }
    }

    @Override
    public void updateBatch(List<Region> list) {
        list.forEach(t -> {
            check(t);
        });
        regionMapper.updateBatch(list);
    }

    @Override
    public void updateSelective(Region region) {
        check(region);
        int affectedRows = regionMapper.updateSelective(region);
        if (affectedRows == 0) {
            throw new BusinessException(MODULE_NAME, LssErrorMessage.NOT_UPDATE_CODE, LssErrorMessage.NOT_UPDATE_MESSAGE);
        }
    }

    @Override
    public void updateValid(Region region) {
        int affectedRows = regionMapper.updateSelective(region);
        if (affectedRows == 0) {
            throw new BusinessException(MODULE_NAME, LssErrorMessage.NOT_UPDATE_CODE, LssErrorMessage.NOT_UPDATE_MESSAGE);
        }
    }

    @Override
    public void logicDelete(Region region) {
        int affectedRows = regionMapper.updateSelective(region);
        if (affectedRows == 0) {
            throw new BusinessException(MODULE_NAME, LssErrorMessage.NOT_DELETE_CODE, LssErrorMessage.NOT_DELETE_MESSAGE);
        }
    }

    @Override
    public void delete(Integer id) {
        regionMapper.delete(id);
    }

    @Override
    public void deleteBatch(List<Region> list) {
        regionMapper.updateBatch(list);
    }

    private void check(Region region) {
    }

}
