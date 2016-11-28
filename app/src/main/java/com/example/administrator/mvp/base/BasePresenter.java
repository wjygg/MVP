package com.example.administrator.mvp.base;

/**
 * Created by wangjingyun on 2016/11/22.
 * p层基类
 */

public abstract  class BasePresenter<T> {


    public T view;

    //建立关联
    public void attach( T view){

        this.view=view;
    }

    //解除关联
    public void dettach(){

        if(view!=null){

            view=null;
        }
    }


}
