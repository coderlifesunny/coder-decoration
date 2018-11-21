package com.decoration.web.shiro;

import com.decoration.biz.bean.SysUserBO;
import com.decoration.common.enums.StateEnum;
import com.decoration.common.param.SysUserQueryParam;
import com.decoration.common.utils.JWTUtil;
import com.decoration.dao.entity.SysUserDO;
import com.decoration.service.bean.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/11/17 11:36
 */
@Component
@Slf4j
public class CoderRealm extends AuthorizingRealm {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysUserBO sysUserBO;

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null || !JWTUtil.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
        //登录名唯一索引
        List<SysUserDO> users = sysUserService.findPage(new SysUserQueryParam(username));
        if (CollectionUtils.isEmpty(users)) {
            throw new AuthenticationException("该用户不存在！");
        }
        int status = users.get(0).getStatus();
        if (StateEnum.byValue(status) == StateEnum.DISABLE) {
            throw new AuthenticationException("该用户已被封号！");
        }

        return new SimpleAuthenticationInfo(token, token, "CoderRealm");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("————权限认证————");
        String username = JWTUtil.getUsername(principals.toString());
        //登录名唯一索引
        List<SysUserDO> users = sysUserService.findPage(new SysUserQueryParam(username));
        Integer userId = users.get(0).getId();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //每个用户可以设置新的权限
//        String permission = userMapper.getPermission(username);
        //设置该用户拥有的角色和权限
        info.setRoles(sysUserBO.getUserEnRoles(userId));
        info.setStringPermissions(sysUserBO.getUserPermissions(userId));
        return info;
    }
}
