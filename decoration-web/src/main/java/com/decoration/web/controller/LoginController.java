package com.decoration.web.controller;

import com.decoration.common.entity.HttpResult;
import com.decoration.common.exception.ParamException;
import com.decoration.common.exception.PermissionException;
import com.decoration.common.param.SysUserQueryParam;
import com.decoration.common.param.erp.UserPwdParam;
import com.decoration.common.utils.EncodeUtil;
import com.decoration.common.utils.JWTUtil;
import com.decoration.dao.entity.SysUserDO;
import com.decoration.service.bean.SysUserService;
import com.decoration.web.base.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: erp接口
 *
 * @Author Guangcai.xu
 * @Date 2018/11/17 11:36
 */
@RestController
@RequestMapping(value = {"","/decoration"})
public class LoginController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录方法 post
     *
     * @return
     */
    @PostMapping("/login")
    public HttpResult login(@RequestBody UserPwdParam param) {
        List<SysUserDO> user = sysUserService.findPage(new SysUserQueryParam(param.getUsername()));
        if (CollectionUtils.isEmpty(user)) {
            throw new ParamException("用户名错误");
        } else if (!user.get(0).getPassword().equals(EncodeUtil.md5Hex(param.getPassword()))) {
            throw new ParamException("密码错误");
        } else {
            return success(JWTUtil.createToken(param.getUsername()));
        }
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public HttpResult unauthorized(@PathVariable String message) {
        throw new PermissionException(message);
    }
}