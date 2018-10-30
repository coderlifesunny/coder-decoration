package com.decoration.dao.entity;

import lombok.Data;

/**
 * @author
 */
@Data
public class StandardDO extends BaseOperatorDO {

    /**
     * 主材名称
     */
    private String name;

    /**
     * 业务状态
     */
    private Short status;

    /**
     * 备注信息
     */
    private String remark;

}