package com.lss.common.base;

import com.lss.common.result.Result;
import com.lss.common.result.Result4Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author wangyg
 */
public class BaseController {
    private static final String DEFAULT_SUCCESS_MESSAGE = "服务调用成功";

    /**
     * 线程安全类
     *
     * @return HttpServletRequest
     */
    public HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 成功时返回
     *
     * @param data
     * @param <T>
     * @return
     */
    public <T> Result<T> JsonSuccess(T data) {
        return Result.Success(data, DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 成功时返回
     *
     * @param message
     * @param <T>
     * @return
     */
    public <T> Result<T> JsonSuccess(String message) {
        return Result.Success(message);
    }

    /**
     * 成功时返回
     *
     * @param message
     * @param <T>
     * @return
     */
    public <T> Result<T> JsonSuccess(T data,String message) {
        return Result.Success(data, message);
    }

    /**
     * 失败时返回
     *
     * @param message
     * @param <T>
     * @return
     */
    public <T> Result<T> JsonError(String message) {
        return Result.Error(message);
    }

    /**
     * 失败时返回
     *
     * @param message
     * @param <T>
     * @return
     */
    public <T> Result<T> JsonError(Result.ResultCode resultCode, String message) {
        return Result.Error(resultCode, message);
    }

    /**
     * 成功时返回
     *
     * @param data,message
     * @param <T>
     * @return
     */
    public <T> Result4Service<T> FeignSuccess(T data) {
        Result4Service<T> rsult = new Result4Service<>();
        rsult.setbSuccess(true);
        rsult.setMessage(DEFAULT_SUCCESS_MESSAGE);
        rsult.setData(data);
        return rsult;
    }

    /**
     * 失败时返回
     *
     * @param message
     * @return
     */
    public <T> Result4Service<T> FeignError(String message) {
        Result4Service<T> rsult = new Result4Service<>();
        rsult.setbSuccess(false);
        rsult.setMessage(message);
        return rsult;
    }

    public String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        try {
            throwable.printStackTrace(pw);
            return sw.getBuffer().toString();
        } finally {
            pw.close();
        }
    }
}
