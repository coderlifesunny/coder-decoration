package com.decoration.web.controller;

import com.decoration.biz.bean.SysUserBO;
import com.decoration.biz.param.SysUserAddParam;
import com.decoration.common.entity.HttpResult;
import com.decoration.common.utils.JWTUtil;
import com.decoration.web.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 用户接口
 *
 * @Author Guangcai.xu
 * @Date 2018/11/21 16:38
 */
@RequestMapping("/decoration/user")
@RestController
public class SysUserController extends BaseController {

    @Autowired
    private SysUserBO sysUserBO;

    @PostMapping("/add")
    public HttpResult add(@RequestBody SysUserAddParam param) {
        param.setOperateUser(getCurrentUsername());
        sysUserBO.add(param);
        return successMsg("保存成功");
    }
}