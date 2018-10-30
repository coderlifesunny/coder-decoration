package com.decoration.dao.entity;

import lombok.Data;

/**
 * @author 
 */
@Data
public class MaterialItemDO extends BaseOperatorDO {

    /**
     * 对应的主材大类的ID
     */
    private Integer mainId;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 型号名称
     */
    private String modelName;

    /**
     * 型号备注
     */
    private String modelRemark;

    /**
     * 型号对应的规格ID
     */
    private Integer standardId;

    /**
     * 业务状态
     */
    private Short status;

    /**
     * 图片链接
     */
    private String imgUrl;

    /**
     * 备注信息
     */
    private String remark;

}