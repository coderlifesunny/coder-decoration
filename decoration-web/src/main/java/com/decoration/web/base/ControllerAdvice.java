package com.decoration.web.base;

import com.decoration.common.constants.Constants;
import com.decoration.common.entity.HttpResult;
import com.decoration.common.exception.BusinessException;
import com.decoration.common.exception.ParamException;
import com.decoration.common.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;
import java.net.BindException;

/**
 * Description: AOP拦截
 *
 * @Author Guangcai.xu
 * @Date 2018/10/30 14:14
 */
@RestControllerAdvice(basePackages = "com.decoration.web.controller")
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler({FileNotFoundException.class})
    public HttpResult handleFileNotFoundException(FileNotFoundException e) {
        return new HttpResult(Constants.ReturnCode.NOT_FOUND_ERR, "资源不存在");
    }

    @ExceptionHandler({BusinessException.class})
    public HttpResult handleBusinessException(BusinessException e) {
        log.info("BusinessException:[{}]", e.getMessage());
        return new HttpResult(Constants.ReturnCode.BUSINESS_EXCEPTION_ERR, e.getMessage());
    }

    @ExceptionHandler({ParamException.class, BindException.class, IllegalArgumentException.class, MissingServletRequestParameterException.class, HttpMessageNotReadableException.class})
    public HttpResult handleParamException(Exception e) {
        log.info("ParamException:[{}]", e.getMessage());
        return new HttpResult(Constants.ReturnCode.PARAM_EXCEPTION_ERR, e.getMessage());
    }

    @ExceptionHandler({PermissionException.class})
    public HttpResult handlePermissionException(Exception e) {
        return new HttpResult(Constants.ReturnCode.PERMISSION_EXCEPTION_ERR, e.getMessage());
    }

    @ExceptionHandler(ShiroException.class)
    public HttpResult handle401() {
        return new HttpResult(Constants.ReturnCode.PERMISSION_EXCEPTION_ERR, "您没有权限访问");
    }

    @ExceptionHandler({Exception.class})
    public HttpResult handleException(Exception e) {
        log.info("系统捕获异常:[{}]", e.getMessage(), e);
        return new HttpResult(Constants.ReturnCode.SYSTEM_ERR, "访问出错，无法访问: " + e.getMessage());
    }


}