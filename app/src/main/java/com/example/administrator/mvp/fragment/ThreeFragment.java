package com.example.administrator.mvp.fragment;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.ThreeFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.ThreefragmentPresenterListener;

/**
 * Created by Administrator on 2016/11/27.
 */

public class ThreeFragment extends BaseFragment<ThreefragmentPresenterListener,ThreeFragmentPresenter> implements ThreefragmentPresenterListener{

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
    public void initDatas() {

    }


    @Override
    public void initEvent() {

    }
}
