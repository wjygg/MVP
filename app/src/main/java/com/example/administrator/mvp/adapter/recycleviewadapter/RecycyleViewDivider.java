package com.example.administrator.mvp.adapter.recycleviewadapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;

/**
 * Created by wangjingyun on 2016/12/31.
 * recycleview的分隔条
 *
 */

public class RecycyleViewDivider extends RecyclerView.ItemDecoration{

    //获取系统的分隔条id

    private static  final int[] attr={android.R.attr.listDivider};

    //系统的分隔条对象
    private Drawable drawable;

    public RecycyleViewDivider(Context context){

        TypedArray a=context.obtainStyledAttributes(attr);

        drawable=a.getDrawable(0);

        a.recycle();
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
      //获得这条线距离左边的距离
        int left=parent.getPaddingLeft();
        //获得这条线距离右边的距离
        int right =parent.getWidth()-parent.getPaddingRight();


    }
}
