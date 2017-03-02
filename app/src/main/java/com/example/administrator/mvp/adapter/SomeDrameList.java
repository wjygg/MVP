package com.example.administrator.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewAdapter;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewViewHolder;
import com.example.administrator.mvp.adapter.section.StatelessSection;
import com.example.administrator.mvp.entity.SomeDramaEntity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.example.administrator.mvp.entity.SomeDramaEntity.*;

/**
 * Created by wangjingyun on 2017/3/2.
 */

public class SomeDrameList extends StatelessSection {

    private Context mContext;

    private List<SomeDramaEntity.ResultBean.SerializingBean> newBangumiSerials;

    public SomeDrameList(Context context,List<SomeDramaEntity.ResultBean.SerializingBean> newBangumiSerials) {
        super(R.layout.item_somedramalist_recyle,R.layout.item_somedram_empty);

        this.mContext=context;

        this.newBangumiSerials=newBangumiSerials;
    }

    @Override
    public int getContentItemsTotal() {
        return 0;
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeadViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {

        HeadViewHolder itemViewHolder = (HeadViewHolder) holder;

        itemViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        itemViewHolder.recyclerView.setAdapter(new RecycleViewAdapter<SomeDramaEntity.ResultBean.SerializingBean>(mContext, newBangumiSerials) {
            @Override
            public void convert(RecycleViewViewHolder holder, ResultBean.SerializingBean datas) {

                ImageView imageView=holder.getView(R.id.item_img);

                Glide.with(mContext)
                        .load(datas.getCover())
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate()
                        .into(imageView);
            }

            @Override
            public int convertItemViewType(int position) {
                return R.layout.item_somedramaslist;
            }

            @Override
            public int getlayoutId(int viewType) {
                return R.layout.item_somedramaslist;
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {





    }
    static class HeadViewHolder extends RecyclerView.ViewHolder {


        @InjectView(R.id.recycleview)
        RecyclerView recyclerView;



        public HeadViewHolder(View itemView) {

            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }

    static class ItemViewHolder extends  RecyclerView.ViewHolder{

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }







}
