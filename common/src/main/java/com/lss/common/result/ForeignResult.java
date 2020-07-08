package com.lss.common.result;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author wangyg
 * @version 1.0
 * @since 1.0
 */
@ApiModel(value = "Result", description = "公共返回数据")
public class ForeignResult<T> {

    /**
     * 响应码
     */
    @ApiModelProperty(value = "响应码")
    private int code;

    /**
     * 响应消息
     */
    @ApiModelProperty(value = "响应消息")
    private String message;

    /**
     * 响应内容
     */
    @ApiModelProperty(value = "响应内容")
    private T data;

    /**
     * 响应时间
     */
    @ApiModelProperty(value = "响应时间")
    private String timestamp;

    public int getCode() {
        return code;
    }

    public ForeignResult setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ForeignResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ForeignResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public ForeignResult setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public enum ResultCode implements Serializable {

        SUCCESS(200, "请求成功"),
        PARAMETER_ERROR(400, "参数错误"),
        UNAUTHORIZED(401, "签名无效"),
        SIGN_TIMEOUT(402, "签名已过期"),
        NOT_FOUND(404, "服务接口不存在"),
        INTERNAL_SERVER_ERROR(500, "服务器错误");

        private int code;

        private String name;

        ResultCode(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
