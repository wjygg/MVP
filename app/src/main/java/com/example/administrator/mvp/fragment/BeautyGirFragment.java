package com.example.administrator.mvp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewAdapter;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewViewHolder;
import com.example.administrator.mvp.base.BaseFragment;
import com.example.administrator.mvp.entity.BeautyGirDetail;
import com.example.administrator.mvp.presenter.BeutyGirFragmentPresenter;
import com.example.administrator.mvp.presenter.listener.BeautyGirFragmentPresenterListener;
import com.example.administrator.mvp.utils.RecycleViewUtil;
import com.example.administrator.mvp.widget.ScaleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by Administrator on 2016/11/27.
 * 书本分类fragment
 */

public class BeautyGirFragment extends BaseFragment<BeautyGirFragmentPresenterListener,BeutyGirFragmentPresenter> implements BeautyGirFragmentPresenterListener {

    @InjectView(R.id.recycleview)
    RecyclerView recycleview;

    @InjectView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private List<BeautyGirDetail> datas=new ArrayList<BeautyGirDetail>();
    private RecycleViewAdapter<BeautyGirDetail> adapter;
    private int count=10;
    private int page=2;
    public static BeautyGirFragment getInstance(){

        return new BeautyGirFragment();
    }

    @Override
    public int getContentViewId() {
        return R.layout.fragment_beautygir;
    }

    @Override
    public BeutyGirFragmentPresenter initPresenter() {

        return new BeutyGirFragmentPresenter();
    }

    @Override
    public void initDatas() {
     swipeRefreshLayout.setRefreshing(true);
       //请求美女的接口
     presenter.getRefreshBeautyGirDate(count,1);
    }

    @Override
    public void initEvent() {

      final  StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.orange));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                //请求美女的接口
                presenter.getRefreshBeautyGirDate(count,1);
            }
        });


        recycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                staggeredGridLayoutManager.invalidateSpanAssignments();

                if(RecycleViewUtil.isSlideToBottom(recyclerView)) {

                    presenter.getLoadBeautyGirData(count,page);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        adapter=new RecycleViewAdapter<BeautyGirDetail>(getActivity(),datas) {
            @Override
            public void convert(RecycleViewViewHolder holder, BeautyGirDetail datas) {


              final  ScaleImageView scaleImageView= holder.getView(R.id.iv_image);

               Glide.with(getActivity()).load(datas.getUrl()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.empty_book_img).error(R.drawable.empty_book_img).into(scaleImageView);
            }

            @Override
            public int convertItemViewType(int position) {
                return R.layout.item_fragmentbeautygir;
            }

            @Override
            public int getlayoutId(int viewType) {

                return R.layout.item_fragmentbeautygir;
            }
        };

        recycleview.setAdapter(adapter);
        recycleview.setLayoutManager(new GridLayoutManager(getActivity(),2));

    }

    @Override
    public void onRefresh(List<BeautyGirDetail> beautyGirDetails) {

        adapter.initDatas(beautyGirDetails);
        swipeRefreshLayout.setRefreshing(false);
        page=2;
    }

    @Override
    public void onLoad(List<BeautyGirDetail> beautyGirDetails) {
        adapter.addDatas(beautyGirDetails);
        swipeRefreshLayout.setRefreshing(false);
        page++;
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
