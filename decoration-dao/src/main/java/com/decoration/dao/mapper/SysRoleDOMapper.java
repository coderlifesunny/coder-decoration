package com.decoration.dao.mapper;

import com.decoration.common.param.SysRoleQueryParam;
import com.decoration.dao.entity.SysRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleDOMapper {

    /**
     * 根据参数查询信息（可分页）
     *
     * @param param
     * @return
     */
    List<SysRoleDO> selectPage(@Param("param") SysRoleQueryParam param);

    /**
     * 主表的方法：通过用户ID查询出用户的角色列表
     *
     * @param userId
     * @return
     */
    List<SysRoleDO> selectRolesByUserId(Integer userId);
}