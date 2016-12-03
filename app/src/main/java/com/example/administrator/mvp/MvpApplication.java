package com.example.administrator.mvp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wangjingyun on 2016/11/22.
 */

public class MvpApplication extends Application {

    public static final String TAG = "MvpApplication";
    //主线程的id
    private static int mainTd;
    //Activity的集合
    private static List<Activity>  activitys;

    private static MvpApplication application;

    @Override
    public void onCreate() {

        super.onCreate();

        activitys=new LinkedList<Activity>();

        application=this;
        //主线程id
        mainTd=android.os.Process.myTid();

    }

    //返回application
    public static Context getApplication(){

        return application;
    }

    //添加activity
    public static void setActivitys(Activity activity){

        activitys.add(activity);
    }

    //删除activity

    public  static void removeActivity(Activity activity){

            activitys.remove(activity);
    }

    //退出activity

    public static void exitActivity(){

        ListIterator<Activity> iterator=activitys.listIterator();

        Activity activity;
        while(iterator.hasNext()){

            activity=iterator.next();

            if(activity!=null){

                activity.finish();
            }

        }
    }

    public static void exitApplication(){

        exitActivity();

        System.exit(0);

    }



}
