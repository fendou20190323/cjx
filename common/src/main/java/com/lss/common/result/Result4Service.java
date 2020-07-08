package com.lss.common.result;

import com.alibaba.fastjson.JSON;

/**
 * @author wangyg
 * @version 1.0
 * @since 1.0
 */
public class Result4Service<T> {

    private boolean bSuccess;

    private String message;

    //T为不定类型时的扩展字段
    private String type;

    private T data;

    public String getMessage() {
        return message;
    }

    public Result4Service setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result4Service<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public boolean isbSuccess() {
        return bSuccess;
    }

    public void setbSuccess(boolean bSuccess) {
        this.bSuccess = bSuccess;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
