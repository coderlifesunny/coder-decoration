package com.decoration.dao.mapper;

import com.decoration.common.param.MaterialItemQueryParam;
import com.decoration.dao.entity.MaterialItemDO;
import com.decoration.dao.entity.ext.MaterialItemExtDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialItemDOMapper {
    int insert(MaterialItemDO record);

    List<MaterialItemExtDO> selectPage(@Param("param") MaterialItemQueryParam param);

    int updateByKeySelective(MaterialItemDO record);

    int deleteByKey(Integer id);
}