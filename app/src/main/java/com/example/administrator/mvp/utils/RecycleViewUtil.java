package com.example.administrator.mvp.utils;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2017/1/4.
 */

public class RecycleViewUtil {

    //computeVerticalScrollExtent 当前可见recycleview 距离  computeVerticalScrollOffset 滚动过的距离
    //computeVerticalScrollRange recycleview总高度
    public static boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset()
                >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }
}
