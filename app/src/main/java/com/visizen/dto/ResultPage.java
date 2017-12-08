package com.visizen.dto;

/**
 * Created by Administrator on 2017/12/4.
 */
public class ResultPage<T> {

    private long records;//查询出的记录数
    private long size;
    private long total;//总页数

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    private T rows;//包含实际数据的数组



    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    private long page;//当前页
}
