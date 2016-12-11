package com.example.administrator.mvp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/8.
 */

public class BookListEntity implements Serializable{

    private int code;
    private String msg;
    private int count;
    private int start;
    private int total;
    protected List<BookInfoEntity> books;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BookInfoEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookInfoEntity> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookListEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", books=" + books +
                '}';
    }
}
