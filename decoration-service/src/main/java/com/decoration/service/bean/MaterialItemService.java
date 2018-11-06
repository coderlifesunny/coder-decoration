package com.decoration.service.bean;

import com.decoration.common.param.MaterialItemQueryParam;
import com.decoration.dao.entity.MaterialItemDO;
import com.decoration.dao.entity.ext.MaterialItemExtDO;

import java.util.List;

/**
 * Description: 主材型号服务
 *
 * @Author Guangcai.xu
 * @Date 2018/11/3 11:39
 */
public interface MaterialItemService {
    int add(MaterialItemDO materialItemDO);

    List<MaterialItemExtDO> findPage(MaterialItemQueryParam param);

    int modify(MaterialItemDO materialItemDO);

    int delete(Integer id);
}