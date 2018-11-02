package com.decoration.biz.param;

import com.decoration.common.param.DmlParam;
import lombok.Data;

/**
 * Description: 规格操作参数
 *
 * @Author Guangcai.xu
 * @Date 2018/11/2 14:37
 */
@Data
public class StandardDmlParam extends DmlParam {

    private Integer id;

    private String name;

    private String remark;

    private Short status;

}