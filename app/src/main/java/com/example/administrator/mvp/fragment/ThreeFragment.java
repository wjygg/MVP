package com.example.administrator.mvp.fragment;

import android.view.View;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.ThreeFragmentPresenter;

/**
 * Created by Administrator on 2016/11/27.
 */

public class ThreeFragment extends BaseFragment<ThreeFragmentPresenter.Three,ThreeFragmentPresenter> implements ThreeFragmentPresenter.Three{

    public static ThreeFragment getInstance(){

        return new ThreeFragment();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_three;
    }

    @Override
    public ThreeFragmentPresenter initPresenter() {
        return new ThreeFragmentPresenter();
    }

    @Override
    public void getPresenter(ThreeFragmentPresenter presenter) {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initEvent() {

    }
}
