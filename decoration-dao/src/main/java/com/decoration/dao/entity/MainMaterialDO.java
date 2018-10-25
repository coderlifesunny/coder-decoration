package com.decoration.dao.entity;

import lombok.Data;

/**
 * @author
 */
@Data
public class MainMaterialDO extends BaseOperatorDO {

    /**
     * 主材名称
     */
    private String name;

    /**
     * 1硬材，1软材，3辅材，4其他
     */
    private Short type;

    /**
     * 业务状态
     */
    private Short status;

}