package com.example.administrator.mvp.utils;

import android.content.Context;

import com.example.administrator.mvp.MvpApplication;

/**
 * Created by Administrator on 2016/11/29.
 */

public class ApplicationUtil {


    public static Context getContext(){

        return MvpApplication.getApplication();
    }
}
