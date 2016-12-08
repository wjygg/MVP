package com.example.administrator.mvp.common;

import com.example.administrator.mvp.MvpApplication;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**这个类是 okhttp3+Retrofit 网络请求 工具类
 * Created by wangjingyun on 2016/12/8.
 */

public class ServcieFactory {

    private static OkHttpClient okHttpClient;

    private static Retrofit retrofit;
    //返回一个okhttpclient对象

    public static OkHttpClient getOkHttpClient(){
        if(okHttpClient==null){
            synchronized (OkHttpClient.class){

                if(okHttpClient==null){
                    File cacheFile=new File(MvpApplication.getApplication().getCacheDir(),"carch");
                    Cache cache=new Cache(cacheFile,1024*1024*20);
                    okHttpClient=new OkHttpClient.Builder()
                            .cache(cache)
                            //这里添加 拦截器做缓存处理
                            .build();
                }
            }
        }
        return okHttpClient;
    }

    public static Retrofit getRetrofit(String baseurl){

        if(retrofit==null){
            synchronized (Retrofit.class){

                if(retrofit==null){
                    retrofit=new Retrofit.Builder()
                            .client(getOkHttpClient())
                            .baseUrl(baseurl)
                            .addConverterFactory(GsonConverterFactory.create())
                            //这里添加 rxiava
                            .build();
                }
            }
        }

        return retrofit;
    }




}
