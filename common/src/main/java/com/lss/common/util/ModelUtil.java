package com.lss.common.util;

import com.lss.common.annotation.OriginUpdate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author daoji.feng
 * @Date 2019/10/14 15:52
 * @ClassName ModelUtil
 * @Description Java class Util
 * Monitor clazz field change by annotation on the field.
 **/
public class ModelUtil {

    /**
     * Compared origin class and terminal class field changed and return a fields map.
     *
     * @param origin   the origin class
     * @param terminal the terminal class
     * @return The changed fields map.
     * <p>Specifically,super class properties doesn't need monitor changed,so only get declared fields.</p>
     * <p>Specifically,if any field used originUpdate annotation the field will compare.</p>
     * @since v 1.0.0
     */
    public static List<Map> propertiesChangeMaps(Object origin, Object terminal) {
        List<Map> result = new ArrayList<>();
        try {
            for (Field field : origin.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(OriginUpdate.class)) {
                    if (!String.valueOf(field.get(origin)).equals(String.valueOf(field.get(terminal)))) {
                        Map map = new HashMap();
                        map.put("field", String.valueOf(field.getName()));
                        map.put("originValue", String.valueOf(field.get(origin)));
                        map.put("terminal", String.valueOf(field.get(terminal)));
                        result.add(map);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

}
