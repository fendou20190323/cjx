package com.lss.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Cjx
 * @date 2020/4/1 10:02
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { java.lang.annotation.ElementType.FIELD })
public @interface CsvVOAttribute {

    String name();

    String column() default "";
}
