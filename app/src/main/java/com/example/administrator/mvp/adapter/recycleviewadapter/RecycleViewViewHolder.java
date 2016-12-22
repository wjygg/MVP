package com.example.administrator.mvp.adapter.recycleviewadapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * 通用的viewholder 控件存储到sparseArray中
 * Created by wangjingyun on 2016/12/22.
 */

public class RecycleViewViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> sparseArray;

    private View convertView;

    public RecycleViewViewHolder(View itemView) {
        super(itemView);

        sparseArray=new SparseArray<View>();

        this.convertView =itemView;
    }


    public <T extends View> T getView(int viewId){

        //判断sparseArray中有没有这个控件
       View view=sparseArray.get(viewId);

        if(view==null){
            //没有
            view=convertView.findViewById(viewId);
            sparseArray.put(viewId,view);
        }
        return (T)view;


    }

    public void setText(int viewId,String str){

        TextView view=getView(viewId);

        view.setText(str);

    }



}
