package com.decoration.common.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 用户查询参数
 *
 * @Author Guangcai.xu
 * @Date 2018/11/20 15:24
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysUserQueryParam extends BaseParam {

    /**
     * 登录名称
     */
    private String username;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 角色类型
     */
    private Integer roleType;

    /**
     * 状态标识 1：有效  0：无效
     */
    private Integer status;

    public SysUserQueryParam(String username) {
        this.username = username;
    }
}