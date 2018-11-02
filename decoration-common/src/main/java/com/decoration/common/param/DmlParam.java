package com.decoration.common.param;

import com.decoration.common.enums.DmlEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Description: 数据库操纵参数
 *
 * @Author Guangcai.xu
 * @Date 2018/11/2 14:30
 */
@Data
public class DmlParam implements Serializable {

    /**
     * 操作人
     */
    protected String operateUser;

    /**
     * 操作类型
     */
    protected DmlEnum dmlEnum;
}