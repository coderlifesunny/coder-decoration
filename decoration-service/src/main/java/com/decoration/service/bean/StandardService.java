package com.decoration.service.bean;

import com.decoration.common.param.StandardQueryParam;
import com.decoration.dao.entity.StandardDO;

import java.util.List;

/**
 * Description: 规格接口
 *
 * @Author Guangcai.xu
 * @Date 2018/10/26 13:27
 */
public interface StandardService {
    int add(StandardDO standardDO);

    List<StandardDO> findPage(StandardQueryParam param);
}
