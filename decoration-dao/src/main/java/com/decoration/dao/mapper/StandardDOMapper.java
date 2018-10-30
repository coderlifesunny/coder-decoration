package com.decoration.dao.mapper;

import com.decoration.common.param.StandardQueryParam;
import com.decoration.dao.entity.StandardDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StandardDOMapper {
    int insert(StandardDO record);

    List<StandardDO> selectPage(@Param("param") StandardQueryParam param);
}