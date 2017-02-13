package com.example.administrator.mvp.fragment;

import android.widget.ExpandableListView;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.ExpandableListAdapter;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.entity.ExpandableListViewDetailEntity;
import com.example.administrator.mvp.entity.ExpandableListViewEntity;
import com.example.administrator.mvp.presenter.MyFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.MyFragmentPresenterListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import butterknife.InjectView;

/**
 * Created by wangjingyun on 2017/1/30.
 */

public class MyFragment extends BaseFragment<MyFragmentPresenterListener,MyFragmentPresenter> implements MyFragmentPresenterListener{

    @InjectView(R.id.exlistview)
    ExpandableListView expandableListView;

    private List<ExpandableListViewEntity> datas=new ArrayList<ExpandableListViewEntity>();


    public static MyFragment getInstance(){

        MyFragment fragment=new MyFragment();

        return  fragment;

    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_my;
    }

    @Override
    public MyFragmentPresenter initPresenter() {
        return new MyFragmentPresenter();
    }

    @Override
    public void initDatas() {
        Map<String,Boolean> map=new HashMap<String,Boolean>();
        for(int i=1;i<=5;i++){
            ExpandableListViewEntity expandableListViewEntity=new ExpandableListViewEntity();
            expandableListViewEntity.setTitle("测试"+i);
            expandableListViewEntity.setId(i+"");
            map.put(i+"",false);
            List<ExpandableListViewDetailEntity> str=new ArrayList<ExpandableListViewDetailEntity>();

            for(int j=0;j<=5;j++){
                ExpandableListViewDetailEntity expandableListViewDetailEntity=new ExpandableListViewDetailEntity();
                String uuid=UUID.randomUUID().toString();
                expandableListViewDetailEntity.setId(uuid);
                expandableListViewDetailEntity.setName("测试内容"+j);
                map.put(uuid,false);
                str.add(expandableListViewDetailEntity);
            }

            expandableListViewEntity.setDatas(str);

            datas.add(expandableListViewEntity);
        }

        expandableListView.setAdapter(new ExpandableListAdapter(getActivity(),datas,map));

        for(int s=0;s<datas.size();s++){
            expandableListView.expandGroup(s);

        }
    }

    @Override
    public void initEvent() {


    }
}
