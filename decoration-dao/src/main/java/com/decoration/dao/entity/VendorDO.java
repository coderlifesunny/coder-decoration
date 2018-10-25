package com.decoration.dao.entity;

import lombok.Data;

/**
 * @author
 */
@Data
public class VendorDO extends BaseOperatorDO {

    /**
     * 供商名称（合作商家）
     */
    private String companyName;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * l联系电话
     */
    private String contactTel;

    /**
     * 联系地址
     */
    private String contactAdd;

    /**
     * 经营的材料列表
     */
    private String materialIds;

    /**
     * 业务状态:1有效 0：无效
     */
    private Short status;

    /**
     * 备注信息
     */
    private String remark;

}