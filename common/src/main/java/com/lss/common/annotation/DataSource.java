package com.lss.common.annotation;

import com.lss.common.dynamicdatasource.DataSourceType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface DataSource {
    /**
     * 数据库路由
     */
    DataSourceType value() default DataSourceType.MASTER;
}
