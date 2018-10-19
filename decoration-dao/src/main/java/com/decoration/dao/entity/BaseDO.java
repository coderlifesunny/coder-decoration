package com.decoration.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Description: 数据基类
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 16:12
 */
@Data
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -8139929879209660401L;
    /**
     * 自增ID
     */
    protected Integer id;

    /**
     * 创建时间
     */
    protected Date created;

    /**
     * 更新时间
     */
    protected Date modified;

    /**
     * 数据状态 DataStatusEnum
     */
    protected Boolean yn;
}