package com.example.administrator.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by wangjingyun on 2016/11/23.
 */

public abstract class BaseFragment<T,V extends BasePresenter<T>> extends Fragment{

    public V presenter;

    public boolean isVisible;

    public boolean isPrepared;

    public boolean isFirst=true;
     @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view=inflater.inflate(getContentViewId(),null);

        //初始化presenter
        presenter=initPresenter();
        //view与presenter绑定
        presenter.attach((T)this);

        ButterKnife.inject(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //activity创建完成 控件全部找到
        isPrepared=true;
        //初始化数据(一般指调用网络请求方法)
        lazyLoad();
        //初始化事件
        initEvent();
    }

    //这个方法用来缓加载首页的fragment http://www.cnblogs.com/xjx22/p/5424630.html
    //如果没有viewpager+fragment  单纯点击跳转fragment 就判断栈中有没有fragemnt 有的话显示show没有隐藏hide
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
       //视图可见
        if(getUserVisibleHint()){
            isVisible=true;
            lazyLoad();
        }else{
            isVisible=false;
        }

    }

    public void lazyLoad(){

        if(!isVisible||!isPrepared||!isFirst){
            return;
        }
        initDatas();
        isFirst=false;
    }

    public abstract int getContentViewId();

    public abstract  V initPresenter();

    public abstract void initDatas();

    public abstract void initEvent();


    @Override
    public void onDestroy() {

        presenter.dettach();
        super.onDestroy();
    }
}
