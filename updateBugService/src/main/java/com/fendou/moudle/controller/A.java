package com.fendou.moudle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: cjx
 * @Date: 2020-08-06 16:55
 * @Description;
 */
@Component
public class A {
    @Autowired
    private B b;
}
