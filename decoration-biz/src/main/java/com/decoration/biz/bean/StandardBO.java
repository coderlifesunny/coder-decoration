package com.decoration.biz.bean;

import com.decoration.biz.param.StandardDmlParam;
import com.decoration.biz.vo.StandardVO;
import com.decoration.common.entity.PagedList;
import com.decoration.common.exception.ParamException;
import com.decoration.common.param.StandardQueryParam;
import com.decoration.dao.entity.StandardDO;
import com.decoration.service.bean.StandardService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    /**
     * 根据规格名称模糊查询信息
     *
     * @param name
     * @return
     */
    public List<StandardVO> findByName(String name) {
        PagedList<StandardVO> page = this.findPage(new StandardQueryParam(name, -999));
        if (page.getTotal() > 10) {
            throw new ParamException("搜索结果过大于10条，请详细输入！");
        }
        return page.getList();
    }

    /**
     * 数据操作
     *
     * @param param
     * @return
     */
    public int dmlOperate(StandardDmlParam param) {
        //获取登录用户
        StandardDO standardDO = new StandardDO();
        BeanUtils.copyProperties(param, standardDO);
        standardDO.setOperateUser("sys");
        int cnt = 0;
        try {
            switch (param.getDmlEnum()) {
                case INSERT:
                    cnt = standardService.add(standardDO);
                    break;
                case DELETE:
                    cnt = standardService.delete(param.getId());
                    break;
                case UPDATE:
                    cnt = standardService.modify(standardDO);
                    break;
            }
        } catch (DuplicateKeyException exception) {
            throw new ParamException("规格：" + standardDO.getName() + "已存在，保存失败！");
        }
        return cnt;
    }
}