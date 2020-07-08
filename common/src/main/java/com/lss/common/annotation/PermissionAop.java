package com.lss.common.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤自定义注解
 * @author wangyg
 * */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionAop {
    String value() default "";
}