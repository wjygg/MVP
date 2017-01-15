package com.example.administrator.mvp.adapter.recycleviewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.mvp.R;

/**
 * 通用的viewholder 控件存储到sparseArray中
 * Created by wangjingyun on 2016/12/22.
 */

public class RecycleViewViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> sparseArray;

    private Context context;

    private View convertView;

    public RecycleViewViewHolder(View itemView,Context context) {
        super(itemView);

        sparseArray=new SparseArray<View>();

        this.convertView =itemView;

        this.context=context;
    }

    public static RecycleViewViewHolder getViewHolder(int layoutId,ViewGroup parent,Context context){

        View view= LayoutInflater.from(context).inflate(layoutId,parent,false);

        return new RecycleViewViewHolder(view,context);
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

    public void setImgView(int viewId,String url){

        if(url!=null&&!url.equals("")){
            ImageView imageview=getView(viewId);
            Glide.with(context).load(url).placeholder(R.drawable.empty_book_img).error(R.drawable.empty_book_img).into(imageview);
        }
    }

}
