package com.decoration.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author
 */
@Data
public class SysUserDO extends BaseOperatorDO {

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private Date loginDate;

    /**
     * 业务状态:0无效  1有效
     */
    private Short status;

    /**
     * 备注信息
     */
    private String remark;

}