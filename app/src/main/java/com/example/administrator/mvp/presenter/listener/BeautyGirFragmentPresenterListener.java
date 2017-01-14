package com.example.administrator.mvp.presenter.listener;

import com.example.administrator.mvp.entity.BeautyGirDetail;

import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface BeautyGirFragmentPresenterListener {

    void onRefresh(List<BeautyGirDetail> beautyGirDetails);

    void onLoad(List<BeautyGirDetail> beautyGirDetails);

    void onFild(String fild);

    void showProgress();

    void hideProgress();

}
