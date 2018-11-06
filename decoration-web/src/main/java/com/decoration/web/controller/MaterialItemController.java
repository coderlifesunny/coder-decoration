package com.decoration.web.controller;

import com.decoration.biz.bean.MaterialItemBO;
import com.decoration.common.entity.HttpResult;
import com.decoration.common.param.MaterialItemQueryParam;
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
 * @Date 2018/11/3 12:07
 */
@RestController
@RequestMapping("/decoration/material_item")
public class MaterialItemController extends BaseController {

    @Autowired
    private MaterialItemBO materialItemBO;

    @PostMapping(value = {"", "/list"})
    public HttpResult list(@RequestBody MaterialItemQueryParam param) {
        return success(materialItemBO.findPage(param));
    }

}