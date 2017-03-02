package com.example.administrator.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.section.StatelessSection;
import com.example.administrator.mvp.entity.SomeDramaEntity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by wangjingyun on 2017/3/2.
 */

public class SomeDrameSerializing extends StatelessSection {

    private Context mContext;

    private List<SomeDramaEntity.ResultBean.SerializingBean> newBangumiSerials;

    public SomeDrameSerializing(Context context,List<SomeDramaEntity.ResultBean.SerializingBean> newBangumiSerials) {
        super(R.layout.item_somedramaserializing_body,R.layout.item_somedramaserializing);

        this.mContext=context;

        this.newBangumiSerials=newBangumiSerials;
    }

    @Override
    public int getContentItemsTotal() {
        return newBangumiSerials.size();
    }


    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new Head(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {

    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {


        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        SomeDramaEntity.ResultBean.SerializingBean serializingBean = newBangumiSerials.get(
                position);

        Glide.with(mContext)
                .load(serializingBean.getCover())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(itemViewHolder.mImage);

        itemViewHolder.mTitle.setText(serializingBean.getTitle());
        itemViewHolder.mPlay.setText(
                serializingBean.getWatching_count() + "人在看");
        itemViewHolder.mUpdate.setText("更新至第" + serializingBean.getNewest_ep_index() + "话");
    }

    static class Head extends RecyclerView.ViewHolder{


        public Head(View itemView) {
            super(itemView);
        }

    }


    static class ItemViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.card_view)
        LinearLayout mCardView;

        @InjectView(R.id.item_img)
        ImageView mImage;

        @InjectView(R.id.item_title)
        TextView mTitle;

        @InjectView(R.id.item_play)
        TextView mPlay;

        @InjectView(R.id.item_update)
        TextView mUpdate;


        public ItemViewHolder(View itemView) {

            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }



}
