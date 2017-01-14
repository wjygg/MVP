package com.example.administrator.mvp.model.impl;

import com.example.administrator.mvp.common.ServcieFactory;
import com.example.administrator.mvp.common.URL;
import com.example.administrator.mvp.common.service.BeautyGirService;
import com.example.administrator.mvp.model.BeautyGirModelListener;
import com.example.administrator.mvp.model.CompleteListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wangjingyun on 2017/1/14.
 */

public class BeautyGirModelImpl implements BeautyGirModelListener{


    @Override
    public void getRefreshBeautyGir(int count, int page,final  CompleteListener listener) {

        BeautyGirService service = ServcieFactory.createService(URL.BEAUTYGIRURL, BeautyGirService.class);
        Call<ResponseBody> beautyGir = service.getBeautyGir(count, page);

        beautyGir.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    listener.onRefreshSuccess(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                    listener.onFaild(e.getMessage().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
               listener.onFaild(t.getMessage().toString());
            }
        });
    }

    @Override
    public void getLoadBeautyGir(int count, int page, final CompleteListener listener) {

        BeautyGirService service = ServcieFactory.createService(URL.BEAUTYGIRURL, BeautyGirService.class);
        Call<ResponseBody> beautyGir = service.getBeautyGir(count, page);
        beautyGir.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    listener.onLoadSuccess(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                    listener.onFaild(e.getMessage().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onFaild(t.getMessage().toString());
            }
        });

    }
}
