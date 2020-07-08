package com.lss.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author daoji.feng
 * @Date 2019/10/14 16:40
 * @ClassName OriginUpdate
 * @Description Java class field changes annotation.
 * The field used this annotation will can't get the filed value changed.
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OriginUpdate {
}
