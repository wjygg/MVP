package com.example.administrator.mvp.common.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangjingyun on 2016/12/8.
 *
 * http://blog.csdn.net/duanyy1990/article/details/52139294 retrofit用法详解
 */

public interface BookService {
    @GET("book/search")
    Call<ResponseBody> getBookList(@Query("q") String q, @Query("tag") String tag, @Query("start") int start, @Query("count") int count, @Query("fields") String fields);

}
