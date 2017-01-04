package com.example.administrator.mvp.model.impl;

import com.example.administrator.mvp.common.ServcieFactory;
import com.example.administrator.mvp.common.URL;
import com.example.administrator.mvp.common.service.BookService;
import com.example.administrator.mvp.model.BookListModelListener;
import com.example.administrator.mvp.model.CompleteListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/7.
 */

public class BookListModelImpl implements BookListModelListener{

    //获取图书列表的网络请求方法
    @Override
    public void getRefreshBookList(String q, String tag, int start, int count, String fields, final CompleteListener listener) {

        BookService service = ServcieFactory.createService(URL.BOOKURL, BookService.class);

        Call<ResponseBody> bookList = service.getBookList(q, tag, start, count, fields);

        bookList.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    listener.onRefreshSuccess(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

               listener.onFaild(t.getMessage().toString());
            }
        });


    }


    @Override
    public void getLoadBookList(String q, String tag, int start, int count, String fields, final CompleteListener listener) {

        BookService service = ServcieFactory.createService(URL.BOOKURL, BookService.class);

        Call<ResponseBody> bookList = service.getBookList(q, tag, start, count, fields);

        bookList.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    listener.onLoadSuccess(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                listener.onFaild(t.getMessage().toString());
            }
        });

    }
}
