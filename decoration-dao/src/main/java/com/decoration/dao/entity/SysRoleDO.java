package com.decoration.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
public class SysRoleDO extends BaseOperatorDO {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 英文名称
     */
    private String enname;

    /**
     * 角色类型
     */
    private Short roleType;

    /**
     * 业务状态:0无效  1有效
     */
    private Short status;

    /**
     * 备注信息
     */
    private String remark;

}