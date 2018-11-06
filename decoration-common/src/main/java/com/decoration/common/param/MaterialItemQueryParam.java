package com.decoration.common.param;

import lombok.Data;

/**
 * Description: 型号查询参数
 *
 * @Author Guangcai.xu
 * @Date 2018/11/3 11:00
 */
@Data
public class MaterialItemQueryParam extends BaseParam{

    /**
     * 主材ID
     */
    private Integer mainId;

    /**
     * 主材品牌
     */
    private String brand;

    /**
     * 型号名称
     */
    private String modelName;

    /**
     * 状态标识 1：有效  0：无效
     */
    private Integer status;
}