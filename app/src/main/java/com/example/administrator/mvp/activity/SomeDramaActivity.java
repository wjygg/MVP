package com.example.administrator.mvp.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.presenter.SomeDramaActivityPresenter;
import com.example.administrator.mvp.presenter.listener.SomeDramaActivityPresenterListener;

import butterknife.InjectView;

/**
 * Created by wangjingyun on 2017/2/15.
 * 番剧activity
 */

public class SomeDramaActivity extends BaseActivity<SomeDramaActivityPresenterListener,SomeDramaActivityPresenter>implements  SomeDramaActivityPresenterListener {

    @InjectView(R.id.recycleview)
    RecyclerView recyclerView;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public int getActivityId() {
        return R.layout.activity_somedrama;
    }

    @Override
    public SomeDramaActivityPresenter initPresenter() {
        return new SomeDramaActivityPresenter();
    }

    @Override
    public void initDatas() {
       //网络请求

    }

    @Override
    public void initEvent() {

        toolbar.setTitle("番剧");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        //toolabar显示返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //toolbar 返回按钮点击监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
