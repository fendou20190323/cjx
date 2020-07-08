package com.lss.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class BusinessException extends RuntimeException implements LssException {

    private static final long serialVersionUID = -7422865553361251643L;
    /**
     * 错误模块
     */
    private String moduleName;
    /**
     * 错误编码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 异常信息
     */
    private String stackTraceMsg;

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.getMessage();
    }

    @Override
    public String getStackTraceMsg() {
        return this.errorMsg;
    }

    /**
     * 构建业务异常
     *
     * @param moduleName     模块代码
     * @param errorCode      错误代码
     * @param errorMsg 错误信息参数
     */
    public BusinessException(String moduleName, String errorCode, String errorMsg) {
        this.moduleName=moduleName;
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }

    /**
     * 构建业务异常
     *
     * @param moduleName     模块代码
     * @param errorCode      错误代码
     * @param errorMsg 错误信息参数
     */
    public BusinessException(String moduleName, String errorCode, String errorMsg,Throwable t) {
        this.moduleName=moduleName;
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
        this.stackTraceMsg=getStackTrace(t);
    }


    @Override
    public String getMessage() {
        return moduleName + "-" + errorCode + ":" + errorMsg;
    }

    /**
     * 输出异常堆栈信息
     *
     * @param throwable 异常
     * @return 堆栈信息
     */
    public String getStackTrace(Throwable throwable)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        try {
            throwable.printStackTrace(pw);
            return sw.getBuffer().toString();
        }
        finally {
            pw.close();
        }
    }

}
