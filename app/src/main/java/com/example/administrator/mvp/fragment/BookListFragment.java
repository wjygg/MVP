package com.example.administrator.mvp.fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.BookListFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.BookListFragmentPresenterListener;

/**
 * Created by wangjingyun on 2016/11/23.
 * 书本列表fragment
 */

public class BookListFragment extends BaseFragment<BookListFragmentPresenterListener,BookListFragmentPresenter> implements BookListFragmentPresenterListener {


    public static BookListFragment getInstance(String tag){
        BookListFragment fragment=new BookListFragment();
        Bundle bundle=new Bundle();
        bundle.putString("tag",tag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_boklist;
    }

    @Override
    public BookListFragmentPresenter initPresenter() {
        return new BookListFragmentPresenter();
    }

    @Override
    public void initDatas() {
        Bundle bundle=getArguments();
        String tag=bundle.getString("tag");
        Toast.makeText(getActivity(),"缓加载第一个页面",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void initEvent() {

    }
}
