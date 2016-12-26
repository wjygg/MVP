package com.example.administrator.mvp.utils;

import android.content.Context;
import android.os.Environment;

import com.example.administrator.mvp.MvpApplication;

import java.io.File;

/**
 * Created by Administrator on 2016/11/29.
 */

public class ApplicationUtil {


    public static Context getContext(){

        return MvpApplication.getApplication();
    }


}
