package com.fendou.moudle.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Cjx
 * @date 2020/6/5 23:08
 * @description
 */
public interface ProductImportCSVService {
    void updateProduct();

    void updateProductBrand(MultipartFile file) throws IOException;

    void updateColor(MultipartFile file) throws IOException;

    void updateColorSeries();

    void updateProductBrandOwner(MultipartFile file) throws IOException;

    void updateDesignCompany();

    void updateCategories(MultipartFile file) throws IOException;

    void updateProdcutGoods();

    void updateProductSpecifications(MultipartFile speicifi,MultipartFile cate) throws IOException;

    void updateProductSpecificationsAttribute();

    void updateConfigurationGoodsOwner();

    void updateWmsDataInventory();

}
