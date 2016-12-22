package com.example.administrator.mvp.adapter.recycleviewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
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

    private int layoutId;
    public RecycleViewAdapter(Context context,int layoutId,List<T> datas){

        this.context=context;

        this.layoutId=layoutId;

        this.datas = datas;
    }


    @Override
    public RecycleViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(layoutId,null);

        RecycleViewViewHolder holder=new RecycleViewViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecycleViewViewHolder holder, int position) {

        convert(holder,position);
    }

    @Override
    public int getItemCount() {

        return datas.size();
    }

    public abstract  void convert(RecycleViewViewHolder holder, int position);


}
