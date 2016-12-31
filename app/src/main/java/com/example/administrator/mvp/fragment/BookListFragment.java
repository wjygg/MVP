package com.example.administrator.mvp.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
       adapter=new RecycleViewAdapter<String>(getActivity(),datas,datas.size()+2) {
           @Override
           public void convert(RecycleViewViewHolder holder, int position) {

               if(R.layout.item_fragmenthead==getItemViewType(position)){
                   TextView head=holder.getView(R.id.tv_head);
                   head.setText("我是头布局");
                   head.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Snackbar.make(v,"我是头布局",Snackbar.LENGTH_SHORT).show();
                       }
                   });
               }else if(R.layout.item_fragmenttail==getItemViewType(position)){
                   TextView head=holder.getView(R.id.tv_tail);
                   head.setText("我是尾布局");
               }else if(R.layout.item_fragmentlist==getItemViewType(position)){
                   TextView text=holder.getView(R.id.tv_num);
                   text.setText(datas.get(position-1));
               }
           }
           @Override
           public int convertItemViewType(int position) {
               //position==0时返回头布局
               if(position==0){

                   return R.layout.item_fragmenthead;
               }
               if(position==datas.size()+1){

                   return R.layout.item_fragmenttail;
               }

               return R.layout.item_fragmentlist;
           }
           @Override
           public int getlayoutId(int viewType) {
               //根据返回的viewtype返回布局id
               if(viewType==R.layout.item_fragmenthead){

                  return R.layout.item_fragmenthead;

               }else if(viewType==R.layout.item_fragmenttail){

                   return R.layout.item_fragmenttail;
               }
               return R.layout.item_fragmentlist;
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
