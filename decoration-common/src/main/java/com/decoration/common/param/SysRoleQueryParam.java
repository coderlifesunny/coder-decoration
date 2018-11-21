package com.decoration.common.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 角色查询参数
 *
 * @Author Guangcai.xu
 * @Date 2018/11/21 10:21
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysRoleQueryParam extends BaseParam {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 状态标识 1：有效  0：无效
     */
    private Integer status;
}