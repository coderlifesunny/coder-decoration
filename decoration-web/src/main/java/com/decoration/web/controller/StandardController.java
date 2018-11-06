package com.decoration.web.controller;

import com.decoration.biz.bean.StandardBO;
import com.decoration.biz.param.StandardDmlParam;
import com.decoration.common.entity.HttpResult;
import com.decoration.common.enums.DmlEnum;
import com.decoration.common.param.StandardQueryParam;
import com.decoration.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public HttpResult add(@RequestBody StandardDmlParam param) {
        param.setDmlEnum(DmlEnum.INSERT);
        return success(standardBO.dmlOperate(param));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody StandardDmlParam param) {
        param.setDmlEnum(DmlEnum.DELETE);
        return success(standardBO.dmlOperate(param));
    }

    @PostMapping("/modify")
    public HttpResult modify(@RequestBody StandardDmlParam param) {
        param.setDmlEnum(DmlEnum.UPDATE);
        return success(standardBO.dmlOperate(param));
    }

    @GetMapping("/byName")
    public HttpResult findByName(@RequestParam String name) {
        return success(standardBO.findByName(name));
    }
}