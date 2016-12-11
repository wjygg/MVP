package com.example.administrator.mvp.model.impl;

import com.example.administrator.mvp.common.ServcieFactory;
import com.example.administrator.mvp.common.URL;
import com.example.administrator.mvp.common.service.BookService;
import com.example.administrator.mvp.entity.BookListEntity;
import com.example.administrator.mvp.model.BookListModelListener;
import com.example.administrator.mvp.model.CompleteListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/7.
 */

public class BookListModelImpl implements BookListModelListener{

    //获取图书列表的网络请求方法
    @Override
    public void getBookList(String q, String tag, int start, int count, String fields, final CompleteListener listener) {


        BookService service = ServcieFactory.createService(URL.BOOKURL, BookService.class);
        Call<BookListEntity> bookList = service.getBookList(q, tag, start, count, fields);
        bookList.enqueue(new Callback<BookListEntity>() {
            @Override
            public void onResponse(Call<BookListEntity> call, Response<BookListEntity> response) {
                listener.onSuccess("成功的数据"+response.body().toString());
            }

            @Override
            public void onFailure(Call<BookListEntity> call, Throwable t) {
                listener.onSuccess("请求失败的信息"+t.getMessage().toString());
            }
        });

    }


}
