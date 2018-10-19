package com.decoration.service.bean;

import com.decoration.dao.entity.TestDO;

import java.util.List;

/**
 * Description: 测试
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
public interface TestService {
    List<TestDO> findAll();
}