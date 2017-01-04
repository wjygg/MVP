package com.example.administrator.mvp.model;

/**
 * Created by Administrator on 2016/12/7.
 */

public interface CompleteListener {
    //刷新请求成功
    void onRefreshSuccess(String objects);
    //上拉请求成功
    void onLoadSuccess(String objects);
    //请求失败
    void onFaild(String str);
}
