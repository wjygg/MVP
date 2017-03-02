package com.example.administrator.mvp.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.SomeDramaBanner;
import com.example.administrator.mvp.adapter.SomeDrameList;
import com.example.administrator.mvp.adapter.SomeDrameLocalClass;
import com.example.administrator.mvp.adapter.SomeDrameNew;
import com.example.administrator.mvp.adapter.SomeDrameSerializing;
import com.example.administrator.mvp.adapter.section.SectionedRecyclerViewAdapter;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.entity.SomeDramaEntity;
import com.example.administrator.mvp.presenter.SomeDramaActivityPresenter;
import com.example.administrator.mvp.presenter.listener.SomeDramaActivityPresenterListener;
import com.example.administrator.mvp.utils.StringUtils;

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

    @InjectView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private SectionedRecyclerViewAdapter mSectionedRecyclerViewAdapter;
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

        presenter.getSomeDramaDatas();

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


        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.orange));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                presenter.getSomeDramaDatas();
            }
        });


    }

    @Override
    public void onRefresh( SomeDramaEntity someDramaEntity) {

        mSectionedRecyclerViewAdapter = new SectionedRecyclerViewAdapter();

        mSectionedRecyclerViewAdapter.addSection(new SomeDramaBanner(someDramaEntity.getResult().getAd().getHead()));

        mSectionedRecyclerViewAdapter.addSection(new SomeDrameLocalClass(SomeDramaActivity.this));

        mSectionedRecyclerViewAdapter.addSection(new SomeDrameSerializing(SomeDramaActivity.this,someDramaEntity.getResult().getSerializing()));

        mSectionedRecyclerViewAdapter.addSection(new SomeDrameNew(SomeDramaActivity.this,someDramaEntity.getResult().getPrevious().getSeason(),someDramaEntity.getResult().getPrevious().getList()));

        mSectionedRecyclerViewAdapter.addSection(new SomeDrameList(SomeDramaActivity.this,someDramaEntity.getResult().getSerializing()));
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(SomeDramaActivity.this, 3);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {

                switch (mSectionedRecyclerViewAdapter.getSectionItemViewType(position)) {
                    case SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER:
                        return 3;

                    default:
                        return 1;
                }
            }
        });
        recyclerView.setLayoutManager(mGridLayoutManager);
        recyclerView.setAdapter(mSectionedRecyclerViewAdapter);

    }

    @Override
    public void onFild(String fild) {

        Toast.makeText(SomeDramaActivity.this,fild,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
        Toast.makeText(SomeDramaActivity.this, StringUtils.getText(SomeDramaActivity.this,R.string.begin_datas),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void hideProgress() {

        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(SomeDramaActivity.this, StringUtils.getText(SomeDramaActivity.this,R.string.end_datas),Toast.LENGTH_SHORT).show();
    }


}
