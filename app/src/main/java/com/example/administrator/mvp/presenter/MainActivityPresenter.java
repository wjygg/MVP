package com.example.administrator.mvp.presenter;

import com.example.administrator.mvp.base.BasePresenter;

/**
 * Created by wangjingyun on 2016/11/22.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityPresenter.IHome>{

    //presenter与activity绑定


    @Override
    public void dettach() {
        super.dettach();
    }




    public interface IHome{}
}
