package cn.liuyiyou.springboot.exception;

/**
 * @author: liuyiyou.cn
 * @date: 2018/12/28
 * @version: V1.0
 */
public class DefaultException extends RuntimeException {

    public DefaultException() {
    }

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(Throwable cause) {
        super(cause);
    }

    public DefaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
