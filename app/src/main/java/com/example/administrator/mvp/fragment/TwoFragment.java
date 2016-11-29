package com.example.administrator.mvp.fragment;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.TwoFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.TwoFragmentPresenterListener;

/**
 * Created by Administrator on 2016/11/27.
 */

public class TwoFragment extends BaseFragment<TwoFragmentPresenterListener,TwoFragmentPresenter> implements TwoFragmentPresenterListener{

    public static TwoFragment getInstance(){

        return new TwoFragment();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_two;
    }

    @Override
    public TwoFragmentPresenter initPresenter() {

        return new TwoFragmentPresenter();
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void initEvent() {

    }
}
