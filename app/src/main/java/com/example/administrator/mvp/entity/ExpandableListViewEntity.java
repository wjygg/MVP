package com.example.administrator.mvp.entity;

import java.util.List;

/**
 * Created by wangjingyun on 2017/1/30.
 */

public class ExpandableListViewEntity {


    private String id;

    private String title;

    private List<ExpandableListViewDetailEntity> datas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ExpandableListViewDetailEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<ExpandableListViewDetailEntity> datas) {
        this.datas = datas;
    }


}
