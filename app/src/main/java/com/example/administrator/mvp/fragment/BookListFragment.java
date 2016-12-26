package com.example.administrator.mvp.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewAdapter;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewViewHolder;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.presenter.BookListFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.BookListFragmentPresenterListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by wangjingyun on 2016/11/23.
 * 书本列表fragment
 */

public class BookListFragment extends BaseFragment<BookListFragmentPresenterListener,BookListFragmentPresenter> implements BookListFragmentPresenterListener,SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.recycleview)
    RecyclerView recycleview;

    @InjectView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private List<String> datas=new ArrayList<String>();
    private RecycleViewAdapter<String> adapter;
    private static final String fields = "id,title,subtitle,origin_title,rating,author,translator,publisher,pubdate,summary,images,pages,price,binding,isbn13,series";
    public static BookListFragment getInstance(String tag){
        BookListFragment fragment=new BookListFragment();
        Bundle bundle=new Bundle();
        bundle.putString("tag",tag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_boklist;
    }

    @Override
    public BookListFragmentPresenter initPresenter() {
        return new BookListFragmentPresenter();
    }

    @Override
    public void initDatas() {
        Bundle bundle=getArguments();
        String tag=bundle.getString("tag");

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.orange));
        swipeRefreshLayout.setRefreshing(true);
        //调用请求网络接口
        presenter.getBookList(null,tag,0,10,fields);

    }
    @Override
    public void initEvent() {


    }
    @Override
    public void onReresh(String str) {
        Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();

        for(int i=1;i<=20;i++){

            datas.add(i+"");
        }
       adapter=new RecycleViewAdapter<String>(getActivity(),R.layout.item_fragmentlist,datas) {
           @Override
           public void convert(RecycleViewViewHolder holder, String datas) {
               TextView text=holder.getView(R.id.tv_num);
               text.setText(datas);
           }
       };
        recycleview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recycleview.setLayoutManager(linearLayoutManager);

        swipeRefreshLayout.setRefreshing(false);
       // recycleview.addItemDecoration(new DividerI);
    }

    @Override
    public void onLoad(String str) {
        Toast.makeText(getActivity(),str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        Toast.makeText(getActivity(),"开始加载数据",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        Toast.makeText(getActivity(),"数据加载完毕",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
    }
}
