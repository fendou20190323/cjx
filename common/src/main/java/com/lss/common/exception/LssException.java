package com.lss.common.exception;

public interface LssException {
    /**
     * 获取错误编码
     */
    String getErrorCode();

    /**
     * 获取错误详细信息
     */
    String getStackTraceMsg();

    /**
     * 获取错误描述信息
     */
    String getErrorMsg();
}
