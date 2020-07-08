package com.lss.common.util;

import java.util.Random;

/**
 * @Author:YaoBin
 * @Date: 2020/5/13 13:53
 * @Description:
 */
public class RandomStringUtil {

    /**
     * 字符串池
     */
    private static String[] STR_ARR = new String[] { "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0" };


    /**
     *
     * 根据指定的长度生成的含有大小写字母及数字的字符串
     *
     * @param length
     *            指定的长度
     * @return 按照指定的长度生成的含有大小写字母及数字的字符串
     */
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(STR_ARR[rand.nextInt(STR_ARR.length)]);
        }
        return sb.toString();
    }



}
