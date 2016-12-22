package com.example.administrator.mvp.adapter.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */

public abstract class ListViewAdapter<T> extends BaseAdapter{

    private List<T> datas;

    private Context context;

    private int layoutId;

    public ListViewAdapter(Context context,int layoutId,List<T> datas){
        this.datas=datas;

        this.layoutId=layoutId;

        this.context=context;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListViewViewHolder holder=null;

        if(convertView==null){

            convertView= LayoutInflater.from(context).inflate(layoutId,null);

            holder=new ListViewViewHolder(convertView);

            convertView.setTag(holder);

        }else{

            holder=(ListViewViewHolder)convertView.getTag();

        }

        convert(holder,position);

        return convertView;
    }

    public abstract void convert(ListViewViewHolder holder,int position);
}
