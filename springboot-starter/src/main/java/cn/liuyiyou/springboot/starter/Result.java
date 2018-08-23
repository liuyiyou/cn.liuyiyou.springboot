package cn.liuyiyou.springboot.starter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/20
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private boolean success = true;
    private T result;
    private String msg = "success";



    public static <T> Result<T> success(T result) {
        return result instanceof Result ? (Result) result : new Result<T>().setResult(result);
    }

    public static <T> Result<T> error(String message) {
        return new Result<T>().setSuccess(false).setMsg(message);
    }

    public static <T> Result<T> error(Exception e) {
        return new Result<T>().setSuccess(false).setMsg(e.getMessage());
    }

}
