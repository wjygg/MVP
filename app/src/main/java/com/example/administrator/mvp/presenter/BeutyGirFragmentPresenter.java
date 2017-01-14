package com.example.administrator.mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.example.administrator.mvp.base.BasePresenter;
import com.example.administrator.mvp.entity.BeautyGirInfo;
import com.example.administrator.mvp.model.BeautyGirModelListener;
import com.example.administrator.mvp.model.CompleteListener;
import com.example.administrator.mvp.model.impl.BeautyGirModelImpl;
import com.example.administrator.mvp.presenter.listener.BeautyGirFragmentPresenterListener;

/**
 * Created by Administrator on 2016/11/27.
 */

public class BeutyGirFragmentPresenter extends BasePresenter<BeautyGirFragmentPresenterListener> implements CompleteListener{

    private BeautyGirModelListener beautyGirModelListener;
    @Override
    public void attach(BeautyGirFragmentPresenterListener view) {
        super.attach(view);
        //妹子persion层 和 妹子model层绑定
        beautyGirModelListener=new BeautyGirModelImpl();
    }

    public void getRefreshBeautyGirDate(int count,int page){

        view.showProgress();
        //下拉刷新数据
        beautyGirModelListener.getRefreshBeautyGir(count,page,this);

    }

    public void getLoadBeautyGirData(int count ,int page){
        view.showProgress();
        //上拉加载数据
        beautyGirModelListener.getLoadBeautyGir(count,page,this);

    }

    @Override
    public void onRefreshSuccess(String objects) {

        BeautyGirInfo beautyGirInfo=JSON.parseObject(objects, BeautyGirInfo.class);
        view.onRefresh(beautyGirInfo.getResults());
        view.hideProgress();

    }

    @Override
    public void onLoadSuccess(String objects) {
        BeautyGirInfo beautyGirInfo=JSON.parseObject(objects, BeautyGirInfo.class);
        view.onLoad(beautyGirInfo.getResults());
        view.hideProgress();
    }

    @Override
    public void onFaild(String str) {

        view.onFild(str);
    }
}
