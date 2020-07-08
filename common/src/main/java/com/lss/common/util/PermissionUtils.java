package com.lss.common.util;


import com.lss.common.annotation.PermissionAop;
import org.apache.ibatis.mapping.MappedStatement;

import java.lang.reflect.Method;

/**
 * 自定义权限相关工具类
 * */
public class PermissionUtils {

    /**
     * 根据 StatementHandler 获取 注解对象
     */
    public static PermissionAop getPermissionByDelegate(MappedStatement mappedStatement){
        PermissionAop permissionAop = null;
        try {
            String id = mappedStatement.getId();
            String className = id.substring(0, id.lastIndexOf("."));
            String methodName = id.substring(id.lastIndexOf(".") + 1, id.length());
            final Class cls = Class.forName(className);
            final Method[] method = cls.getMethods();
            for (Method me : method) {
                if (me.getName().equals(methodName) && me.isAnnotationPresent(PermissionAop.class)) {
                    permissionAop = me.getAnnotation(PermissionAop.class);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return permissionAop;
    }
}