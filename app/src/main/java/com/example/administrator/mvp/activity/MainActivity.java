package com.example.administrator.mvp.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.MainFragmentPageAdapter;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.fragment.BookClassiFicationFragment;
import com.example.administrator.mvp.fragment.BookListFragment;
import com.example.administrator.mvp.fragment.BookSearchFragment;
import com.example.administrator.mvp.presenter.MainActivityPresenter;
import com.example.administrator.mvp.presenter.listener.MainActivityPresenterListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

public class MainActivity extends BaseActivity<MainActivityPresenterListener, MainActivityPresenter> implements MainActivityPresenterListener {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.tablayout)
    TabLayout tablayout;

    @InjectView(R.id.viewpager)
    ViewPager viewpager;

    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private MainFragmentPageAdapter pageAdapter;

    @Override
    public int getActivityId() {
        return R.layout.activity_main;
    }

    @Override
    public MainActivityPresenter initPresenter() {
        return new MainActivityPresenter();
    }

    @Override
    public void initDatas() {
        //设置toolbar
        toolbar.setTitle("我的简易书城");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        this.setSupportActionBar(toolbar);

        //添加fragment
        fragmentList.add(BookListFragment.getInstance("新书"));
        fragmentList.add(BookClassiFicationFragment.getInstance());
        fragmentList.add(BookSearchFragment.getInstance());
        pageAdapter = new MainFragmentPageAdapter(fragmentList, getSupportFragmentManager());
        viewpager.setAdapter(pageAdapter);
        //tablayout 和viewpager关联
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setText("新书");
        tablayout.getTabAt(1).setText("分类");
        tablayout.getTabAt(2).setText("搜索");
    }

    @Override
    public void initEvent() {



    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
