package com.decoration.common.exception;

import com.decoration.common.constants.Constants;
import lombok.Getter;

/**
 * Description: 权限异常
 *
 * @Author Guangcai.xu
 * @Date 2018/10/30 14:17
 */
public class PermissionException extends RuntimeException {
    private static final long serialVersionUID = 3468002763310308893L;

    /**
     * 错误编码
     */
    @Getter
    private String errCode = Constants.ReturnCode.PERMISSION_EXCEPTION_ERR;

    public PermissionException() {
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }
}
