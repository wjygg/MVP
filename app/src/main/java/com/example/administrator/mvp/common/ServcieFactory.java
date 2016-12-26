package com.example.administrator.mvp.common;

import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**这个类是 okhttp3+Retrofit 网络请求 工具类
 * Created by wangjingyun on 2016/12/8.
 *
 */

public class ServcieFactory {

    private static OkHttpClient okHttpClient;

    private static Retrofit retrofit;
    //返回一个okhttpclient对象

    public static OkHttpClient getOkHttpClient(){
        if(okHttpClient==null){
            synchronized (OkHttpClient.class){

                if(okHttpClient==null){
                    //缓存文件报错 空指针没修改 暂时隐藏
                   //   http://mushuichuan.com/2016/03/01/okhttpcache/   okhttp设置缓存
                   File cacheFile=new File(Environment.getExternalStorageDirectory(),"carch");
                   Cache cache=new Cache(cacheFile,1024*1024*20);
                    okHttpClient=new OkHttpClient.Builder()
                            //这里添加 拦截器
                            .addNetworkInterceptor(new CacheInterceptor())
                            .cache(cache)
                            .connectTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
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
                            //.addCallAdapterFactory()
                            .build();
                }
            }
        }

        return retrofit;
    }

    public static <T> T createService(String baseUrl, Class<T> serviceClazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                //暂时不添加 rxjava
               // .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClazz);
    }

//不支持缓存的 服务器增加缓存
    public static class  CacheInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            Response response = chain.proceed(request);
            Response response1 = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for 30 days
                    .header("Cache-Control", "max-age=" + 3600 * 24 * 30)
                    .build();
            return response1;
        }
    }




}
