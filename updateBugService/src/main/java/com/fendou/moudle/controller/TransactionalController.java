package com.fendou.moudle.controller;

import com.fendou.moudle.mapper.BackGoodsMapper;
import com.fendou.moudle.model.BackGoods;
import com.fendou.moudle.service.BackGoodsService;
import com.lss.common.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * @Author: cjx
 * @Date: 2021-01-28 17:12
 * @Description;
 */
@Controller
@RequestMapping("/transactionalController")
public class TransactionalController {

    @Autowired
    BackGoodsService backGoodsService;

    //    @Transactional
    @GetMapping("/add")
    public void add() {
//        backGoodsService.add1();
//        backGoodsService.add2();
        backGoodsService.mergeAdd();
    }


}
