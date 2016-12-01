package com.example.administrator.mvp.fragment;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.BookListFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.BookListFragmentPresenterListener;

/**
 * Created by wangjingyun on 2016/11/23.
 * 书本列表fragment
 */

public class BookListFragment extends BaseFragment<BookListFragmentPresenterListener,BookListFragmentPresenter> implements BookListFragmentPresenterListener {


    public static BookListFragment getInstance(){

        return new BookListFragment();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_one;
    }

    @Override
    public BookListFragmentPresenter initPresenter() {
        return new BookListFragmentPresenter();
    }

    @Override
    public void initDatas() {

    }
    @Override
    public void initEvent() {

    }
}
