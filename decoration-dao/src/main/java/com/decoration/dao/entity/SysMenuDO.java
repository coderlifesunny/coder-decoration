package com.decoration.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
public class SysMenuDO extends BaseOperatorDO{

    /**
     * 父级编号
     */
    private Integer parentId;

    /**
     * 所有父级编号
     */
    private String parentIds;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 链接
     */
    private String href;

    /**
     * 是否在菜单中显示
     */
    private Byte isShow;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 业务状态:0无效  1有效
     */
    private Short status;

    /**
     * 备注信息
     */
    private String remark;

}