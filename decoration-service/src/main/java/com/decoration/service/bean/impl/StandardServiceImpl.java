package com.decoration.service.bean.impl;

import com.decoration.common.param.StandardQueryParam;
import com.decoration.dao.entity.StandardDO;
import com.decoration.dao.mapper.StandardDOMapper;
import com.decoration.service.bean.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/10/26 13:28
 */
@Service
public class StandardServiceImpl implements StandardService {

    @Autowired
    private StandardDOMapper standardDOMapper;

    @Override
    public int add(StandardDO standardDO) {
        return standardDOMapper.insert(standardDO);
    }

    @Override
    public List<StandardDO> findPage(StandardQueryParam param) {
        return standardDOMapper.selectPage(param);
    }

    @Override
    public int modify(StandardDO standardDO) {
        return standardDOMapper.updateByKeySelective(standardDO);
    }

    @Override
    public int delete(Integer id) {
        return standardDOMapper.deleteByKey(id);
    }
}