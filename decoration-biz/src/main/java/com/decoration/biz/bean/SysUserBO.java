package com.decoration.biz.bean;

import com.decoration.biz.param.SysUserAddParam;
import com.decoration.common.exception.BusinessException;
import com.decoration.common.utils.EncodeUtil;
import com.decoration.dao.entity.SysMenuDO;
import com.decoration.dao.entity.SysRoleDO;
import com.decoration.dao.entity.SysUserDO;
import com.decoration.service.bean.SysUserService;
import com.google.common.collect.Sets;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Description: 用户复杂业务类
 *
 * @Author Guangcai.xu
 * @Date 2018/11/21 10:37
 */
@Component
public class SysUserBO {

    @Resource
    private SysUserService sysUserService;

    /**
     * 获取用户的英文角色列表
     *
     * @param userId
     * @return
     */
    public Set<String> getUserEnRoles(Integer userId) {
        List<SysRoleDO> userRoles = sysUserService.findByUserId(userId);
        Set<String> enRoles = Sets.newHashSet();
        for (SysRoleDO roleDO : userRoles) {
            enRoles.add(roleDO.getEnname());
        }
        return enRoles;
    }

    /**
     * 获取用户的所有菜单（包括菜单和权限属性）
     *
     * @return
     */
    public Set<SysMenuDO> getUserMenus() {
        return Sets.newHashSet();
    }

    /**
     * 获取用户的权限列表（menu中的permission字段）
     *
     * @param userId
     * @return
     */
    public Set<String> getUserPermissions(Integer userId) {
        Set<SysMenuDO> userMenus = this.getUserMenus();
        Set<String> userPermissions = Sets.newHashSet();
        for (SysMenuDO menuDO : userMenus) {
            String permission = menuDO.getPermission();
            if (StringUtils.isEmpty(permission)) {
                continue;
            }
            userPermissions.add(permission);
        }
        return userPermissions;
    }

    /**
     * 新增用户
     *
     * @param param
     */
    public void add(SysUserAddParam param) {
        SysUserDO sysUserDO = new SysUserDO();
        param.setPassword(EncodeUtil.md5Hex(param.getPassword()));
        BeanUtils.copyProperties(param, sysUserDO);
        try {
            sysUserService.add(sysUserDO);
        } catch (DuplicateKeyException e) {
            throw new BusinessException("用户名重复");
        }
    }
}