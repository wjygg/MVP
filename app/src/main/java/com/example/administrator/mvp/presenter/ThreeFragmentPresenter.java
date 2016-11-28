package com.example.administrator.mvp.presenter;

import com.example.administrator.mvp.base.BasePresenter;

/**
 * Created by Administrator on 2016/11/27.
 */

public class ThreeFragmentPresenter extends BasePresenter<ThreeFragmentPresenter.Three>{

    @Override
    public void attach(Three view) {
        super.attach(view);
    }

    public interface Three{}
}
