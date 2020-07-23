package com.fendou.moudle.controller;

import com.fendou.moudle.service.ProductImportCSVService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: cjx
 * @Date: 2020-07-18 09:22
 * @Description;
 */
@RestController
@RequestMapping("/productImport")
@Api(description = "更新商品")
public class ProductImportCSVController {
    @Autowired
    private ProductImportCSVService productImportCSVService;
    /**
     * 需要同步的基础数据
     * 品牌商 ------brandOwner
     * 品牌  -------brand       √
     * 设计商 ------designCompany
     * 产品分类 ----cate            √
     * 色系=--------colorSeries
     * 颜色---------color         √
     * 尺码---------size
     * 供应商------supplier
     */
    @ApiOperation(value = "更新ProductBrand表")
    @PostMapping("/updateProductBrand")
    public String updateProductBrand(@RequestBody MultipartFile file) {
        try {
            productImportCSVService.updateProductBrand(file);
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "更新Categories表")
    @PostMapping("/updateCategories")
    public String updateCategories(@RequestBody MultipartFile file) {
        try {
            productImportCSVService.updateCategories(file);
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }
    @ApiOperation(value = "更新Color表")
    @PostMapping("/updateColor")
    public String updateColor(@RequestBody MultipartFile file) {
        try {
            productImportCSVService.updateColor(file);
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }
    @ApiOperation(value = "更新Supplier表")
    @PostMapping("/updateSupplier")
    public String updateSupplier(@RequestBody MultipartFile file) {
        try {
            productImportCSVService.updateSupplier(file);
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }
    @ApiOperation(value = "更新ProductGoods表")
    @GetMapping("/updateProdcutGoods")
    public String updateProdcutGoods() {
        try {
            productImportCSVService.updateProdcutGoods();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }
//
//    @ApiOperation(value = "更新product_specifications表")
//    @PostMapping("/updateProductSpecifications")
//    public String updateProductSpecifications(@RequestBody MultipartFile speicifi,@RequestBody MultipartFile cate) {
//        try {
//            productImportCSVService.updateProductSpecifications(speicifi,cate);
//            return "成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "失败" + e.getMessage();
//        }
//    }

//    @ApiOperation(value = "更新ProductBrandOwner表")
//    @PostMapping("/updateProductBrandOwner")
//    public String updateProductBrandOwner(@RequestBody MultipartFile file) {
//        try {
//            productImportCSVService.updateProductBrandOwner(file);
//            return "成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "失败" + e.getMessage();
//        }
//    }

}
