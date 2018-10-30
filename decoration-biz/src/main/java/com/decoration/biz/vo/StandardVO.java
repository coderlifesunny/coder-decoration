package com.decoration.biz.vo;

import com.decoration.dao.entity.StandardDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

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

    private Short status;

    private Date modified;

    private String operateUser;

    public StandardVO build(StandardDO standardDO) {
        if (null == standardDO) {
            return this;
        }
        BeanUtils.copyProperties(standardDO, this);
        return this;
    }

}