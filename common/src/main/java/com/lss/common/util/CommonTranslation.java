package com.lss.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author daoji.feng
 * @Date 2019/9/12 15:18
 * @ClassName CommonTranslation
 * @Description 外部抓取数据转换成财务相关MODEL工具类
 **/
public class CommonTranslation {


    /**
     * HashMap转Object工具方法
     *
     * @param map
     * @return
     */
    public static Object hashMapToObject(Map<String, Object> map, Class<?> beanClass) {
        Object obj = null;
        try {
            if (map == null) {
                return obj;
            } else {
                obj = beanClass.newInstance();
                Field[] fields = obj.getClass().getDeclaredFields();
                for (Field field : fields) {
                    int mod = field.getModifiers();
                    if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                        continue;
                    }
                    field.setAccessible(true);
                    if (map.get(field.getName()) != null) {
                        if (field.getType().getName().equals("java.math.BigDecimal")) {
                            if (map.get(field.getName()) != null) {
                                field.set(obj, new BigDecimal((Double) map.get(field.getName())).setScale(3, RoundingMode.DOWN));
                            } else {
                                field.set(obj, null);
                            }
                        } else if (field.getType().getName().equals("java.util.Date")) {
                            if (map.get(field.getName()) != null) {
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.000+0000");
                                String value = String.valueOf(map.get(field.getName())).replace("T", " ");
                                Date date = dateFormat.parse(value);
                                field.set(obj, date);
                            } else {
                                field.set(obj, null);
                            }
                        } else if (field.getType().getName().equals("java.sql.Timestamp")) {
                            if (map.get(field.getName()) != null) {
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.000+0000");
                                String value = String.valueOf(map.get(field.getName())).replace("T", " ");
                                Date date = dateFormat.parse(value);
                                Timestamp timestamp = new Timestamp(date.getTime());
                                field.set(obj, timestamp);
                            } else {
                                field.set(obj, null);
                            }
                        } else {
                            field.set(obj, map.get(field.getName()));
                        }
                    } else {
                        field.set(obj, null);
                    }
                }
                return obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
