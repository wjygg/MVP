package com.example.administrator.mvp.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.presenter.SpiderPictureActivityPresenter;
import com.example.administrator.mvp.presenter.listener.SpiderPictureActivityPresenterListener;

import butterknife.InjectView;

/**
 * Created by wangjingyun on 2017/2/20.
 */

public class SpiderPictureActivity extends BaseActivity<SpiderPictureActivityPresenterListener,SpiderPictureActivityPresenter> implements SpiderPictureActivityPresenterListener{

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    public int getActivityId() {
        return R.layout.activity_spiderpicture;
    }

    @Override
    public SpiderPictureActivityPresenter initPresenter() {
        return new SpiderPictureActivityPresenter();
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
