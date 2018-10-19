package com.decoration.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Description: 统一返回对象
 *
 * @Author Guangcai.xu
 * @Date 2018/7/3 17:31
 */
@Getter
@Setter
public class HttpResult<T> implements Serializable {

    private static final long serialVersionUID = 9184396973856004205L;

    private String code;

    private String msg;

    private T data;

    public HttpResult(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public HttpResult(String code, String message, T data) {
        this(code, message);
        this.data = data;
    }
}
