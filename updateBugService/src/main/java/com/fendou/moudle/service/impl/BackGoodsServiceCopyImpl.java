package com.fendou.moudle.service.impl;

import com.fendou.moudle.mapper.BackGoodsMapper;
import com.fendou.moudle.model.BackGoods;
import com.fendou.moudle.service.BackGoodsService;
import com.fendou.moudle.service.BackGoodsServiceCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Author: cjx
 * @Date: 2021-03-03 10:39
 * @Description;
 */
@Service("backGoodsServiceCopy")
public class BackGoodsServiceCopyImpl implements BackGoodsServiceCopy {

    @Autowired
    BackGoodsMapper backGoodsMapper;

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void add1() {

        BackGoods backGoods = new BackGoods();
        backGoods.setId(UUID.randomUUID().toString());
        backGoods.setBackNum("001");
        backGoods.setStatus(1);
        backGoodsMapper.insert(backGoods);

    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void add2() {
        BackGoods backGoods = new BackGoods();
        backGoods.setId(UUID.randomUUID().toString());
        backGoods.setBackNum("002");
        backGoods.setStatus(2);
        backGoodsMapper.insert(backGoods);
        int i=1/0;
    }

    @Override
    public void mergeAdd() {
        this.add1();
        this.add2();
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void insert(int i) {
        BackGoods backGoods = new BackGoods();
        backGoods.setId(UUID.randomUUID().toString());
        backGoods.setBackNum(String.valueOf(i));
        backGoodsMapper.insert(backGoods);
    }

    @Override
    @Transactional
    public void insertBatch() {
        BackGoods backGoods = new BackGoods();
        backGoods.setId(UUID.randomUUID().toString());
        backGoods.setBackNum("000");
        backGoodsMapper.insert(backGoods);
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
               int a=1/0;
            }
            this.insert(i);
        }
    }
}
