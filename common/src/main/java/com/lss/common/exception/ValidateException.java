/**
 * @project:     lssplatform
 * @title:       ValidateException.java
 */
package com.lss.common.exception;

/**
 * @ClassName: ValidateException
 * @description: 验证异常类
 */
public class ValidateException extends Exception {
    private static final long serialVersionUID = -5152399016094775382L;

    public ValidateException() {
        super();
    }

    public ValidateException(String message) {
        super(message);
    }
    
    public ValidateException(String message, Throwable e) {
        super(message,e);
    }
}
