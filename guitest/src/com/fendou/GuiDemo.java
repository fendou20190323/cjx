package com.fendou;

import javax.swing.*;

/**
 * @Author: cjx
 * @Date: 2021-01-28 11:51
 * @Description;
 */
public class GuiDemo {


    public static void main(String[] args) {

// 创建JFrame

        JFrame frame = new JFrame("hello,world");

// 设置尺寸

        frame.setSize(200, 100);

// JFrame在屏幕居中

        frame.setLocationRelativeTo(null);

// JFrame关闭时的操作

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// 显示JFrame

        frame.setVisible(true);


    }


}
