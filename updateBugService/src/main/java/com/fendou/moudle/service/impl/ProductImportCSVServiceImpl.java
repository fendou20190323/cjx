package com.fendou.moudle.service.impl;

import com.fendou.moudle.dto.ProductDto;
import com.fendou.moudle.mapper.*;
import com.fendou.moudle.model.ConfigurationGoodsOwner;
import com.fendou.moudle.model.WarehouseInventory;
import com.fendou.moudle.model.product.*;
import com.fendou.moudle.service.ProductImportCSVService;
import com.fendou.moudle.service.ProductService;
import com.lss.common.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Cjx
 * @date 2020/6/5 23:08
 * @description
 */
@SuppressWarnings("ALL")
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductImportCSVServiceImpl implements ProductImportCSVService {


    /**
     * 需要同步的基础数据
     * 品牌商 ------brandOwner
     * 品牌  -------brand
     * 设计商 ------designCompany
     * 产品分类 ----cate
     * 色系=--------colorSeries
     * 颜色---------color
     * 尺码---------size
     */

//e41e5f3c-0d24-4ac2-9cf3-38b0ae53c001 （生产中台）
//                                              e41e5f3c-0d24-4ac2-9cf3-38b0ae53c001
    //音色
//    private static final String NEW_TENANTID = "34f9c86f-d585-40fc-b4be-d559da546e6d";
//    测试
    private final String NEW_TENANTID = "6948ba36-0ad5-4024-b0ce-7784173d0e06";
    @Autowired
    private ProductBrandMapper productBrandMapper;


    private Map<String, Object> createParams() {
        Map<String, Object> params = new HashMap<>();
        params.put("tenantId", "9889d4ed-dea4-11e9-a898-0242ac110002");
        return params;
    }

    /**
     * 修改product表
     */
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void updateProduct() {
        Map<String, Object> newParams = createParams();
        newParams.put("tenantId", NEW_TENANTID);
        //根据租户id查原数据  500条一查
        Integer integer = productMapper.listCount(createParams());
        int i = integer.intValue();
        //查询品牌
        List<ProductBrand> brandList = productBrandMapper.list(newParams);
        //查询品牌商
        List<ProductBrandOwner> productBrandOwnerList = productBrandOwnerMapper.list(newParams);
        //查询设计商
        List<DesignCompany> designCompanyList = designCompanyMapper.list(newParams);
        //分类
        List<Categories> categoriesList = categoriesMapper.list(newParams);
//        productBrandOwnerList.stream().filter(bo -> bo.getRemarks().split(":")[1].equals(lss.getBrandOwnerId())).collect(Collectors.toList()).get(0).getId();
        for (ProductBrandOwner owner : productBrandOwnerList) {
            String s = owner.getRemarks().split(":")[1];
            System.err.println(s);
        }
        if (i > 500) {
            int ceil = (int) Math.ceil(i / (500 * 1.0));
            for (int j = 0; j < ceil; j++) {
                Map<String, Object> params = createParams();
                params.put("pageStart", j * 500);
                params.put("pageSize", 500);
                List<Product> lssList = productMapper.list(params);
                int oldSize = lssList.size();
                lssList.stream().forEach(lss -> {
                    if (lss.getBrandId() != null && !"".equals(lss.getTagBrandId().trim())) {
                        String brandId = brandList.stream().filter(b -> b.getRemarks().split(":")[1].equals(lss.getBrandId())).collect(Collectors.toList()).get(0).getId();
                        lss.setBrandId(brandId);
                    }
                    if (lss.getBrandOwnerId() != null && !"".equals(lss.getBrandOwnerId().trim())) {
                        String brandOwnerId = productBrandOwnerList.stream().filter(bo -> bo.getRemarks().split(":")[1].equals(lss.getBrandOwnerId())).collect(Collectors.toList()).get(0).getId();
                        lss.setBrandOwnerId(brandOwnerId);
                    }
                    if (lss.getDesignCompanyId() != null && !"".equals(lss.getDesignCompanyId().trim())) {
                        String designCompanyId = designCompanyList.stream().filter(bo -> bo.getRemarks().split(":")[1].equals(lss.getDesignCompanyId())).collect(Collectors.toList()).get(0).getId();
                        lss.setDesignCompanyId(designCompanyId);
                    }
                    if (lss.getCateId() != null && !"".equals(lss.getCateId().trim())) {
                        String cateId = categoriesList.stream().filter(bo -> bo.getRemarks().split(":")[1].equals(lss.getCateId())).collect(Collectors.toList()).get(0).getId();
                        lss.setCateId(cateId);
                    }
                    if (lss.getTagBrandId() != null && !"".equals(lss.getTagBrandId().trim())) {
                        String tagBrandId = brandList.stream().filter(b -> b.getRemarks().split(":")[1].equals(lss.getTagBrandId())).collect(Collectors.toList()).get(0).getId();
                        lss.setTagBrandId(tagBrandId);
                    }
                    lss.insertSet();
                });
                //保存
                int row = productMapper.insertBatch(lssList);
                if (oldSize != row) throw new RuntimeException("与原数据不等");
            }

        } else {
            List<Product> lssList = productMapper.list(createParams());
            int oldSize = lssList.size();
            lssList.stream().forEach(lss -> {
                String brandId = brandList.stream().filter(b -> b.getRemarks().split(":")[1].equals(lss.getBrandId())).collect(Collectors.toList()).get(0).getId();
                lss.setBrandId(brandId);
                String brandOwnerId = productBrandOwnerList.stream().filter(bo -> bo.getRemarks().split(":")[1].equals(lss.getBrandOwnerId())).collect(Collectors.toList()).get(0).getId();
                lss.setBrandOwnerId(brandOwnerId);
                String designCompanyId = designCompanyList.stream().filter(bo -> bo.getRemarks().split(":")[1].equals(lss.getDesignCompanyId())).collect(Collectors.toList()).get(0).getId();
                lss.setDesignCompanyId(designCompanyId);
                String cateId = categoriesList.stream().filter(bo -> bo.getRemarks().split(":")[1].equals(lss.getCateId())).collect(Collectors.toList()).get(0).getId();
                lss.setCateId(cateId);
                String tagBrandId = brandList.stream().filter(b -> b.getRemarks().split(":")[1].equals(lss.getTagBrandId())).collect(Collectors.toList()).get(0).getId();
                lss.setTagBrandId(tagBrandId);
                lss.insertSet();
            });
            //保存
            int row = productMapper.insertBatch(lssList);
            if (oldSize != row) throw new RuntimeException("与原数据不等");
        }
    }

    /**
     * 品牌
     */
    @Override
    public void updateProductBrand(MultipartFile file) throws IOException {
        ExcelUtil excelUtil = new ExcelUtil(ProductBrand.class);
        List<ProductBrand> list = excelUtil.importExcel("", file.getInputStream());
        list.stream().forEach(t -> {
            t.insertSet();
            t.setType(t.getType() == 1 ? 0 : 1);
            t.setCooperation(true);
            t.setValid(true);
        });
        productBrandMapper.insertBatch(list);
    }


    /**
     * 更新颜色
     */
    @Autowired
    private ColorMapper colorMapper;

    @Override
    public void updateColor(MultipartFile file) throws IOException {
        ExcelUtil excelUtil = new ExcelUtil(Color.class);
        List<Color> list = excelUtil.importExcel("", file.getInputStream());
        list.stream().forEach(t -> {
            ColorSeries colorSeries = colorSeriesMapper.findByName(t.getSeriesName(), NEW_TENANTID);
            t.insertSet();
            t.setSeriesCode(colorSeries.getCode());
            t.setSeriesId(colorSeries.getId());
            t.setValid(true);
        });
        colorMapper.insertBatch(list);
    }


    /**
     * 更新色系
     */
    @Autowired
    private ColorSeriesMapper colorSeriesMapper;

    @Override
    public void updateColorSeries() {
        List<ColorSeries> lssList = colorSeriesMapper.list(createParams());
        int oldSize = lssList.size();
        lssList.stream().forEach(lss -> {
            lss.insertSet();
        });
        int row = colorSeriesMapper.insertBatch(lssList);
        if (oldSize != row) throw new RuntimeException("与原数据不等");
    }

    /**
     * 更新品牌商
     */
    @Autowired
    private ProductBrandOwnerMapper productBrandOwnerMapper;

    @Override
    public void updateProductBrandOwner(MultipartFile file) throws IOException {
        ExcelUtil excelUtil = new ExcelUtil(ProductBrand.class);
        List<ProductBrandOwner> list = excelUtil.importExcel("", file.getInputStream());
        list.stream().forEach(t -> {
            t.insertSet();
            t.setCooperation(true);
            t.setValid(true);
            t.setRecommend(true);
        });
        productBrandOwnerMapper.insertBatch(list);
    }

    /**
     * 更新设计商
     */
    @Autowired
    private DesignCompanyMapper designCompanyMapper;

    @Override
    public void updateDesignCompany() {
        List<DesignCompany> lssList = designCompanyMapper.list(createParams());
        int oldSize = lssList.size();
        lssList.stream().forEach(lss -> {
            lss.insertSet();
        });
        int row = designCompanyMapper.insertBatch(lssList);
        if (oldSize != row) throw new RuntimeException("与原数据不等");
    }

    /**
     * 更新分类
     */
    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public void updateCategories(MultipartFile file) throws IOException {
        ExcelUtil excelUtil = new ExcelUtil(Categories.class);
        List<Categories> list = excelUtil.importExcel("", file.getInputStream());
        List<Categories> insertList = new LinkedList<>();
        insertList.addAll(list);
        /**
         * identifier
         * level
         * parentName
         * fullCateName
         * type=1
         * */
        Map<String, String> map = new HashMap<>();
        for (Categories c : insertList) {
            String orignalId = c.getId();
            c.insertSet();
            map.put(orignalId, c.getId());
        }
        insertList.stream().forEach(t -> {
            String newId = map.get(t.getParentId());
            t.setParentId(newId);
            if (t.getLevel() == 1) {
                t.setFullCateName(t.getName());
            }
            t.setType(1);
            t.setValid(true);

        });
        categoriesMapper.insertBatch(insertList);
    }

    @Autowired
    private ProductGoodsMapper productGoodsMapper;

    @Override
    public void updateProdcutGoods() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("tenantId", NEW_TENANTID);
//        List<Product> productList = productMapper.list(map);
        List<Color> colorList = colorMapper.list(map);
//        List<ColorSeries> colorSeriesList = colorSeriesMapper.list(map);
        Integer size = productGoodsMapper.listCount(map);
        int ceil = (int)Math.ceil((1.0*size/1000));
        for (int i = 0; i < ceil; i++) {
            map.put("pageStart", i*1000);
            map.put("pageSize", i*1000+1000);
            List<ProductGoods> productGoodsList = productGoodsMapper.list(map);
            productGoodsList.stream().forEach(t -> {
                Color color = colorList.stream().filter(c -> c.getName().equals(t.getColor())).collect(Collectors.toList()).get(0);
                t.setColorSeriesId(color.getSeriesId());
                t.setColorSeries(color.getSeriesName());
                t.setColorCode(color.getCode());
            });
        productGoodsMapper.updateBatch(productGoodsList);
        }


    }

    @Autowired
    private ProductSpecificationsMapper productSpecificationsMapper;

    @Override
    public void updateProductSpecifications(MultipartFile speicifi, MultipartFile cate) throws IOException {
        ExcelUtil speiExcelUtil = new ExcelUtil(ProductSpecifications.class);
        ExcelUtil cateExcelUtil = new ExcelUtil(Categories.class);
        List<ProductSpecifications> speiList = speiExcelUtil.importExcel("", speicifi.getInputStream());
        List<Categories> cateList = cateExcelUtil.importExcel("", cate.getInputStream());

        speiList.stream().forEach(t -> {
            Categories oldCate = cateList.stream().filter(c -> c.getId().equals(t.getCateId())).collect(Collectors.toList()).get(0);
//            Categories newCate = categoriesMapper.findByCode(oldCate.getCode(),NEW_TENANTID);
            t.insertSet();
//            t.setCateId(newCate.getId());
//            t.setCateName(newCate.getName());
//            t.setCateIdentifier(newCate.getIdentifier());

            t.setValid(true);
        });
        productSpecificationsMapper.insertBatch(speiList);
    }

    @Autowired
    private ProductSpecificationsAttributeMapper productSpecificationsAttributeMapper;

    @Override
    public void updateProductSpecificationsAttribute() {
        Map<String, Object> params1 = createParams();
        params1.put("tenantId", NEW_TENANTID);
        List<ProductSpecifications> productSpecificationsList = productSpecificationsMapper.list(params1);
        if (null == productSpecificationsList || productSpecificationsList.size() == 0) {
            throw new RuntimeException("ProductSpecifications没有数据");
        }
        List<ProductSpecificationsAttribute> lssList = productSpecificationsAttributeMapper.list(createParams());
        int oldSize = lssList.size();
        lssList.stream().forEach(lss -> {
            if (null != lss.getSpecificationsId() && !"".equals(lss.getSpecificationsId().trim())) {
                String prspecId = productSpecificationsList.stream().filter(p -> p.getRemarks().split(":")[1].equals(lss.getSpecificationsId())).collect(Collectors.toList()).get(0).getId();
                lss.setSpecificationsId(prspecId);
            }
            lss.insertSet();
        });
        int row = productSpecificationsAttributeMapper.insertBatch(lssList);
        if (oldSize != row) throw new RuntimeException("与原数据不等");
    }

    @Autowired
    private ConfigurationGoodsOwnerMapper configurationGoodsOwnerMapper;

    @Override
    public void updateConfigurationGoodsOwner() {
        List<ConfigurationGoodsOwner> lssList = configurationGoodsOwnerMapper.list(createParams());
        int oldSize = lssList.size();
        lssList.stream().forEach(lss -> {
            lss.insertSet();
        });
        int row = configurationGoodsOwnerMapper.insertBatch(lssList);
        if (oldSize != row) throw new RuntimeException("与原数据不等");
    }


    /**
     * 更新wms仓库
     */
    //生产wms  32b6d593-401d-4bf1-8e9a-71b63ae877d9
    private static final String NEW_WMS_TENANTID = "32b6d593-401d-4bf1-8e9a-71b63ae877d9";

    @Override
    public void updateWmsDataInventory() {
        Map<String, Object> params = createParams();
        List<String> wareHoseCodes = Stream.of("004", "003").collect(Collectors.toList());
        params.put("wareHoseCodes", wareHoseCodes);
        List<WarehouseInventory> lssList = productGoodsMapper.listWMSInventory(params);
        int oldSize = lssList.size();
        lssList.stream().forEach(lss -> {
            lss.insertSet();
            lss.setTenantId(NEW_WMS_TENANTID);
        });
        int row = productGoodsMapper.insertBatchWMSInventory(lssList);
        if (oldSize != row) throw new RuntimeException("与原数据不等");
    }

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public void updateSupplier(MultipartFile file) throws IOException {
        ExcelUtil excelUtil = new ExcelUtil(Supplier.class);
        List<Supplier> list = excelUtil.importExcel("", file.getInputStream());
        list.stream().forEach(t -> {
            t.insertSet();
            t.setCooperation(true);
            t.setValid(true);
            t.setRecommend(true);
            t.setContact("杨杨");
            t.setTelephone("15721145090");
        });
        supplierMapper.insertBatch(list);
    }

    private List<ProductGoods> queryWms() {
//        SELECT t.product_goods_code  FROM wms_data_inventory t WHERE
//        t.warehouse_code IN ('004','003') AND t.tenant_id = '9889d4ed-dea4-11e9-a898-0242ac110002';
        Map<String, Object> params = createParams();
        List<String> wareHoseCodes = Stream.of("004", "003").collect(Collectors.toList());
        params.put("wareHoseCodes", wareHoseCodes);
        List<String> skuCodes = productGoodsMapper.queryWms(params);
        Map<String, Object> params2 = createParams();
        params2.put("skuCodes", skuCodes);
        List<ProductGoods> list = productGoodsMapper.findBySKUCodes(params2);
        return list;
    }

    private List<ProductGoods> queryStore() {
        Map<String, Object> params = createParams();
        params.put("storeName", "阿文");
        List<String> skuCodes = productGoodsMapper.findSKUByStoreName(params);

        Map<String, Object> params2 = createParams();
        params2.put("skuCodes", skuCodes);
        return productGoodsMapper.findBySKUCodes(params2);
    }

    private List<ProductGoods> querySpuCode() {
        Map<String, Object> params = createParams();
        List<String> spuCodes = new LinkedList<>();
        spuCodes.add("535339003F");
        spuCodes.add("535336004S");
        spuCodes.add("5353390045");
        params.put("spuCodes", spuCodes);
        return productGoodsMapper.findBySPUCodes(params);
    }

    private List<ProductGoods> queryBrands() {
//        裙皇，惠迪吉，恩尚，貌美，Lirica Studios
        Map<String, Object> params = createParams();
        List<String> brands = new LinkedList<>();
        brands.add("裙皇");
        brands.add("惠迪吉");
        brands.add("恩尚");
        brands.add("貌美");
        brands.add("Lirica Studios");
        params.put("brands", brands);
        List<String> spucodes = productMapper.findByBrands(params);
        Map<String, Object> params2 = createParams();
        params2.put("spuCodes", spucodes);
        return productGoodsMapper.findBySPUCodes(params2);
    }

    private List<ProductGoods> queryOwnerDS() {
        Map<String, Object> params = createParams();
        params.put("ownerName", "DS");
        return productGoodsMapper.findByOwnerName(params);
    }
}
