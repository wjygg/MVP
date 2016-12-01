package com.example.administrator.mvp.presenter;


import com.example.administrator.mvp.base.BasePresenter;
import com.example.administrator.mvp.presenter.listener.BookListFragmentPresenterListener;

/**
 * Created by wangjingyun on 2016/11/23.
 */

public class BookListFragmentPresenter extends BasePresenter<BookListFragmentPresenterListener>{

    @Override
    public void attach(BookListFragmentPresenterListener view) {
        super.attach(view);
    }

}
