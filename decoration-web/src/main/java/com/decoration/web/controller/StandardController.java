package com.decoration.web.controller;

import com.decoration.biz.bean.StandardBO;
import com.decoration.common.entity.HttpResult;
import com.decoration.common.param.StandardQueryParam;
import com.decoration.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/10/30 13:45
 */
@RestController
@RequestMapping("/decoration/standard")
public class StandardController extends BaseController {

    @Autowired
    private StandardBO standardBO;

    @PostMapping(value = {"", "/list"})
    public HttpResult list(@RequestBody StandardQueryParam param) {
        return success(standardBO.findPage(param));
    }
}