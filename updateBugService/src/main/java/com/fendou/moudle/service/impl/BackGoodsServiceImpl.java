package com.fendou.moudle.service.impl;

import com.fendou.moudle.mapper.BackGoodsMapper;
import com.fendou.moudle.model.BackGoods;
import com.fendou.moudle.service.BackGoodsService;
import com.fendou.moudle.service.BackGoodsServiceCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

/**
 * @Author: cjx
 * @Date: 2021-03-03 10:39
 * @Description;
 */
@Service("backGoodsService")
public class BackGoodsServiceImpl  implements BackGoodsService {

    @Autowired
    BackGoodsMapper backGoodsMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add1() {

        BackGoods backGoods = new BackGoods();
        backGoods.setId(UUID.randomUUID().toString());
        backGoods.setBackNum("001");
        backGoods.setStatus(1);
        backGoodsMapper.insert(backGoods);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add2() {
        BackGoods backGoods = new BackGoods();
        backGoods.setId(UUID.randomUUID().toString());
        backGoods.setBackNum("002");
        backGoods.setStatus(2);
        backGoodsMapper.insert(backGoods);
        int i=1/0;
    }

    @Override
    @Transactional
    public void mergeAdd() {
        copy.add1();
        copy.add2();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(int i) {
        BackGoods backGoods = new BackGoods();
        backGoods.setId(UUID.randomUUID().toString());
        backGoods.setBackNum(String.valueOf(i));
        backGoodsMapper.insert(backGoods);
    }

    @Autowired
    private BackGoodsServiceCopy copy;
    @Override
    @Transactional
    public void insertBatch() {
        BackGoods backGoods = new BackGoods();
        backGoods.setId(UUID.randomUUID().toString());
        backGoods.setBackNum("000");
        backGoodsMapper.insert(backGoods);
        for (int i = 0; i < 10; i++) {
            copy.insert(i);
            if (i == 9) {
                int a=1/0;
            }
        }
    }
}
