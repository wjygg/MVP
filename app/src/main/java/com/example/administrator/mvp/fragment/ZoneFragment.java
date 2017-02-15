package com.example.administrator.mvp.fragment;

import android.content.Intent;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.activity.SomeDramaActivity;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.ZoneFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.ZoneFragmentPresenterListener;

import butterknife.OnClick;

/**
 * Created by wangjingyun on 2017/1/30.
 *
 *
 */

public class ZoneFragment extends BaseFragment<ZoneFragmentPresenterListener,ZoneFragmentPresenter> implements ZoneFragmentPresenterListener {


    public static ZoneFragment getInstance(){

        ZoneFragment fragment=new ZoneFragment();

        return  fragment;

    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_my;
    }

    @Override
    public ZoneFragmentPresenter initPresenter() {
        return new ZoneFragmentPresenter();
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void initEvent() {


    }


    @OnClick(R.id.rl_Somedrama)
    void startSomeDramaActivity(){

        startActivity(new Intent(getActivity(),SomeDramaActivity.class));
    }

}
