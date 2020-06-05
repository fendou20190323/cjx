package com.fendou.moudle.model;

import lombok.Data;

import java.util.Objects;

/**
 * @Author: cjx
 * @Date: 2020-06-02 17:51
 * @Description;
 */

public class TestCjx2 {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "TestCjx2{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCjx2 testCjx2 = (TestCjx2) o;
        return Objects.equals(a, testCjx2.a) &&
                Objects.equals(b, testCjx2.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
