package com.example.administrator.mvp.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.presenter.PieChartActvitiyPresenter;
import com.example.administrator.mvp.presenter.listener.PieChartActvitiyPresenterListener;

import butterknife.InjectView;

/**
 * Created by Administrator on 2017/2/20.
 */

public class PieChartActivity extends BaseActivity<PieChartActvitiyPresenterListener,PieChartActvitiyPresenter>implements PieChartActvitiyPresenterListener{

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    public int getActivityId() {

        return R.layout.activity_piechartactvitiy;
    }

    @Override
    public PieChartActvitiyPresenter initPresenter() {

        return new PieChartActvitiyPresenter();
    }

    @Override
    public void initDatas() {

        toolbar.setTitle(getIntent().getStringExtra("title"));

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        setSupportActionBar(toolbar);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initEvent() {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
