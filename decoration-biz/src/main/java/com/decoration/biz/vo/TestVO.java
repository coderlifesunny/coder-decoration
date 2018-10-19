package com.decoration.biz.vo;

import com.decoration.dao.entity.TestDO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/10/18 14:02
 */
@Data
public class TestVO {
    private Integer id;

    private String name;

    private String desc;

    public TestVO build(TestDO testDO){
        if(null == testDO){
            return this;
        }
        BeanUtils.copyProperties(testDO,this);
        this.setDesc(this.id+"_"+this.name);
        return this;
    }
}