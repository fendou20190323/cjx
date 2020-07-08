package com.lss.common.util;

import java.util.Random;

public class RandomIntUtil {
    public static Random random=new Random();

    public static String getNextCode()
    {
        int var1 = random.nextInt(999999);
        return String.format("%06d", var1);
    }
}
