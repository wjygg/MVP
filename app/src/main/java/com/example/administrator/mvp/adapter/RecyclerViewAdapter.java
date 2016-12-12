package com.example.administrator.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mvp.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2016/12/12.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Context context;

    private List<String> datas;

    public RecyclerViewAdapter(Context context, List<String> datas){
        this.context=context;
        this.datas=datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.item_fragmentlist,null);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
             holder.textview.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
     @InjectView(R.id.tv_num)
     TextView textview;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(itemView);
        }
    }
}
