package com.lss.region.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lss.common.base.BaseController;
import com.lss.common.exception.BusinessException;
import com.lss.common.page.PaginationViewModel;
import com.lss.common.result.Result;
import com.lss.common.util.ConvertUtil;
import com.lss.region.model.Region;
import com.lss.region.service.RegionService;
import com.lss.region.vo.search.RegionSearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "行政区域")
@RestController
@RequestMapping("/region")
public class RegionController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegionController.class);

    @Autowired
    private RegionService regionService;

    @ApiOperation(value = "获取行政区域列表", notes = "根据传入参数返回列表信息")
    @PostMapping("/list")
    public Result<PaginationViewModel<Region>> list(@RequestBody RegionSearchVO search) {
        try {
            PageHelper.startPage(search.getPageIndex(), search.getPageSize());
            List<Region> list = regionService.list(ConvertUtil.convertBean2Map(search));
            PageInfo<Region> pageInfo = new PageInfo<>(list);
            PaginationViewModel<Region> paginationViewModel = new PaginationViewModel<>();
            paginationViewModel.setPageIndex(search.getPageIndex());
            paginationViewModel.setPageSize(search.getPageSize());
            paginationViewModel.setTotalCount(pageInfo.getTotal());
            paginationViewModel.setTotalPages(pageInfo.getPages());
            paginationViewModel.setData(list);
            return JsonSuccess(paginationViewModel);
        } catch (BusinessException e) {
            LOGGER.info(getStackTrace(e));
            return JsonError(e.getMessage());
        } catch (Exception e) {
            LOGGER.info(getStackTrace(e));
            return JsonError("获取数据失败");
        }
    }

    @ApiOperation(value = "根据ID获取行政区域实例")
    @GetMapping("/get")
    public Result get(Integer id) {
        try {
            Region region = regionService.get(id);
            return JsonSuccess(region);
        } catch (BusinessException e) {
            LOGGER.info(getStackTrace(e));
            return JsonError(e.getMessage());
        } catch (Exception e) {
            LOGGER.info(getStackTrace(e));
            return JsonError("获取数据失败");
        }
    }

    @ApiOperation(value = "保存行政区域实例")
    @PostMapping("/save")
    public Result save(@RequestBody Region region) {
        try {
            if (region.getId() == null) {
                regionService.insert(region);
            } else {
                regionService.updateSelective(region);
            }
            return JsonSuccess("保存成功");
        } catch (BusinessException e) {
            LOGGER.info(getStackTrace(e));
            return JsonError(e.getMessage());
        } catch (Exception e) {
            LOGGER.info(getStackTrace(e));
            return JsonError("保存失败");
        }
    }

    @ApiOperation(value = "更新行政区域实例有效状态")
    @PostMapping("/updateValid")
    public Result updateValid(@RequestBody Region region) {
        try {
            regionService.updateValid(region);
            return JsonSuccess("修改成功");
        } catch (BusinessException e) {
            LOGGER.info(getStackTrace(e));
            return JsonError(e.getMessage());
        } catch (Exception e) {
            LOGGER.info(getStackTrace(e));
            return JsonError("修改失败");
        }
    }

    @ApiOperation(value = "批量插入行政区域实例")
    @PostMapping("/saveBatch")
    public Result insertBatch(@RequestBody List<Region> list) {
        try {
            if (list != null && list.size() > 0) {
                regionService.insertBatch(list);
            }
            return JsonSuccess("批量插入成功");
        } catch (BusinessException e) {
            LOGGER.info(getStackTrace(e));
            return JsonError(e.getMessage());
        } catch (Exception e) {
            LOGGER.info(getStackTrace(e));
            return JsonError("批量插入失败");
        }
    }

    @ApiOperation(value = "批量更新行政区域实例")
    @PostMapping("/updateBatch")
    public Result updateBatch(@RequestBody List<Region> list) {
        try {
            if (list != null && list.size() > 0) {
                regionService.updateBatch(list);
            }
            return JsonSuccess("批量更新成功");
        } catch (BusinessException e) {
            LOGGER.info(getStackTrace(e));
            return JsonError(e.getMessage());
        } catch (Exception e) {
            LOGGER.info(getStackTrace(e));
            return JsonError("批量更新失败");
        }
    }

    @ApiOperation(value = "逻辑删除行政区域实例")
    @PostMapping("/logicDelete")
    public Result logicDelete(@RequestBody Region region) {
        try {
            regionService.logicDelete(region);
            return JsonSuccess("删除成功");
        } catch (BusinessException e) {
            LOGGER.info(getStackTrace(e));
            return JsonError(e.getMessage());
        } catch (Exception e) {
            LOGGER.info(getStackTrace(e));
            return JsonError("删除失败");
        }
    }

    @ApiOperation(value = "物理删除行政区域实例")
    @DeleteMapping("/delete")
    public Result delete(Integer[] ids) {
        try {
            if (ids != null && ids.length > 0) {
                for (Integer id : ids) {
                    regionService.delete(id);
                }
            }
            return JsonSuccess("删除成功");
        } catch (BusinessException e) {
            LOGGER.info(getStackTrace(e));
            return JsonError(e.getMessage());
        } catch (Exception e) {
            LOGGER.info(getStackTrace(e));
            return JsonError("删除失败");
        }
    }

}
