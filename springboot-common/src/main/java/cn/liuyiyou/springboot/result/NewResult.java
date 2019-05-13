package cn.liuyiyou.springboot.result;

import java.io.Serializable;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/27
 * @version: V1.0
 */
public class NewResult<T extends Serializable> implements Serializable {

    private String msg;
    private T data;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
