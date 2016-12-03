package com.example.administrator.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */

public class MainFragmentPageAdapter extends FragmentPagerAdapter{
    private List<Fragment> datas;
    public MainFragmentPageAdapter(List<Fragment> datas, FragmentManager manager){
        super(manager);
        this.datas=datas;
    }

    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

}
