package com.decoration.common.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 查询规格参数
 *
 * @Author Guangcai.xu
 * @Date 2018/10/30 14:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardQueryParam extends BaseParam {

    /**
     * 规格名称
     */
    private String name;

    /**
     * 状态标识 1：有效  0：无效
     */
    private Integer status;
}