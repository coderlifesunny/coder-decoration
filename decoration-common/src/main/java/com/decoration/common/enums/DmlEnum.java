package com.decoration.common.enums;

import com.decoration.common.exception.ParamException;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/11/2 14:56
 */
public enum DmlEnum {
    INSERT(1, "增加"),
    DELETE(2, "删除"),
    UPDATE(3, "修改");

    private Integer value;
    private String name;

    DmlEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static DmlEnum byValue(Integer value) {
        for (DmlEnum e : DmlEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }

    public static DmlEnum byName(String name) {
        for (DmlEnum e : DmlEnum.values()) {
            if (e.getName().equals(name.trim())) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }
}