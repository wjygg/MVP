package com.example.administrator.mvp.presenter;

import com.alibaba.fastjson.JSONObject;
import com.example.administrator.mvp.base.BasePresenter;
import com.example.administrator.mvp.entity.MultiLayoutEntitiy;
import com.example.administrator.mvp.model.CompleteListener;
import com.example.administrator.mvp.model.MultiLayoutModeListener;
import com.example.administrator.mvp.model.impl.MultiLayoutModeImpl;
import com.example.administrator.mvp.presenter.listener.MultiLayoutfragmentPresenterListener;

/**
 * Created by Administrator on 2016/11/27.
 */

public class MultiLayoutFragmentPresenter extends BasePresenter<MultiLayoutfragmentPresenterListener> implements CompleteListener{

    private MultiLayoutModeListener listener;
    @Override
    public void attach(MultiLayoutfragmentPresenterListener view) {
        super.attach(view);

        //p层 与model 层 绑定
        listener=new MultiLayoutModeImpl();

    }

    public void  getMultiLayoutDatas(){

        view.showProcess();

        listener.getMultiLayoutDatas(MultiLayoutFragmentPresenter.this);

    }

    @Override
    public void onRefreshSuccess(String objects) {

        view.hideProess();

        MultiLayoutEntitiy  multiLayoutEntitiy=JSONObject.parseObject(objects, MultiLayoutEntitiy.class);

        view.getOnRefreshDatas(multiLayoutEntitiy);
        //数据 请求成功
    }

    @Override
    public void onLoadSuccess(String objects) {

        //数据 请求成功
    }

    @Override
    public void onFaild(String str) {

        view.OnError(str);
        //失败
    }
}
