package com.decoration.dao.mapper;

import com.decoration.common.param.SysUserQueryParam;
import com.decoration.dao.entity.SysRoleDO;
import com.decoration.dao.entity.SysUserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserDOMapper {

    /**
     * 根据参数查询信息（可分页）
     *
     * @param param
     * @return
     */
    List<SysUserDO> selectPage(@Param("param") SysUserQueryParam param);

    void insert(SysUserDO record);

}