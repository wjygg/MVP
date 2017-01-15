package com.example.administrator.mvp.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewAdapter;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewViewHolder;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.entity.BookInfoEntity;
import com.example.administrator.mvp.presenter.BookListFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.BookListFragmentPresenterListener;
import com.example.administrator.mvp.utils.RecycleViewUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by wangjingyun on 2016/11/23.
 * 书本列表fragment
 */

public class BookListFragment extends BaseFragment<BookListFragmentPresenterListener,BookListFragmentPresenter> implements BookListFragmentPresenterListener {

    @InjectView(R.id.recycleview)
    RecyclerView recycleview;

    @InjectView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private List<BookInfoEntity> datas=new ArrayList<BookInfoEntity>();

    private RecycleViewAdapter<BookInfoEntity> adapter;

    private int page=0;

    private String tag;
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
        tag=bundle.getString("tag");


        swipeRefreshLayout.setRefreshing(true);
        //调用请求网络接口
        presenter.getBookList(null,tag,0,10,fields);

    }
    @Override
    public void initEvent() {

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                //调用请求网络接口
                presenter.getBookList(null,tag,0,10,fields);

            }
        });
        //recycleview 滚动监听
        recycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //判断recycleview滚动到低端
                if(RecycleViewUtil.isSlideToBottom(recycleview)){

                    swipeRefreshLayout.setRefreshing(true);
                    //上拉加载
                    presenter.getLoadBookList(null,tag,page*10,10,fields);

                }

            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.orange));
        adapter=new RecycleViewAdapter<BookInfoEntity>(getActivity(),datas) {
            @Override
            public void convert(RecycleViewViewHolder holder, BookInfoEntity datas) {

                holder.setImgView(R.id.iv_book_img,datas.getImages().getLarge());
                holder.setText(R.id.tv_book_title,datas.getTitle());
                holder.setText(R.id.tv_book_info,datas.getInfoString());
                holder.setText(R.id.tv_book_description,datas.getSummary());
            }
            @Override
            public int convertItemViewType(int position) {

                return R.layout.item_fragmentlist;
            }
            @Override
            public int getlayoutId(int viewType) {
                //返回单个 布局
                return R.layout.item_fragmentlist;
            }
        };

        recycleview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recycleview.setLayoutManager(linearLayoutManager);
     //   recycleview.addItemDecoration(new RecycyleViewDivider(getActivity(),10));
    }
    @Override
    public void onRefresh(List<BookInfoEntity> bookInfoEntity) {
        page=2;
        adapter.initDatas(bookInfoEntity);
        swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onLoad(List<BookInfoEntity> bookInfoEntity) {
        page++;
        adapter.addDatas(bookInfoEntity);

        swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onFild(String fild) {

        Toast.makeText(getActivity(),fild,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        Toast.makeText(getActivity(),"开始加载数据",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        Toast.makeText(getActivity(),"数据加载完毕",Toast.LENGTH_SHORT).show();
    }


}
