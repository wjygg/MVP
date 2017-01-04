package com.example.administrator.mvp.presenter;


import com.alibaba.fastjson.JSON;
import com.example.administrator.mvp.base.BasePresenter;
import com.example.administrator.mvp.entity.BookInfoEntity;
import com.example.administrator.mvp.entity.BookListEntity;
import com.example.administrator.mvp.model.BookListModelListener;
import com.example.administrator.mvp.model.CompleteListener;
import com.example.administrator.mvp.model.impl.BookListModelImpl;
import com.example.administrator.mvp.presenter.listener.BookListFragmentPresenterListener;

import java.util.List;

/**
 * Created by wangjingyun on 2016/11/23.
 */

public class BookListFragmentPresenter extends BasePresenter<BookListFragmentPresenterListener> implements CompleteListener{
private BookListModelListener bookListModelListener;

    @Override
    public void attach(BookListFragmentPresenterListener view) {
        super.attach(view);
        //书本的presenter层和书本的model层连接 model只做网络请求
        bookListModelListener=new BookListModelImpl();


    }

    public void getBookList(String q,String tag,int start,int count, String fields){

        view.showProgress();
        //model层网络请求
        bookListModelListener.getRefreshBookList(q,tag,start,count,fields,this);

    }

    public void getLoadBookList(String q,String tag,int start,int count, String fields){

        view.showProgress();

        bookListModelListener.getLoadBookList(q,tag,start,count,fields,this);

    }


    @Override
    public void onRefreshSuccess(String objects) {

        BookListEntity bookListEntity=JSON.parseObject(objects, BookListEntity.class);

        List<BookInfoEntity> bookInfoEntity= bookListEntity.getBooks();
        //回调通知activity 请求的结果

        view.onRefresh(bookInfoEntity);

        view.hideProgress();
    }

    @Override
    public void onLoadSuccess(String objects) {

        BookListEntity bookListEntity=JSON.parseObject(objects, BookListEntity.class);

        List<BookInfoEntity> bookInfoEntity= bookListEntity.getBooks();

        //回调通知activity 请求的结果
        view.onLoad(bookInfoEntity);

        view.hideProgress();
    }

    //请求失败
    @Override
    public void onFaild(String objects) {

        view.onFild(objects);
    }
}
