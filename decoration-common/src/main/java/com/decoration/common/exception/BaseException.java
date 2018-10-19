package com.decoration.common.exception;

/**
 * Description: 基本异常信息
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable newNested) {
        super(message, newNested);
    }

    public BaseException(Throwable newNested) {
        super(newNested);
    }
}