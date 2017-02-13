package com.example.administrator.mvp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.MultiLayoutFragmentAdapter;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.entity.MultiLayoutEntitiy;
import com.example.administrator.mvp.presenter.MultiLayoutFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.MultiLayoutfragmentPresenterListener;

import butterknife.InjectView;

/**
 * Created by Administrator on 2016/11/27.
 * 多布局fragment
 *
 */

public class MultiLayoutFragment extends BaseFragment<MultiLayoutfragmentPresenterListener,MultiLayoutFragmentPresenter> implements MultiLayoutfragmentPresenterListener {

    @InjectView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @InjectView(R.id.recycleview)
    RecyclerView recyclerView;


    public static MultiLayoutFragment getInstance(){

        return new MultiLayoutFragment();
    }
    @Override
    public int getContentViewId() {
        return R.layout.fragment_booksearch;
    }

    @Override
    public MultiLayoutFragmentPresenter initPresenter() {
        return new MultiLayoutFragmentPresenter();
    }

    @Override
    public void initDatas() {

        //请求网络数据

        presenter.getMultiLayoutDatas();

    }


    @Override
    public void initEvent() {
        //设置刷新 为 橘黄色
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.orange));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                presenter.getMultiLayoutDatas();

            }
        });
    }


    @Override
    public void getOnRefreshDatas(MultiLayoutEntitiy multiLayoutEntitiy) {

        swipeRefreshLayout.setRefreshing(false);
        //设置adapter
       final  MultiLayoutFragmentAdapter adapter=new MultiLayoutFragmentAdapter(multiLayoutEntitiy,getActivity());


        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {



                return adapter.getSpanSize(position);
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnError(String error) {

        Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProcess() {

        Toast.makeText(getActivity(),"数据请求中",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProess() {

        Toast.makeText(getActivity(),"数据请求完毕",Toast.LENGTH_SHORT).show();
    }
}
