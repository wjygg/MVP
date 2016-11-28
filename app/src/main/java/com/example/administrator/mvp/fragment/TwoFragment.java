package com.example.administrator.mvp.fragment;

import android.view.View;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.TwoFragmentPresenter;

/**
 * Created by Administrator on 2016/11/27.
 */

public class TwoFragment extends BaseFragment<TwoFragmentPresenter.Two,TwoFragmentPresenter> implements TwoFragmentPresenter.Two{

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
    public void getPresenter(TwoFragmentPresenter presenter) {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initEvent() {

    }
}
