package com.decoration.web.controller;

import com.decoration.biz.bean.MainMaterialBO;
import com.decoration.common.entity.HttpResult;
import com.decoration.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 主材料web接口
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
@RequestMapping("/material")
@RestController
public class MainMaterialController extends BaseController {

    @Autowired
    private MainMaterialBO mainMaterialBO;

    @GetMapping("/list")
    public HttpResult list() {
        return success(mainMaterialBO.findAll());
    }
}