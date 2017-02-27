package com.example.administrator.mvp.common.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 首页番剧 接口
 *
 * Created by wangjingyun on 2017/2/27.
 */

public interface SomeDramaService {
    @GET("api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=ios")
    Call<ResponseBody> getsomeDramaService();
}
