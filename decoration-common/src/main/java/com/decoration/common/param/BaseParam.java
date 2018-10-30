package com.decoration.common.param;

import java.io.Serializable;

/**
 * Description: 基本的查询参数
 *
 * @Author Guangcai.xu
 * @Date 2018/10/30 14:28
 */
public abstract class BaseParam implements Serializable {

    /**
     * 每页显示条数
     */
    private Integer pageSize;
    /**
     * 当前页
     */
    private Integer currentPage;

    public BaseParam() { //防止导出时不传分页参数，发生空指针异常
        this.pageSize = 100;
        this.currentPage = 1;
    }

    public Integer getPageSize() {
        if (this.pageSize == null) {
            throw new IllegalArgumentException("pageSize");
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        if (this.currentPage == null) {
            throw new IllegalArgumentException("currentPage");
        }
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}