package com.example.administrator.mvp.fragment;

import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.BookSearchFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.BookSearchfragmentPresenterListener;

/**
 * Created by Administrator on 2016/11/27.
 * 书本搜索fragment
 *
 */

public class BookSearchFragment extends BaseFragment<BookSearchfragmentPresenterListener,BookSearchFragmentPresenter> implements BookSearchfragmentPresenterListener {

    public static BookSearchFragment getInstance(){

        return new BookSearchFragment();
    }
    @Override
    public int getContentViewId() {
        return R.layout.fragment_booksearch;
    }

    @Override
    public BookSearchFragmentPresenter initPresenter() {
        return new BookSearchFragmentPresenter();
    }

    @Override
    public void initDatas() {

        Toast.makeText(getActivity(),"缓加载第三个页面",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void initEvent() {

    }
}
