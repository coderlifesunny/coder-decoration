package com.decoration.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description: 枚举对象键值对
 *
 * @Author Guangcai.xu
 * @Date 2018/7/3 17:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnumObj {
    private String code;
    private String name;

    public EnumObj getObj(List<EnumObj> list, String code) {
        for (EnumObj obj : list) {
            if (obj.getCode().equals(code)) {
                return obj;
            }
        }
        return null;
    }
}