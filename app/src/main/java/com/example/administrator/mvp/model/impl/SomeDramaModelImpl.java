package com.example.administrator.mvp.model.impl;

import com.example.administrator.mvp.common.ServcieFactory;
import com.example.administrator.mvp.common.URL;
import com.example.administrator.mvp.common.service.SomeDramaService;
import com.example.administrator.mvp.model.CompleteListener;
import com.example.administrator.mvp.model.SomeDramaModelListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 番剧请求方法
 *
 * Created by wangjingyun on 2017/2/27.
 */

public class SomeDramaModelImpl implements SomeDramaModelListener{


    @Override
    public void getSomeDramaModelDatas(final CompleteListener listener) {

        SomeDramaService service = ServcieFactory.createService(URL.BANGUMI_BASE_URL, SomeDramaService.class);

        Call<ResponseBody> responseBodyCall = service.getsomeDramaService();
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {

                    listener.onRefreshSuccess(response.body().string());

                } catch (IOException e) {
                    e.printStackTrace();

                    listener.onFaild(e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                listener.onFaild(t.getMessage());
            }
        });
    }

}
