package com.example.administrator.mvp.common.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * recycleview 多布局 请求首页数据
 * Created by wangjingyun on 2017/2/12.
 *
 *
 */

public interface MultiLayoutService {

    @GET("AppIndex/home?_device=android&_hwid=51e96f5f2f54d5f9&_ulv=10000&access_key=563d6046f06289cbdcb472601ce5a761&appkey=c1b107428d337928&build=410000&platform=android&scale=xxhdpi&sign=fbdcfe141853f7e2c84c4d401f6a8758")
    Call<ResponseBody> getMultiLayoutDatas();
}
