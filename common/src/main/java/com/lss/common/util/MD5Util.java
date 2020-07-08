package com.lss.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 功能描述
 *
 * @author Huwenhai
 * @title: MD5Util
 * @projectName lssplatform
 * @description: MD5 摘要工具类
 * @date 2019/4/20 10:00
 * @version: v1.0
 */
public class MD5Util {

    /**
     * MD5摘要算法
     *
     * @param str 需要加密的原始数据
     * @return
     */
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString();
            // 16位的加密
            // return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String pwd = MD5Util.md5("abc");
        System.out.println(pwd);
    }

}