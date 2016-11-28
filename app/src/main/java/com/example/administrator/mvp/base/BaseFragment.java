package com.example.administrator.mvp.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangjingyun on 2016/11/23.
 */

public abstract class BaseFragment<T,V extends BasePresenter<T>> extends Fragment{


    public V presenter;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view=inflater.inflate(getContentViewId(),null);

        //初始化presenter
        presenter=initPresenter();
        //view与presenter绑定
        presenter.attach((T)this);
        //presenter抛给子类
        getPresenter(presenter);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        //初始化事件
        initEvent();
    }

    public abstract int getContentViewId();

    public abstract  V initPresenter();

    public abstract void  getPresenter(V presenter);

    public abstract void initView(View view);

    public abstract void initEvent();


    @Override
    public void onDestroy() {

        presenter.dettach();
        super.onDestroy();
    }
}
