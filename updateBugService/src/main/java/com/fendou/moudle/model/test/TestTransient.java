package com.fendou.moudle.model.test;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: cjx
 * @Date: 2020-06-12 09:58
 * @Description;
 */
@Data
public class TestTransient  {

    private transient String a;

    public static String b;

    private  String c;

    public TestTransient() {
    }

    public TestTransient(String a, String c) {
        this.a = a;
        this.c = c;
    }

}
