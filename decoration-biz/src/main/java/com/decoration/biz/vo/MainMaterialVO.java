package com.decoration.biz.vo;

import com.decoration.common.enums.MainMaterialTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 页面对象
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 17:04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainMaterialVO {

    private Integer id;

    /**
     * 主材名称
     */
    private String name;

    /**
     * 类型
     */
    private Short type;

    /**
     * 类型对应的描述信息
     */
    private String typeStr;

    private String imgUrl;

    public String getTypeStr() {
        return MainMaterialTypeEnum.byValue(type.intValue()).getName();
    }

}