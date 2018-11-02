package com.decoration.biz.bean;

import com.decoration.biz.vo.MainMaterialVO;
import com.decoration.dao.entity.MainMaterialDO;
import com.decoration.service.bean.MainMaterialService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description: 主材业务类
 *
 * @Author Guangcai.xu
 * @Date 2018/10/19 17:07
 */
@Component
public class MainMaterialBO {

    @Autowired
    private MainMaterialService mainMaterialService;

    /**
     * 查询所有的主材
     *
     * @return
     */
    public List<MainMaterialVO> findAll() {
        List<MainMaterialDO> allDO = mainMaterialService.findAll();
        return Lists.newArrayList(Lists.transform(allDO, tuple -> MainMaterialVO.builder().id(tuple.getId()).name(tuple.getName()).type(tuple.getType()).imgUrl(tuple.getImgUrl()).build()));
    }
}