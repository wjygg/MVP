package com.example.administrator.mvp.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewAdapter;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewViewHolder;
import com.example.administrator.mvp.base.BaseActivity;
import com.example.administrator.mvp.presenter.CustomActvitiyPresenter;
import com.example.administrator.mvp.presenter.listener.CustomActvitiyPresenterListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * 各种自定义视图  activity
 * Created by wangjingyun on 2017/2/16.
 *
 */

public class CustomActvitiy extends BaseActivity <CustomActvitiyPresenterListener,CustomActvitiyPresenter> implements CustomActvitiyPresenterListener {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.recycleview)
    RecyclerView recyclerView;

    private List<String> datas=null;
    @Override
    public int getActivityId() {

        return R.layout.activity_customactvitiy;
    }

    @Override
    public CustomActvitiyPresenter initPresenter() {
        return new CustomActvitiyPresenter();
    }

    @Override
    public void initDatas() {

        toolbar.setTitle("自定义视图");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        //toolabar显示返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        datas=new ArrayList<String>();
        datas.add("自定义饼状图");

        datas.add("自定义蜘蛛图");

        recyclerView.setLayoutManager(new GridLayoutManager(CustomActvitiy.this,2));

        recyclerView.setAdapter(new RecycleViewAdapter<String>(CustomActvitiy.this,datas) {
            @Override
            public void convert(RecycleViewViewHolder holder, final String datas) {

                holder.setText(R.id.tv_text,datas);

                TextView textView=holder.getView(R.id.tv_text);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(datas.equals("自定义饼状图")){
                            Intent intent=new Intent(CustomActvitiy.this,PieChartActivity.class);
                            intent.putExtra("title",datas);
                            startActivity(intent);
                        }else if(datas.equals("自定义蜘蛛图")){

                            Intent intent=new Intent(CustomActvitiy.this, SpiderPictureActivity.class);
                            intent.putExtra("title",datas);
                            startActivity(intent);
                        }

                    }
                });
            }

            @Override
            public int convertItemViewType(int position) {
                return R.layout.item_customactivity;
            }

            @Override
            public int getlayoutId(int viewType) {
                return R.layout.item_customactivity;
            }
        });

    }



    @Override
    public void initEvent() {

        //toolbar点击返回
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
