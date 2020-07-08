package com.lss.common.util;


import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述
 *
 * @author HuWenhai
 * @title: StringUtil
 * @projectName lssplatform
 * @description: TODO
 * @date 2019/10/9 10:00
 * @version: v1.0
 */
public class StringUtil extends StringUtils {

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
