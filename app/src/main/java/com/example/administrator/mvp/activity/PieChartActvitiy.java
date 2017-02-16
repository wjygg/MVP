package com.example.administrator.mvp.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.presenter.PieChartActvitiyPresenter;
import com.example.administrator.mvp.presenter.listener.PieChartActvitiyPresenterListener;

import butterknife.InjectView;

/**
 * 饼状图 activity
 * Created by wangjingyun on 2017/2/16.
 *
 */

public class PieChartActvitiy extends BaseActivity <PieChartActvitiyPresenterListener,PieChartActvitiyPresenter> implements PieChartActvitiyPresenterListener{

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

    }

    @Override
    public void initEvent() {

        toolbar.setTitle("绘制饼状图");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        //toolabar显示返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
