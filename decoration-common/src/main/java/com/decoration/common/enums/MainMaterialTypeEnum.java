package com.decoration.common.enums;

import com.decoration.common.exception.ParamException;

/**
 * Description: 主材类型枚举值
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 16:54
 */
public enum MainMaterialTypeEnum {
    HARD(1, "主材"),
    SOFT(2, "辅材"),
    AUXILIARY(3, "软材"),
    OTHERS(4, "其它");

    private Integer value;
    private String name;

    MainMaterialTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static MainMaterialTypeEnum byValue(Integer value) {
        for (MainMaterialTypeEnum e : MainMaterialTypeEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }

    public static MainMaterialTypeEnum byName(String name) {
        for (MainMaterialTypeEnum e : MainMaterialTypeEnum.values()) {
            if (e.getName().equals(name.trim())) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }
}