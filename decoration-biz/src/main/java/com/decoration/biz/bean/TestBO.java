package com.decoration.biz.bean;

import com.decoration.biz.vo.TestVO;
import com.decoration.dao.entity.TestDO;
import com.decoration.service.bean.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/10/18 14:01
 */
@Component
public class TestBO {
    @Autowired
    private TestService testService;

    public List<TestVO> findAll() {
        List<TestDO> all = testService.findAll();
        List<TestVO> vos = new ArrayList<>(all.size());
        for(TestDO testDO:all){
            vos.add(new TestVO().build(testDO));
        }
        return vos;
    }
}