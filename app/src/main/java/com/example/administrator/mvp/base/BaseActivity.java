package com.example.administrator.mvp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 *
 * @param <T>
 * @param <V>
 */
public abstract class BaseActivity<T,V extends BasePresenter<T>> extends AppCompatActivity {

    public V presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityId());
        //view初始化自己的presenter
        presenter=initPresenter();
        //view与presenter 绑定
        presenter.attach((T)this);
        //抛出presenter子类调用里面的方法
        getPresenter(presenter);
        //初始化控件  可以使用注解方式find控件
        initView();
        //初始化數據
        initDatas();
        //初始化事件
        initEvent();
    }

    @Override
    protected void onDestroy() {


        presenter.dettach();
        super.onDestroy();
    }

    public abstract void getPresenter(V presenter);

    public abstract int getActivityId();

    public abstract V initPresenter();

    public abstract void initView();

    public abstract void initDatas();

    public abstract void initEvent();
}
