package com.decoration.common.enums;

import com.decoration.common.exception.ParamException;

/**
 * Description: 角色类型枚举
 *
 * @Author Guangcai.xu
 * @Date 2018/11/21 10:50
 */
public enum RoleTypeEnum {
    SUPER(1, "超级"),
    SYSTEM(2, "系统"),
    GENERAL(3, "一般");

    private Integer value;
    private String name;

    RoleTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static RoleTypeEnum byValue(Integer value) {
        for (RoleTypeEnum e : RoleTypeEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }

    public static RoleTypeEnum byName(String name) {
        for (RoleTypeEnum e : RoleTypeEnum.values()) {
            if (e.getName().equals(name.trim())) {
                return e;
            }
        }
        throw new ParamException("非法标识");
    }
}