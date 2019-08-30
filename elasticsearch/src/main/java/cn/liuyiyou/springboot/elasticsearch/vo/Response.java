package cn.liuyiyou.springboot.elasticsearch.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ybd
 * @date 18-5-15
 * @contact yangbingdong1994@gmail.com
 */
@Data
@Accessors(chain = true)
public class Response<T> {
    private boolean success = true;
    private T body;
    private String errorMsg;

    public static Response ok(Object body) {
        return body instanceof Response ? (Response) body : new Response<>().setBody(body);
    }

    public static Response ok() {
        return new Response<>();
    }

    public static Response error(Exception e) {
        return new Response<>().setSuccess(false).setErrorMsg(e.getMessage());
    }
}
