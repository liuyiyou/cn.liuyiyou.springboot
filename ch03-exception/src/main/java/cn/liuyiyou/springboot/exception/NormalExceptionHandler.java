package cn.liuyiyou.springboot.exception;

/***
 * @author: liuyiyou
 * @date: 2018/1/17
 */
public class NormalExceptionHandler  extends RuntimeException{

    public NormalExceptionHandler(String message) {
        super(message);
    }

    public NormalExceptionHandler() {
    }
}
