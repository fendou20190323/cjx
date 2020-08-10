package com.fendou.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.fendou.moudle.dto.OrderItemDto;
import com.fendou.moudle.dto.ReceiveOrderDto;
import com.fendou.moudle.enmu.ConfigurationOrderTypeEnums;
import com.fendou.moudle.mapper.BackGoodsMapper;
import com.fendou.moudle.mapper.BackProductInfoMapper;
import com.fendou.moudle.model.BackGoods;
import com.fendou.moudle.model.BackProductInfo;
import com.fendou.moudle.model.TestCjx;
import com.fendou.moudle.model.TestCjx2;
import com.fendou.moudle.service.impl.DemoBackGoodsImpl;
import lombok.extern.slf4j.Slf4j;
import org.mockito.internal.configuration.MockAnnotationProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.handler.Handler;
import java.util.*;

/**
 * @author Cjx
 * @date 2020/3/30 15:56
 * @description
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/demo")
@Slf4j(topic = "DemoBackGoods")
@ControllerAdvice
public class DemoBackGoods {
    @Autowired
    private BackGoodsMapper backGoodsMapper;
    @Autowired
    private BackProductInfoMapper backProductInfoMapper;

    @GetMapping("/testAdvice")
    public void testAdvice() {
        BackGoods b2 = null;
        BackGoods b1 = new BackGoods();
        Assert.notNull(b2, "不能为空");
    }

    public static void main(String[] args) {
        BackGoods b2 = null;
        BackGoods b1 = new BackGoods();
        Assert.notNull(b2, "不能为空");
    }

    @GetMapping("/find")
    public String find(String orderSn) {
        BackGoods backGoods = findBackGoods(orderSn);
        BackGoods backGoods1 = findBackGoods(orderSn);
//        List<BackProductInfo> infoList = findInfoByOrderSn(backGoods.getBackNum());
//        List<BackProductInfo> infoList2 = findInfoByOrderSn(backGoods.getBackNum());
//        backGoods.setBackProductInfoList(infoList);
//        ReceiveOrderDto dto = createReceiveOrderDto(backGoods);
//        String jsonString = JSONObject.toJSONString(dto);
        return "jsonString";
    }
    @GetMapping("/find2")
    public String find2(String orderSn) {
        BackGoods backGoods = findBackGoods(orderSn);
        BackGoods backGoods1 = findBackGoods(orderSn);
//        List<BackProductInfo> infoList = findInfoByOrderSn(backGoods.getBackNum());
//        List<BackProductInfo> infoList2 = findInfoByOrderSn(backGoods.getBackNum());
//        backGoods.setBackProductInfoList(infoList);
//        ReceiveOrderDto dto = createReceiveOrderDto(backGoods);
//        String jsonString = JSONObject.toJSONString(dto);
        return "jsonString";
    }
    @GetMapping("/update")
    public String update(String orderSn) {
        BackGoods backGoods = findBackGoods(orderSn);
        backGoods.setStatus(backGoods.getStatus()+1);
//        List<BackProductInfo> infoList = findInfoByOrderSn(backGoods.getBackNum());
//        List<BackProductInfo> infoList2 = findInfoByOrderSn(backGoods.getBackNum());
//        backGoods.setBackProductInfoList(infoList);
//        ReceiveOrderDto dto = createReceiveOrderDto(backGoods);
//        String jsonString = JSONObject.toJSONString(dto);
        backGoodsMapper.updateSelective(backGoods);
        return "jsonString";
    }

    private BackGoods findBackGoods(String orderSn) {

        return backGoodsMapper.findByAssociateOrderSn(orderSn);
    }

    private List<BackProductInfo> findInfoByOrderSn(String orderSn) {
        return backProductInfoMapper.findInfoByOrderSn(orderSn);
    }

    private ReceiveOrderDto createReceiveOrderDto(BackGoods backGoods) {
        ReceiveOrderDto receiveOrderDto = new ReceiveOrderDto();
        List<OrderItemDto> orderItemDtoList = new LinkedList<>();

        receiveOrderDto.setLogisticsCode(backGoods.getLogisticsCode());
        receiveOrderDto.setLogisticsSn(backGoods.getLogisticsNum());
        receiveOrderDto.setOrderSn(backGoods.getAssociateOrderSn());
        receiveOrderDto.setOrderSource(ConfigurationOrderTypeEnums.SUPPLY_CHAIN.getType());
        receiveOrderDto.setOrderType(ConfigurationOrderTypeEnums.RETURN_INBOUND_ORDER.getType());
        receiveOrderDto.setTenantId(backGoods.getTenantId());
        receiveOrderDto.setWarehouseCode(backGoods.getWarehouseCode());

        List<BackProductInfo> infoList = backGoods.getBackProductInfoList();
        for (BackProductInfo info : infoList) {
            OrderItemDto dto = new OrderItemDto();
            dto.setGoodsCode(info.getGoodsCode());
            dto.setOrderQuantity(info.getRealityBackQuantity());
            dto.setProductCode(info.getProductCode());
            dto.setColor(info.getColor());
            dto.setSpecification(info.getSize());
            dto.setBrand(info.getBrandName());
            dto.setImage(info.getImage());
            dto.setSkuLevel(1);
            orderItemDtoList.add(dto);
        }

        receiveOrderDto.setOrderItemDtoList(orderItemDtoList);
        return receiveOrderDto;
    }

    private final Logger LOGGER = LoggerFactory.getLogger(DemoBackGoods.class);

    /**
     * @param t
     * @return
     */
    @PostMapping("/test")
    public String test(@RequestBody @Valid TestCjx t) {
        /**logger*/
        log.debug(t.getId());
        log.debug(t.getNumList().toString());
        log.debug(t.getName());
        HashSet<Integer> set = new HashSet<>(t.getNumList());
        log.debug("set{}", set.toString());
        HashSet<TestCjx2> testCjx2s = new HashSet<>(t.getCjx2List());
        log.debug("testCjx2s{}", testCjx2s.toString());
        return "chenggong";
    }

    @GetMapping("/list")
    @Transactional
    public String list() {
        DemoBackGoodsImpl impl = new DemoBackGoodsImpl();
        impl.query();
        return "ok";
    }


}
