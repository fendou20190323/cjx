/**
 * @project:     lssplatform
 * @title:       ValidateUtils.java
 */
package com.lss.common.util;

import com.lss.common.exception.ValidateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: ValidateUtils
 * @description: 验证工具类
 */
public class ValidateUtils {
    /**
     * 身份证号码地区代码：
     *     11 : 北京  12 : 天津  13 : 河北   14 : 山西  15 : 内蒙古
     *     21 : 辽宁  22 : 吉林  23 : 黑龙江 31 : 上海  32 : 江苏
     *     33 : 浙江  34 : 安徽  35 : 福建   36 : 江西  37 : 山东
     *     41 : 河南  42 : 湖北  43 : 湖南   44 : 广东  45 : 广西  46 : 海南
     *     50 : 重庆  51 : 四川  52 : 贵州   53 : 云南  54 : 西藏
     *     61 : 陕西  62 : 甘肃  63 : 青海   64 : 宁夏  65 : 新疆
     *     71 : 台湾
     *     81 : 香港  82 : 澳门
     *     91 : 国外
     */
    public final static Set<String> IDNO_AREA_CODES = new HashSet<String>() {
        private static final long serialVersionUID = 1039779241571702691L;
        {
            add("11");  add("12");  add("13");  add("14");  add("15");
            add("21");  add("22");  add("23");
            add("31");  add("32");  add("33");  add("34");  add("35");  add("36");  add("37");
            add("41");  add("42");  add("43");  add("44");  add("45");  add("46");
            add("50");  add("51");  add("52");  add("53");  add("54");
            add("61");  add("62");  add("63");  add("64");  add("65");
            add("71");
            add("81");  add("82");
            add("91");
        }
    };
    /*** 效验码 */
    public final static char[] IDNO_CHECK_CODES = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
    /*** 权值 */
    public final static int[] IDNO_WEIGHTS = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
    /*** 空白身份证号码 */
    public final static String IDNO_EMPTY="000000000000000000";
    
    /** 
     * 身份证号码验证
     * @param idNo 身份证号码
     * @return 是否有效
     */
    public final static boolean isValidIdNo(String idNo) throws ValidateException {
        char ch = '0';
        StringBuilder sb = new StringBuilder();
        
        int length = idNo.length();
        if(!(length == 15 || length == 18)) {
            throw new ValidateException(new StringBuilder().append("身份证号码“").append(idNo).append("”长度有误！").toString());
        }
        
        int weightedValue = 0;
        for(int i=0;i<length;i++) {
            ch = idNo.charAt(i);
            sb.append(ch);
            if(i==1) {// 校验城市码
                if (!IDNO_AREA_CODES.contains(sb.toString())) {
                    throw new ValidateException(new StringBuilder().append("身份证号码“").append(idNo).append("”地区代码有误！").toString());
                }
            }
            if(i==5) {
                sb.setLength(0);
                if(length==15) {//15位身份证号码日期前补“19”
                    sb.append("19");
                }
            }
            if((i==11&&length==15)||(i==13&&length==18)) {
                try {
                    new SimpleDateFormat("yyyyMMdd").parse(sb.toString());
                } catch (ParseException e) {
                    throw new ValidateException(new StringBuilder().append("身份证号码“").append(idNo).append("”出生日期有误！").toString());
                }
            }
            
            if(i==17) {
                if(ch=='x') {
                    ch = 'X';
                }
                if(IDNO_CHECK_CODES[weightedValue % 11] == ch) {
                    return true;
                }else {
                    throw new ValidateException(new StringBuilder().append("身份证号码“").append(idNo).append("”校验位有误！").toString());
                }
            }else {
                weightedValue += (ch - '0') * IDNO_WEIGHTS[i];
            }
            
            // 非数字
            if (ch < '0' || ch > '9') {
                throw new ValidateException(new StringBuilder().append("身份证号码“").append(idNo).append("”中有错误的字符“").append(ch).append("”！").toString());
            }
        }
        return true;
    }
    /** 
     * 允许输入18个0的身份证号码验证
     * @param idNo 身份证号码
     * @return 是否有效
     */
    public final static boolean isValidIdNoEx(String idNo) throws ValidateException {
        if(IDNO_EMPTY.equals(idNo)) {
            return true;
        }
        return isValidIdNo(idNo);
    }
    
    public static void main(String[] args) {
        try {
            isValidIdNo("330719196104050216");
            isValidIdNo("33022119670222791X");
            isValidIdNo("659001197909015172");
        }catch(ValidateException e) {
            System.out.println(e.getMessage());
        }
    }
}
