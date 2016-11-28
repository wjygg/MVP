package com.example.administrator.mvp.presenter;


import com.example.administrator.mvp.base.BasePresenter;

/**
 * Created by wangjingyun on 2016/11/23.
 */

public class OneFragmentPresenter extends BasePresenter<OneFragmentPresenter.IFrag>{

    @Override
    public void attach(IFrag view) {
        super.attach(view);
    }

    public interface IFrag{}
}
