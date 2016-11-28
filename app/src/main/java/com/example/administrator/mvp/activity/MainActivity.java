package com.example.administrator.mvp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.MainFragmentPageAdapter;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.fragment.OneFragment;
import com.example.administrator.mvp.fragment.ThreeFragment;
import com.example.administrator.mvp.fragment.TwoFragment;
import com.example.administrator.mvp.presenter.MainActivityPresenter;
import com.example.administrator.mvp.presenter.MainActivityPresenter.IHome;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<IHome, MainActivityPresenter> implements IHome {

    private AutoLinearLayout ll_one;
    private AutoLinearLayout ll_two;
    private AutoLinearLayout ll_three;
    private ViewPager viewpager;
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
    public void getPresenter(MainActivityPresenter presenter) {

        //网络请求


    }

    @Override
    public void initView() {
        ll_one = (AutoLinearLayout) findViewById(R.id.ll_one);
        ll_two = (AutoLinearLayout) findViewById(R.id.ll_two);
        ll_three = (AutoLinearLayout) findViewById(R.id.ll_three);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    public void initDatas() {
        //添加fragment
        fragmentList.add(OneFragment.getInstance());
        fragmentList.add(TwoFragment.getInstance());
        fragmentList.add(ThreeFragment.getInstance());
        pageAdapter = new MainFragmentPageAdapter(fragmentList, getSupportFragmentManager());
        viewpager.setAdapter(pageAdapter);
    }

    @Override
    public void initEvent() {

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onSelect(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ll_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(0);
            }
        });
        ll_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(1);
            }
        });
        ll_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(2);
            }
        });
    }

    public void onSelect(int position) {

        switch (position) {
            //滑動第一頁
            case 0:

                break;
            //第二額
            case 1:
                viewpager.setCurrentItem(1);
                break;
            //第三個
            case 3:
                viewpager.setCurrentItem(2);
                break;


        }
    }

}
