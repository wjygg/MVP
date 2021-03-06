package com.example.administrator.mvp.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.MainFragmentPageAdapter;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.fragment.BeautyGirFragment;
import com.example.administrator.mvp.fragment.BookListFragment;
import com.example.administrator.mvp.fragment.MultiLayoutFragment;
import com.example.administrator.mvp.fragment.ZoneFragment;
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

    @InjectView(R.id.floatactionbutton)
    FloatingActionButton floatactionbutton;

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
        toolbar.setTitle("仿啊仿");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        this.setSupportActionBar(toolbar);

        //添加fragment
        fragmentList.add(BookListFragment.getInstance("新书"));
        fragmentList.add(BeautyGirFragment.getInstance());
        fragmentList.add(MultiLayoutFragment.getInstance());
        fragmentList.add(ZoneFragment.getInstance());

        pageAdapter = new MainFragmentPageAdapter(fragmentList, getSupportFragmentManager());
        viewpager.setAdapter(pageAdapter);
        //多缓存一个页面防止fragment 销毁
        viewpager.setOffscreenPageLimit(3);
        //tablayout 和viewpager关联
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setText("新书");
        tablayout.getTabAt(1).setText("美女");
        tablayout.getTabAt(2).setText("直播");
        tablayout.getTabAt(3).setText("我的");
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
