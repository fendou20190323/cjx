package com.fendou.io.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @Author: cjx
 * @Date: 2021-02-26 13:41
 * @Description; buffer常用api
 */
public class BufferTest {

    @Test
    public void test2(){

        ByteBuffer buffer = ByteBuffer.allocate(10);
        String name = "fendou";
        buffer.put(name.getBytes());
        System.err.println("-----------clear方法------------------");
        buffer.clear();
        System.err.println("position：" + buffer.position());
        System.err.println("limit：" + buffer.limit());
        System.err.println("capacity：" + buffer.capacity());
        System.err.println("-----------get方法------------------");
        char ch = (char) buffer.get();
        System.err.println(ch);
        System.err.println("position：" + buffer.position());
        System.err.println("limit：" + buffer.limit());
        System.err.println("capacity：" + buffer.capacity());
    }
    @Test
    public void test1() {

        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.err.println("position：" + buffer.position());
        System.err.println("limit：" + buffer.limit());
        System.err.println("capacity：" + buffer.capacity());
        System.err.println("-----------put方法------------------");
        String name = "fendou";
        buffer.put(name.getBytes());
        System.err.println("position：" + buffer.position());
        System.err.println("limit：" + buffer.limit());
        System.err.println("capacity：" + buffer.capacity());
        System.err.println("----------flip方法-------------------");
        buffer.flip();
        System.err.println("position：" + buffer.position());
        System.err.println("limit：" + buffer.limit());
        System.err.println("capacity：" + buffer.capacity());
        System.err.println("-----------get方法------------------");
        char ch = (char) buffer.get();
        System.err.println(ch);
        System.err.println("position：" + buffer.position());
        System.err.println("limit：" + buffer.limit());
        System.err.println("capacity：" + buffer.capacity());
        System.err.println("-----------clear方法------------------");
        buffer.clear();
        System.err.println("position：" + buffer.position());
        System.err.println("limit：" + buffer.limit());
        System.err.println("capacity：" + buffer.capacity());
    }
}
