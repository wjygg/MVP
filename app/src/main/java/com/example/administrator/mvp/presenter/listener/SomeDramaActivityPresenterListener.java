package com.example.administrator.mvp.presenter.listener;

import com.example.administrator.mvp.entity.SomeDramaEntity;

/**
 * Created by Administrator on 2017/2/15.
 */

public interface SomeDramaActivityPresenterListener  {

    void onRefresh( SomeDramaEntity someDramaEntity);

    void onFild(String fild);

    void showProgress();

    void hideProgress();


}
