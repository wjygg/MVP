package com.example.administrator.mvp.common.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/1/14.
 */

public interface BeautyGirService {

   @GET("data/%E7%A6%8F%E5%88%A9/{count}/{page}")
   Call<ResponseBody> getBeautyGir(@Path("count") int count, @Path("page") int page);
}
