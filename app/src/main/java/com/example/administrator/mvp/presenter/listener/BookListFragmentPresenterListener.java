package com.example.administrator.mvp.presenter.listener;

import com.example.administrator.mvp.entity.BookInfoEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface BookListFragmentPresenterListener {

    void onRefresh(List<BookInfoEntity> bookInfoEntity);

    void onLoad(List<BookInfoEntity> bookInfoEntity);

    void onFild(String fild);

    void showProgress();

    void hideProgress();
}
