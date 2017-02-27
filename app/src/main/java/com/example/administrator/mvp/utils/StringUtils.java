package com.example.administrator.mvp.utils;

import android.content.Context;

/**
 * Created by Administrator on 2017/2/27.
 */

public class StringUtils {

    public static String getText(Context context,int message){


        return context.getResources().getString(message);

    }
}
