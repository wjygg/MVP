package com.example.administrator.mvp.presenter.listener;

import com.example.administrator.mvp.entity.MultiLayoutEntitiy;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface MultiLayoutfragmentPresenterListener {


    void  getOnRefreshDatas(MultiLayoutEntitiy multiLayoutEntitiy);

    void OnError(String error);

    void showProcess();

    void hideProess();


}
