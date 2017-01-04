package com.example.administrator.mvp.model;

/**
 * Created by Administrator on 2016/12/7.
 */

public interface BookListModelListener {

    //获取 刷新书本的方法
    void getRefreshBookList(String q, String tag, int start, int count, String fields, CompleteListener listener);
    //获取 上拉书本的方法

    void getLoadBookList(String q, String tag, int start, int count, String fields, CompleteListener listener);

}
