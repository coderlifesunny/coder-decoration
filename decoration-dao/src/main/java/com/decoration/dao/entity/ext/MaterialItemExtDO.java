package com.decoration.dao.entity.ext;

import com.decoration.dao.entity.MaterialItemDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 型号扩展DO
 *
 * @Author Guangcai.xu
 * @Date 2018/11/3 11:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialItemExtDO extends MaterialItemDO {
    /**
     * 规格
     */
    private String standard;

}