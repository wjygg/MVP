package com.example.administrator.mvp.model.impl;

import com.example.administrator.mvp.common.ServcieFactory;
import com.example.administrator.mvp.common.URL;
import com.example.administrator.mvp.common.service.MultiLayoutService;
import com.example.administrator.mvp.model.CompleteListener;
import com.example.administrator.mvp.model.MultiLayoutModeListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/12.
 *
 * 多布局 网络请求
 */

public class MultiLayoutModeImpl implements MultiLayoutModeListener{

   // 获取多布局网络请求
    @Override
    public void getMultiLayoutDatas(final CompleteListener listener) {

        MultiLayoutService service = ServcieFactory.createService(URL.MULTILAYOUT, MultiLayoutService.class);

        Call<ResponseBody> multiLayoutDatas = service.getMultiLayoutDatas();

        multiLayoutDatas.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    listener.onRefreshSuccess(response.body().string());
                } catch (IOException e) {
                    listener.onFaild(e.getMessage().toString());
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
