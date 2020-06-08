package com.fendou.moudle.controller;

import com.fendou.moudle.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cjx
 * @date 2020/6/5 23:06
 * @description
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/product")
@Api(description = "更新商品")
public class ProductController {
    /**
     * 需要同步的基础数据
     * 品牌商 ------brandOwner √
     * 品牌  -------brand       √
     * 设计商 ------designCompany  √
     * 产品分类 ----cate            √
     * 色系=--------colorSeries  √
     * 颜色---------color        √
     * 尺码---------size
     */
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "更新product表")
    @GetMapping("/updateProduct")
    public String updateProduct() {
        try {
            productService.updateProduct();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "更新ProductBrand表")
    @GetMapping("/updateProductBrand")
    public String updateProductBrand() {
        try {
            productService.updateProductBrand();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "更新Color表")
    @GetMapping("/updateColor")
    public String updateColor() {
        try {
            productService.updateColor();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "更新ColorSeries表")
    @GetMapping("/updateColorSeries")
    public String updateColorSeries() {
        try {
            productService.updateColorSeries();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "更新ProductBrandOwner表")
    @GetMapping("/updateProductBrandOwner")
    public String updateProductBrandOwner() {
        try {
            productService.updateProductBrandOwner();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "更新DesignCompany表")
    @GetMapping("/updateDesignCompany")
    public String updateDesignCompany() {
        try {
            productService.updateDesignCompany();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "更新Categories表")
    @GetMapping("/updateCategories")
    public String updateCategories() {
        try {
            productService.updateCategories();
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
            productService.updateProdcutGoods();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "更新product_specifications表")
    @GetMapping("/updateProductSpecifications")
    public String updateProductSpecifications() {
        try {
            productService.updateProductSpecifications();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "更新product_specifications_attribute表")
    @GetMapping("/updateProductSpecificationsAttribute")
    public String updateProductSpecificationsAttribute() {
        try {
            productService.updateProductSpecificationsAttribute();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }
    @ApiOperation(value = "更新configuration_goods_owner表")
    @GetMapping("/updateConfigurationGoodsOwner")
    public String updateConfigurationGoodsOwner() {
        try {
            productService.updateConfigurationGoodsOwner();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }

    @ApiOperation(value = "(WMS)更新wms_data_inventory表")
    @GetMapping("/updateWmsDataInventory")
    public String updateWmsDataInventory() {
        try {
            productService.updateWmsDataInventory();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败" + e.getMessage();
        }
    }
}
