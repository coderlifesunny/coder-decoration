package com.decoration.biz.bean;

import com.decoration.biz.vo.MaterialItemVO;
import com.decoration.biz.vo.StandardVO;
import com.decoration.common.entity.PagedList;
import com.decoration.common.param.MaterialItemQueryParam;
import com.decoration.common.param.StandardQueryParam;
import com.decoration.dao.entity.MaterialItemDO;
import com.decoration.dao.entity.StandardDO;
import com.decoration.dao.entity.ext.MaterialItemExtDO;
import com.decoration.service.bean.MaterialItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 业务类
 *
 * @Author Guangcai.xu
 * @Date 2018/11/3 11:43
 */
@Component
@Slf4j
public class MaterialItemBO {

    @Autowired
    private MaterialItemService materialItemService;

    /**
     * 查询分页list结果
     *
     * @param param
     * @return
     */
    public PagedList<MaterialItemVO> findPage(MaterialItemQueryParam param) {
        Page page = PageHelper.startPage(param.getCurrentPage(), param.getPageSize());
        List<MaterialItemExtDO> dos = materialItemService.findPage(param);
        if (CollectionUtils.isEmpty(dos)) {
            return new PagedList<>(new ArrayList<MaterialItemVO>());
        }
        List<MaterialItemVO> transform = Lists.transform(dos, tuple -> new MaterialItemVO().build(tuple));
        return new PagedList<>(transform, page.getTotal(), page.getPageSize(), page.getPageNum());
    }

}