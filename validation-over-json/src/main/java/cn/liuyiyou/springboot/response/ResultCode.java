package cn.liuyiyou.springboot.response;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/12/19
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
public enum ResultCode {

    // 成功
    SUCCESS(200),

    // 失败
    FAIL(400),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    // 接口不存在
    NOT_FOUND(404),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
