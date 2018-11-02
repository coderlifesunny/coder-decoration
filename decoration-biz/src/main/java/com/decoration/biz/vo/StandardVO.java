package com.decoration.biz.vo;

import com.decoration.common.enums.StateEnum;
import com.decoration.common.util.DateUtil;
import com.decoration.dao.entity.StandardDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * Description: 规格VO对象
 *
 * @Author Guangcai.xu
 * @Date 2018/10/30 15:10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardVO {

    private Integer id;

    private String name;

    private String remark;

    private Short status;

    private String tag;

    private String modified;

    private String operateUser;

    public StandardVO build(StandardDO standardDO) {
        if (null == standardDO) {
            return this;
        }
        BeanUtils.copyProperties(standardDO, this);
        this.setModified(DateUtil.format(standardDO.getModified()));
        this.setTag(StateEnum.byValue(status.intValue()).getName());
        return this;
    }

}