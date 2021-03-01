package com.fendou.io.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: cjx
 * @Date: 2021-02-26 14:25
 * @Description;
 */
public class ChannelTest {

    /**
     * 原通道将数据复制到目标通道
     */
    @Test
    public void transferTo() {
        try {
            FileInputStream fis = new FileInputStream("01.txt");
            FileOutputStream fos = new FileOutputStream("02.txt");
            FileChannel isc = fis.getChannel();
            FileChannel osc = fos.getChannel();
            isc.transferTo(isc.position(),isc.size(),osc);
            isc.close();
            osc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 目标通道将原通道数据复制过去
     */
    @Test
    public void transferFrom() {
        try {
            FileInputStream fis = new FileInputStream("01.txt");
            FileOutputStream fos = new FileOutputStream("02.txt");
            FileChannel isc = fis.getChannel();
            FileChannel osc = fos.getChannel();
            osc.transferFrom(isc, isc.position(), isc.size());
            isc.close();
            osc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 分散和聚集
     */
    @Test
    public void test() {
        try {
            FileInputStream fis = new FileInputStream("01.txt");
            FileOutputStream fos = new FileOutputStream("02.txt");

            ByteBuffer b1 = ByteBuffer.allocate(4);
            ByteBuffer b2 = ByteBuffer.allocate(1024);
            ByteBuffer[] ba = {b1, b2};
            FileChannel isc = fis.getChannel();
            FileChannel osc = fos.getChannel();
            isc.read(ba);
            for (ByteBuffer b : ba) {
                b.flip();
                System.out.println(new String(b.array(), 0, b.remaining()));
            }
            osc.write(ba);
            isc.close();
            osc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRead() {
        try {
            FileInputStream fis = new FileInputStream("01.txt");
            FileChannel channel = fis.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            channel.read(buf);
            buf.flip();
            System.out.println(new String(buf.array(), 0, buf.remaining()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testWrite() {
        try {
            FileOutputStream fos = new FileOutputStream("01.txt");
            FileChannel channel = fos.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put("fendou.cjx".getBytes());
            buf.flip();
            channel.write(buf);
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
