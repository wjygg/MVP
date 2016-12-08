package com.example.administrator.mvp.fragment;

import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.BookClassiFicationFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.BookClassiFicationFragmentPresenterListener;

/**
 * Created by Administrator on 2016/11/27.
 * 书本分类fragment
 */

public class BookClassiFicationFragment extends BaseFragment<BookClassiFicationFragmentPresenterListener,BookClassiFicationFragmentPresenter> implements BookClassiFicationFragmentPresenterListener {

    public static BookClassiFicationFragment getInstance(){

        return new BookClassiFicationFragment();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_bookclassification;
    }

    @Override
    public BookClassiFicationFragmentPresenter initPresenter() {

        return new BookClassiFicationFragmentPresenter();
    }

    @Override
    public void initDatas() {

        Toast.makeText(getActivity(),"缓加载第二个页面",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initEvent() {

    }
}