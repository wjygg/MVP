package com.example.administrator.mvp.presenter.listener;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface BookListFragmentPresenterListener {
    void onReresh(String str);

    void onLoad(String str);

    void showProgress();

    void hideProgress();
}
