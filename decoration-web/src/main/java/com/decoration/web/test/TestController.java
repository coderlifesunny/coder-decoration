package com.decoration.web.test;

import com.decoration.biz.bean.TestBO;
import com.decoration.biz.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: 测试
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestBO testBO;

    @GetMapping("list")
    public List<TestVO> test() {
        return testBO.findAll();
    }

    @GetMapping("time")
    public String test1(){
        return String.valueOf(System.currentTimeMillis());
    }
}