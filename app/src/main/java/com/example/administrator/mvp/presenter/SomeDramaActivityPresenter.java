package com.example.administrator.mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.example.administrator.mvp.base.BasePresenter;
import com.example.administrator.mvp.entity.SomeDramaEntity;
import com.example.administrator.mvp.model.CompleteListener;
import com.example.administrator.mvp.model.SomeDramaModelListener;
import com.example.administrator.mvp.model.impl.SomeDramaModelImpl;
import com.example.administrator.mvp.presenter.listener.SomeDramaActivityPresenterListener;

/**
 * Created by Administrator on 2017/2/15.
 * 番剧presenter
 */

public class SomeDramaActivityPresenter extends BasePresenter<SomeDramaActivityPresenterListener> implements CompleteListener{

    private SomeDramaModelListener someDramaModelListener;
    @Override
    public void attach(SomeDramaActivityPresenterListener view) {
        super.attach(view);
        //model与presenter 层绑定
        someDramaModelListener=new SomeDramaModelImpl();

    }

    public void getSomeDramaDatas(){

       view.showProgress();

        someDramaModelListener.getSomeDramaModelDatas(SomeDramaActivityPresenter.this);

    }


    @Override
    public void onRefreshSuccess(String objects) {

      //  System.out.println(objects);
        view.hideProgress();

        SomeDramaEntity someDramaEntity=JSON.parseObject(objects, SomeDramaEntity.class);

        view.onRefresh(someDramaEntity);
    }

    @Override
    public void onLoadSuccess(String objects) {

    }

    @Override
    public void onFaild(String str) {

      view.onFild(str);

    }
}
