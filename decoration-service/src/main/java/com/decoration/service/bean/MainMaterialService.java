package com.decoration.service.bean;

import com.decoration.dao.entity.MainMaterialDO;

import java.util.List;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 17:13
 */
public interface MainMaterialService {

    /**
     * 查询所有的状态正常的
     * @return
     */
    List<MainMaterialDO> findAll();
}
