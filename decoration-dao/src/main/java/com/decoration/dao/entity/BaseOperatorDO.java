package com.decoration.dao.entity;

import lombok.Data;

/**
 * Description: 要记录操作者的DO对象基类
 *
 * @Author Guangcai.xu
 * @Date 2018/10/25 14:18
 */
@Data
public class BaseOperatorDO extends BaseDO {

    /**
     * 操作者
     */
    protected String operateUser;
}