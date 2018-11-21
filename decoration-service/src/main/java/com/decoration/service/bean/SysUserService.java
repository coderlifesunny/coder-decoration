package com.decoration.service.bean;

import com.decoration.common.param.SysUserQueryParam;
import com.decoration.dao.entity.SysRoleDO;
import com.decoration.dao.entity.SysUserDO;

import java.util.List;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/11/20 15:46
 */
public interface SysUserService {

    /**
     * 查询用户列表，通过传入的参数控制
     * @param param
     * @return
     */
    List<SysUserDO> findPage(SysUserQueryParam param);

    /**
     * 通过用户ID查询用户的角色列表
     * @param userId
     * @return
     */
    List<SysRoleDO> findByUserId(Integer userId);

    void add(SysUserDO sysUserDO);

}