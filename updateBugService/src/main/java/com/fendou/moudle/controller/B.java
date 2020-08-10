package com.fendou.moudle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

/**
 * @Author: cjx
 * @Date: 2020-08-06 16:55
 * @Description;
 */
@Component
public class B {
    @Autowired
    private A a;
}
