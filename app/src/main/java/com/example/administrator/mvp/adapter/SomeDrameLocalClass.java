package com.example.administrator.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.section.StatelessSection;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2017/2/28.
 */

public class SomeDrameLocalClass extends  StatelessSection{

    private Context context;

    public SomeDrameLocalClass(Context context) {

        super(R.layout.item_somedramaclass,R.layout.item_somedram_empty);

        this.context=context;
    }

    @Override
    public int getContentItemsTotal() {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {

        return new EmptyViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {

        return new ClassViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {

        ClassViewHolder classViewHolder= (ClassViewHolder) holder;

        //追番
        classViewHolder.ll_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "追番",Toast.LENGTH_SHORT).show();
            }
        });
        //放送表
        classViewHolder.ll_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "放送表",Toast.LENGTH_SHORT).show();
            }
        });
        //索引
        classViewHolder.ll_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "索引",Toast.LENGTH_SHORT).show();
            }
        });
    }


    static class EmptyViewHolder extends RecyclerView.ViewHolder{

        public EmptyViewHolder(View itemView) {
            super(itemView);
        }

    }

    static  class ClassViewHolder extends RecyclerView.ViewHolder{

        @InjectView(R.id.ll_them)
        LinearLayout ll_them;

        @InjectView(R.id.ll_line)
        LinearLayout ll_line;

        @InjectView(R.id.ll_index)
        LinearLayout ll_index;

        public ClassViewHolder(View itemView) {
            super(itemView);

            ButterKnife.inject(this,itemView);

        }
    }
}
