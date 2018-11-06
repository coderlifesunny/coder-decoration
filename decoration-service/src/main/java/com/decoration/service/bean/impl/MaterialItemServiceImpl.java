package com.decoration.service.bean.impl;

import com.decoration.common.param.MaterialItemQueryParam;
import com.decoration.dao.entity.MaterialItemDO;
import com.decoration.dao.entity.ext.MaterialItemExtDO;
import com.decoration.dao.mapper.MaterialItemDOMapper;
import com.decoration.service.bean.MaterialItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/11/3 11:40
 */
@Service
public class MaterialItemServiceImpl implements MaterialItemService {

    @Autowired
    private MaterialItemDOMapper materialItemDOMapper;

    @Override
    public int add(MaterialItemDO materialItemDO) {
        return materialItemDOMapper.insert(materialItemDO);
    }

    @Override
    public List<MaterialItemExtDO> findPage(MaterialItemQueryParam param) {
        return materialItemDOMapper.selectPage(param);
    }

    @Override
    public int modify(MaterialItemDO materialItemDO) {
        return materialItemDOMapper.updateByKeySelective(materialItemDO);
    }

    @Override
    public int delete(Integer id) {
        return materialItemDOMapper.deleteByKey(id);
    }
}