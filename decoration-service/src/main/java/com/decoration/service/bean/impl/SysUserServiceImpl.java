package com.decoration.service.bean.impl;

import com.decoration.common.param.SysUserQueryParam;
import com.decoration.dao.entity.SysRoleDO;
import com.decoration.dao.entity.SysUserDO;
import com.decoration.dao.mapper.SysRoleDOMapper;
import com.decoration.dao.mapper.SysUserDOMapper;
import com.decoration.service.bean.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/11/20 15:47
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDOMapper sysUserDOMapper;

    @Autowired
    private SysRoleDOMapper sysRoleDOMapper;

    @Override
    public List<SysUserDO> findPage(SysUserQueryParam param) {
        return sysUserDOMapper.selectPage(param);
    }

    @Override
    public List<SysRoleDO> findByUserId(Integer userId) {
        return sysRoleDOMapper.selectRolesByUserId(userId);
    }

    @Override
    public void add(SysUserDO sysUserDO) {
        sysUserDOMapper.insert(sysUserDO);
    }
}