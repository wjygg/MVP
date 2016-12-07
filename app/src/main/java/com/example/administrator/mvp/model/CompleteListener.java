package com.example.administrator.mvp.model;

/**
 * Created by Administrator on 2016/12/7.
 */

public interface CompleteListener {
    //请求成功
    void onSuccess(String objects);
    //请求失败
    void onFaild(String str);
}
