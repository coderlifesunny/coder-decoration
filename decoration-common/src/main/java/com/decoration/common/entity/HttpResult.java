package com.decoration.common.entity;

import com.decoration.common.constants.Constants;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
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

    private String msg = Constants.ReturnMsg.SUCCESS;

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
