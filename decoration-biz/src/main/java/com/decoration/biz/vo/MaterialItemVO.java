package com.decoration.biz.vo;

import com.decoration.common.enums.StateEnum;
import com.decoration.common.util.DateUtil;
import com.decoration.dao.entity.ext.MaterialItemExtDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * Description: 主材型号页面对象
 *
 * @Author Guangcai.xu
 * @Date 2018/11/3 11:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialItemVO {

    private Integer id;

    private String brand;

    private String modelName;

    private String modelRemark;

    private Short status;

    private String tag;

    private Integer standardId;
    /**
     * 规格名称
     */
    private String standard;

    private String modified;

    private String operateUser;

    public MaterialItemVO build(MaterialItemExtDO materialItemExtDO) {
        if (null == materialItemExtDO) {
            return this;
        }
        BeanUtils.copyProperties(materialItemExtDO, this);
        this.setModelRemark(materialItemExtDO.getModelRemark());
        this.setModified(DateUtil.format(materialItemExtDO.getModified()));
        this.setTag(StateEnum.byValue(status.intValue()).getName());
        return this;
    }
}