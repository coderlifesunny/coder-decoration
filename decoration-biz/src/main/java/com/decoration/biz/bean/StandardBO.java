package com.decoration.biz.bean;

import com.decoration.biz.vo.StandardVO;
import com.decoration.common.entity.PagedList;
import com.decoration.common.exception.BusinessException;
import com.decoration.common.param.StandardQueryParam;
import com.decoration.dao.entity.StandardDO;
import com.decoration.service.bean.StandardService;
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
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/10/30 15:09
 */
@Component
@Slf4j
public class StandardBO {

    @Autowired
    private StandardService standardService;

    /**
     * 查询分页list结果
     *
     * @param param
     * @return
     */
    public PagedList<StandardVO> findPage(StandardQueryParam param) {
        Page page = PageHelper.startPage(param.getCurrentPage(), param.getPageSize());
        List<StandardDO> dos = standardService.findPage(param);
        if (CollectionUtils.isEmpty(dos)) {
            return new PagedList<>(new ArrayList<StandardVO>());
        }
        List<StandardVO> transform = Lists.transform(dos, tuple -> new StandardVO().build(tuple));
        return new PagedList<>(transform, page.getTotal(), page.getPageSize(), page.getPageNum());
    }
}