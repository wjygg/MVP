package com.example.administrator.mvp.model;

/**
 * Created by Administrator on 2016/12/7.
 */

public interface BookListModelListener {

    //获取 书本的方法
    void getBookList(String q, String tag, int start, int count, String fields, CompleteListener listener);

}
