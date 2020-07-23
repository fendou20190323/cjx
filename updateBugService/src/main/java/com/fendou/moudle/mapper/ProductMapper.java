package com.fendou.moudle.mapper;

import com.fendou.moudle.dto.ProductDto;
import com.fendou.moudle.model.product.Product;
import com.fendou.moudle.model.product.ProductGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    List<Product> list(Map<String, Object> params);

    List<Product> autoComplete(@Param(value = "term") String term, @Param(value = "tenantId") String tenantId);

    Integer listCount(Map<String, Object> params);

//    List<ProductVO> listProduct(Map<String, Object> params);

    Integer listProductCount(Map<String, Object> params);

    List<Product> listAvailableQuantityForProduct(Map<String, Object> params);

    Integer listAvailableQuantityForProductCount(Map<String, Object> params);

    Product get(String id);

//    ProductDTO getByPrimaryKey(String id);

    int insert(Product product);

    int insertBatch(List<Product> list);

    int update(Product product);

    int updateBatch(List<Product> list);

    int updateSelective(Product product);

    int delete(String id);

//    List<ProductDTO> listByVideoId(@Param(value = "tenantId") String tenantId, @Param(value = "videoId") String videoId);
//
//    ProductDTO getByCode(@Param(value = "tenantId") String tenantId, @Param(value = "code") String code);

    Product getByOriginalCode(@Param(value = "tenantId") String tenantId, @Param(value = "originalCode") String originalCode);

//    List<ProductDTO> listByCodes(@Param(value = "tenantId") String tenantId, @Param(value = "codes") List<String> codes, @Param(value = "pageStart") int pageStart, @Param(value = "pageSize") int pageSize, @Param(value = "isShow") Boolean isShow);

    Integer listCountByCodes(@Param(value = "tenantId") String tenantId, @Param(value = "codes") List<String> codes, @Param(value = "isShow") Boolean isShow);

//    List<ProductDTO> list4Feign(Map<String, Object> params);

    Integer listCount4Feign(Map<String, Object> params);

    List<String> listCodeByProducts(@Param(value = "tenantId") String tenantId, @Param(value = "products") List<Product> products);

    List<String> listAllCode4Feign(@Param(value = "tenantId") String tenantId, @Param(value = "channelId") String channelId, @Param(value = "validStock") Boolean validStock);

//    List<ProductDTO> listByOwnerAndSearchWords(Map<String, Object> params);
//
//    List<ProductDTO> baseFeignQueries(Map<String, Object> params);
//
//    ProductDTO findProductCompleteInfoByTenantAndCode(@Param(value = "tenantId") String tenantId, @Param(value = "code") String code);

    List<String> listByOwnerAndCodeSet(Map<String, Object> params);

    List<String> findByBrands(Map<String, Object> params);

    List<ProductDto> listIdAndRemark(Map<String, Object> map);



//    List<ProductItemShare> listProduct4Share(Map<String, Object> params);

}