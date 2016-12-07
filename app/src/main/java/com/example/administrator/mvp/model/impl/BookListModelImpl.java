package com.example.administrator.mvp.model.impl;

import com.example.administrator.mvp.model.BookListModelListener;
import com.example.administrator.mvp.model.CompleteListener;

/**
 * Created by Administrator on 2016/12/7.
 */

public class BookListModelImpl implements BookListModelListener{

    //获取图书列表的网络请求方法
    @Override
    public void getBookList(String q, String tag, int start, int count, String fields, CompleteListener listener) {

        //成功获取数据
        listener.onSuccess("成功的数据"+q+tag+start+count+fields);
        //失败获取的错误原因

        listener.onFaild("失败了404"+q+tag+start+count+fields);
    }


}
