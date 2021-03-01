package com.fendou.moudle.controller;

import com.fendou.moudle.mapper.BackGoodsMapper;
import com.fendou.moudle.model.BackGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Author: cjx
 * @Date: 2021-01-28 17:12
 * @Description;
 */
@Controller
public class TransactionalController {

    @Autowired
    BackGoodsMapper backGoodsMapper;

    @Transactional
    public void add1(){
        try {
            BackGoods backGoods = new BackGoods();
            backGoods.setId(UUID.randomUUID().toString());
            backGoods.setStatus(1);
            backGoodsMapper.insert(backGoods);
            int i=1/0;
        } catch (Exception e) {
            add2();
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void add2(){
//        try {
            BackGoods backGoods = new BackGoods();
            backGoods.setId(UUID.randomUUID().toString());
            backGoods.setStatus(2);
            backGoodsMapper.insert(backGoods);

//        } catch (Exception e) {
//            System.err.println("add2中抛出异常");
//        }
    }
}
