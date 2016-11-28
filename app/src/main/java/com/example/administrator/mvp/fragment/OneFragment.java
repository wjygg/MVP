package com.example.administrator.mvp.fragment;

import android.view.View;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.OneFragmentPresenter;

/**
 * Created by wangjingyun on 2016/11/23.
 */

public class OneFragment extends BaseFragment<OneFragmentPresenter.IFrag,OneFragmentPresenter> implements OneFragmentPresenter.IFrag{


    public static OneFragment getInstance(){

        return new OneFragment();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_one;
    }

    @Override
    public OneFragmentPresenter initPresenter() {
        return new OneFragmentPresenter();
    }

    @Override
    public void getPresenter(OneFragmentPresenter presenter) {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initEvent() {

    }
}
