package cn.liuyiyou.springboot.response;


/***
 *
 * 可以使用
 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
 * @author: liuyiyou.cn
 * @date: 2018/12/19
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
public class Result<T> {

    public int code;
    private String msg;
    private T data;
    private boolean success;


    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Result<T> setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}

