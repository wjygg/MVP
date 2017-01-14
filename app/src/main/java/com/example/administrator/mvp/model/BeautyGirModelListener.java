package com.example.administrator.mvp.model;

/**
 * Created by Administrator on 2017/1/14.
 */

public interface BeautyGirModelListener {
    //获取刷新的妹子

    void getRefreshBeautyGir(int count,int page,CompleteListener listener);

    //获取上啦的妹子

    void getLoadBeautyGir(int count,int page,CompleteListener listener);

}
