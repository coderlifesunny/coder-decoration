package com.decoration.common.exception;

import com.decoration.common.constants.Constants;
import lombok.Getter;

/**
 * Description: 业务异常
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -2630618177937698486L;

    /**
     * 错误编码
     */
    @Getter
    private String errCode = Constants.ReturnCode.BUSINESS_EXCEPTION_ERR;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
