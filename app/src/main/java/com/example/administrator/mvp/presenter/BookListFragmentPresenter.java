package com.example.administrator.mvp.presenter;


import com.example.administrator.mvp.base.BasePresenter;
import com.example.administrator.mvp.model.BookListModelListener;
import com.example.administrator.mvp.model.CompleteListener;
import com.example.administrator.mvp.model.impl.BookListModelImpl;
import com.example.administrator.mvp.presenter.listener.BookListFragmentPresenterListener;

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
        //model层网络请求
        bookListModelListener.getBookList(q,tag,start,count,fields,this);

    }

    //请求成功
    @Override
    public void onSuccess(String objects) {
        //回调通知activity 请求的结果
        view.getData(objects);

    }

    //请求失败
    @Override
    public void onFaild(String str) {
      //回调通知activity 请求的结果
        view.onError(str);
    }
}
