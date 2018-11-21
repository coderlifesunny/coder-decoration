package com.decoration.biz.param;

import com.decoration.common.param.DmlParam;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * Description: 新增用户参数
 *
 * @Author Guangcai.xu
 * @Date 2018/11/21 17:49
 */
@Data
public class SysUserAddParam extends DmlParam {

    private String username;

    private String password;

    private String no;

    private String name;

    private String email;

    private String phone;

    private String remark;
}