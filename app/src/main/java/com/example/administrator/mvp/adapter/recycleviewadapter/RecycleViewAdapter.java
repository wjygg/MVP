package com.example.administrator.mvp.adapter.recycleviewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * 通用的recycleview适配器
 * Created by wangjingyun on 2016/12/22.
 * 参考 http://blog.csdn.net/lmj623565791/article/details/51118836
 */

public abstract  class RecycleViewAdapter<T> extends RecyclerView.Adapter<RecycleViewViewHolder>{

    private List<T> datas;

    private Context context;

    private int datasSize;

    public RecycleViewAdapter(Context context,List<T> datas, int datasSize){

        this.context=context;

        this.datas = datas;

        this.datasSize=datasSize;
    }

    @Override
    public int getItemViewType(int position) {

        return convertItemViewType(position);
    }

    @Override
    public RecycleViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecycleViewViewHolder viewholder=RecycleViewViewHolder.getViewHolder(getlayoutId(viewType),parent,context);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecycleViewViewHolder holder, int position) {

        convert(holder,position);
    }

    @Override
    public int getItemCount() {

        return datasSize;
    }

    public abstract  void convert(RecycleViewViewHolder holder, int position);

    //抛出返回类型
    public abstract int convertItemViewType(int position);

    //抛出加载的布局
    public abstract int getlayoutId(int viewType);
}
