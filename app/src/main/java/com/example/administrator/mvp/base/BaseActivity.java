package com.example.administrator.mvp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mvp.MvpApplication;

import butterknife.ButterKnife;

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
       //butterknife注解的使用  http://www.cnblogs.com/mengdd/p/4595973.html
        // 此项目中仅用于findviewbyid
        ButterKnife.inject(this);

        MvpApplication.setActivitys(this);

        //初始化數據
        initDatas();
        //初始化事件
        initEvent();
    }

    @Override
    protected void onDestroy() {
        presenter.dettach();
        super.onDestroy();
        MvpApplication.removeActivity(this);
    }
    public abstract int getActivityId();

    public abstract V initPresenter();

    public abstract void initDatas();

    public abstract void initEvent();
}
