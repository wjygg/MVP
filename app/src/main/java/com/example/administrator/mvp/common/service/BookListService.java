package com.example.administrator.mvp.common.service;

import com.example.administrator.mvp.entity.BookListEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/12/8.
 */

public class BookListService {
    @GET("book/search")
    Call<BookListEntity> getBookList(@Query("q") String q, @Query("tag") String tag) {
        return null;
    }

}
