package com.decoration.service.bean.impl;

import com.decoration.dao.entity.TestDO;
import com.decoration.dao.mapper.TestDOMapper;
import com.decoration.service.bean.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 测试
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 15:49
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDOMapper testDOMapper;

    @Override
    public List<TestDO> findAll() {
        return testDOMapper.selectAll();
    }
}