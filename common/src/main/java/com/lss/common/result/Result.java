package com.lss.common.result;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wangyg
 * @version 1.0
 * @since 1.0
 */
@ApiModel(value = "Result", description = "公共返回数据")
public class Result<T> {

    /**
     * 响应码 {@link ResultCode}
     */
    @ApiModelProperty(value = "响应码")
    private int code;

    /**
     * 响应消息
     */
    @ApiModelProperty(value = "响应消息")
    private String message;

    /**
     * 响应时间
     */
    @ApiModelProperty(value = "响应时间")
    private String timestamp;

    /**
     * 响应内容
     */
    @ApiModelProperty(value = "响应内容")
    private T data;

    public int getCode() {
        return code;
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Result setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public enum ResultCode implements Serializable {

        SUCCESS(200),                   //成功
        FAIL(400),                      //失败
        UNAUTHORIZED(401),              //未认证（签名错误）
        TOKEN_TIMEOUT_CODE(402),              //token过期
        NOT_FOUND(404),                 //接口不存在
        INTERNAL_SERVER_ERROR(500);     //服务器内部错误

        public int code;

        ResultCode(int code) {
            this.code = code;
        }

    }

    public enum ReturnCode implements Serializable {

        SUCCESS(200),                   //成功
        FAIL(400),                      //失败
        UNAUTHORIZED(401),              //未认证（签名错误）
        TOKEN_TIMEOUT_CODE(402),              //token过期
        NOT_FOUND(404),                 //接口不存在
        INTERNAL_SERVER_ERROR(500);     //服务器内部错误

        public int code;

        ReturnCode(int code) {
            this.code = code;
        }

    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean IsSuccess() {
        return this.code == ResultCode.SUCCESS.code;
    }

    public boolean ReturnCodeIsSuccess() {
        return this.code == ReturnCode.SUCCESS.code;
    }

    //region 静态方法

    public static <T> Result<T> Create(ResultCode code, T data, String message) {
        Result<T> rsult = new Result<>();
        rsult.setCode(code);
        rsult.setMessage(message);
        if (data != null) {
            rsult.setData(data);
        }
        rsult.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return rsult;
    }

    /**
     * 成功时返回
     */
    public static <T> Result<T> Success(T data, String message) {
        return Create(ResultCode.SUCCESS, data, message);
    }

    /**
     * 成功时返回
     */
    public static <T> Result<T> Success(T data) {
        return Success(data, "SUCCESS");
    }

    /**
     * 成功时返回
     */
    public static Result Success(String message) {
        return Success(null, message);
    }

    /**
     * 成功时返回
     */
    public static Result Success() {
        return Success(null);
    }

    /**
     * 失败时返回
     */
    public static <T> Result<T> Error(ResultCode code, String message) {
        return Create(code, null, message);
    }

    /**
     * 失败时返回
     */
    public static <T> Result<T> Error(String message) {
        return Error(ResultCode.FAIL, message);
    }

    /**
     * 失败时返回
     */
    public static <T> Result<T> Error(String message, T data) {
        return Create(ResultCode.FAIL, data, message);
    }

    /**
     * 失败时返回
     */
    public static <T> Result<T> Error() {
        return Error(null);
    }


    //endregion
}
