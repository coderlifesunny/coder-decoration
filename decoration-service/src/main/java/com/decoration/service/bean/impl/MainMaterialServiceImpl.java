package com.decoration.service.bean.impl;

import com.decoration.dao.entity.MainMaterialDO;
import com.decoration.dao.mapper.MainMaterialDOMapper;
import com.decoration.service.bean.MainMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 17:15
 */
@Service
public class MainMaterialServiceImpl implements MainMaterialService {

    @Autowired
    private MainMaterialDOMapper mainMaterialDOMapper;

    @Override
    public List<MainMaterialDO> findAll() {
        return mainMaterialDOMapper.selectAll();
    }
}