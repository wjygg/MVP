package com.example.administrator.mvp.adapter.recycleviewadapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wangjingyun on 2016/12/31.
 *
 * http://www.jianshu.com/p/b46a4ff7c10 分隔条深入理解
 * recycleview的分隔条
 *
 */

public class RecycyleViewDivider extends RecyclerView.ItemDecoration{

    //获取系统的分隔条id

    private static  final int[] attr={android.R.attr.listDivider};

    //系统的分隔条对象
    private Drawable drawable;
    //分割线间隔
    private int dividerHeight;
    public RecycyleViewDivider(Context context,int dividerHeight){

        this.dividerHeight=dividerHeight;

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

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom=dividerHeight;
    }
}
