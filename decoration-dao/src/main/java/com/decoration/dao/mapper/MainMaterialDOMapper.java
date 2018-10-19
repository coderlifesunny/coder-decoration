package com.decoration.dao.mapper;

import com.decoration.dao.entity.MainMaterialDO;

import java.util.List;

public interface MainMaterialDOMapper {

    int insert(MainMaterialDO record);

    /**
     * 查询出所有的正常的主材列表
     * @return
     */
    List<MainMaterialDO> selectAll();
}