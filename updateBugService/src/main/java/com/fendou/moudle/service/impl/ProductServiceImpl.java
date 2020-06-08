package com.fendou.moudle.service.impl;

import com.fendou.moudle.dto.ProductDto;
import com.fendou.moudle.mapper.*;
import com.fendou.moudle.model.product.*;
import com.fendou.moudle.service.ProductService;
import com.fendou.moudle.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Cjx
 * @date 2020/6/5 23:08
 * @description
 */
@SuppressWarnings("ALL")
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {


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

    private static final String NEW_TENANTID = "4c1a45f1-d809-4965-b99d-1b2d5fa87e6b";

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
    public void updateProductBrand() {
        //查询租户id=9889d4ed-dea4-11e9-a898-0242ac110002
        Map<String, Object> params = createParams();
        List<ProductBrand> lssList = productBrandMapper.list(params);
        int oldSize = lssList.size();
        //将数据转到新租户
        lssList.stream().forEach(lss -> {
            lss.insertSet();
        });
        //保存
        int row = productBrandMapper.insertBatch(lssList);
        if (oldSize != row) throw new RuntimeException("与原数据不等");
    }


    /**
     * 更新颜色
     */
    @Autowired
    private ColorMapper colorMapper;

    @Override
    public void updateColor() {
        List<Color> lssList = colorMapper.list(createParams());
        int oldSize = lssList.size();
        //查询色系数据
        Map<String, Object> colorSeriesParams = new HashMap<>();
        colorSeriesParams.put("tenantId", NEW_TENANTID);
        List<ColorSeries> colorSeriesList = colorSeriesMapper.list(colorSeriesParams);
        if (colorSeriesList == null || colorSeriesList.size() == 0) throw new RuntimeException("色系不能为空");
        lssList.stream().forEach(lss -> {
            String seriesId = colorSeriesList.stream().filter(c -> c.getRemarks().split(":")[1].equals(lss.getSeriesId())).collect(Collectors.toList()).get(0).getId();
            lss.setSeriesId(seriesId);
            lss.insertSet();
        });
        int row = colorMapper.insertBatch(lssList);
        if (oldSize != row) throw new RuntimeException("与原数据不等");
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
    public void updateProductBrandOwner() {
        List<ProductBrandOwner> lssList = productBrandOwnerMapper.list(createParams());
        int oldSize = lssList.size();
        lssList.stream().forEach(lss -> {
            lss.insertSet();
        });
        int row = productBrandOwnerMapper.insertBatch(lssList);
        if (oldSize != row) throw new RuntimeException("与原数据不等");
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
    public void updateCategories() {
        List<Categories> lssList = categoriesMapper.list(createParams());
        int oldSize = lssList.size();
        lssList.stream().forEach(lss -> {
            lss.insertSet();
        });
        int row = categoriesMapper.insertBatch(lssList);
        if (oldSize != row) throw new RuntimeException("与原数据不等");
    }

    @Autowired
    private ProductGoodsMapper productGoodsMapper;

    @Override
    public void updateProdcutGoods() {
        //查询数据条件
        /**
         * 1）货主DS下的所有档案，
         * 2）以下所有品牌的档案：裙皇，惠迪吉，恩尚，貌美，Lirica Studios，惠迪吉，
         * 3）535339003F，535336004S
         * 4）零售门店：阿文
         * 5）WMS：杭州迪艾斯残次仓，杭州迪艾斯仓库
         这些的数据也都要*/

        List<ProductGoods> productGoods1 = queryOwnerDS();
        List<ProductGoods> productGoods2 = queryBrands();
        List<ProductGoods> productGoods3 = querySpuCode();
        List<ProductGoods> productGoods4 = queryStore();
        List<ProductGoods> productGoods5 = queryWms();
        List<ProductGoods> list = new LinkedList<>();
        list.addAll(productGoods1);
        list.addAll(productGoods2);
        list.addAll(productGoods3);
        list.addAll(productGoods4);
        list.addAll(productGoods5);
        Map<String, Object> map = createParams();
        map.put("tenantId", NEW_TENANTID);
        List<ProductDto> productList = productMapper.listIdAndRemark(map);
        System.err.println();
        list.stream().forEach(pg -> {
            if (pg.getProductId() != null && !"".equals(pg.getProductId().trim())) {
                String productId = productList.stream().filter(p -> p.getRemarks().split(":")[1].equals(pg.getProductId())).collect(Collectors.toList()).get(0).getId();
                pg.setProductId(productId);
            }
            pg.insertSet();
        });
        List<ProductGoods> first = list.subList(0, 3000);
        List<ProductGoods> second = list.subList(3000, list.size());
        productGoodsMapper.insertBatch(first);
        productGoodsMapper.insertBatch(second);
    }

    private List<ProductGoods> queryWms() {
        List<ProductGoods> list = new LinkedList<>();
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
