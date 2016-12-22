package com.example.administrator.mvp.adapter.listviewadapter;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by Administrator on 2016/12/22.
 */

public class ListViewViewHolder {

    private SparseArray<View> sparseArray;

    private View convertView;

    public ListViewViewHolder(View convertView){
        sparseArray=new SparseArray<View>();
        this.convertView=convertView;
    }

    public <T extends View> T getView(int layoutId){
        View view=sparseArray.get(layoutId);
        if(view==null){
            view=convertView.findViewById(layoutId);
            sparseArray.put(layoutId,view);
        }
        return (T)view;
    }



}
