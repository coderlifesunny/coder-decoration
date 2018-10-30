package com.decoration.common.entity;

import com.github.pagehelper.Page;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 分页对象
 *
 * @Author Guangcai.xu
 * @Date 2018/10/30 14:21
 */
public class PagedList<T> {

    //每页条数
    private int pageSize;
    //页码
    private int pageNum;
    //总条数
    private long totalCount;
    //总页数
    private int pageCount;
    // 查询返回条数（返还给前台格式要求）
    private long total;
    //当前页（返还给前台格式要求）
    private int currentPage;


    private List<T> list = new ArrayList<>();

    public PagedList(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageCount = page.getPages();
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.totalCount = page.getTotal();
            this.total = page.getTotal();
            this.currentPage = page.getPageNum();
            this.list = page;
        }
    }

    public PagedList(List<T> list, long totalCount, int pageSize, int pageNum) {
        setList(list);
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.total = totalCount;
        this.currentPage = pageNum;
        if (pageSize == 0) {
            pageCount = 1;
        } else {
            if (totalCount <= pageSize) {
                pageCount = 1;
            } else {
                pageCount = (int) ((totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1);
            }
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}