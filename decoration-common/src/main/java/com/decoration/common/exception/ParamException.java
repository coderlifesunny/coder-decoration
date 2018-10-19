package com.decoration.common.exception;

import com.decoration.common.constants.Constants;
import lombok.Getter;

/**
 * Description: 参数异常
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
public class ParamException extends RuntimeException {
    private static final long serialVersionUID = 3468002763310308893L;

    /**
     * 错误编码
     */
    @Getter
    private String errCode = Constants.ReturnCode.PARAM_EXCEPTION_ERR;



    public ParamException() {
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }
}
