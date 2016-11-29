package com.example.administrator.mvp.fragment;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.OneFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.OneFragmentPresenterListener;

/**
 * Created by wangjingyun on 2016/11/23.
 */

public class OneFragment extends BaseFragment<OneFragmentPresenterListener,OneFragmentPresenter> implements OneFragmentPresenterListener {


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
    public void initDatas() {

    }
    @Override
    public void initEvent() {

    }
}
