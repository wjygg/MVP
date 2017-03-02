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

public class SomeDrameNew extends StatelessSection{

    private Context mContext;

    private int season;

    private List<SomeDramaEntity.ResultBean.PreviousBean.ListBean> seasonNewBangumis;


    public SomeDrameNew(Context context, int season, List<SomeDramaEntity.ResultBean.PreviousBean.ListBean> seasonNewBangumis) {
        super(R.layout.layout_home_bangumi_season_new_head,
                R.layout.layout_home_bangumi_season_new_body);
        this.mContext = context;
        this.season = season;
        this.seasonNewBangumis = seasonNewBangumis;
    }

    @Override
    public int getContentItemsTotal() {
        return seasonNewBangumis.size();
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {

        HeaderViewHolder headerViewHolder
                = (HeaderViewHolder) holder;
        setSeasonIcon((HeaderViewHolder)holder);
    }


    private void setSeasonIcon(HeaderViewHolder headViewHolder) {

        switch (season) {
            case 1:
                //冬季
                headViewHolder.mSeasonText.setText("1月新番");
                headViewHolder.mSeasonIcon.setImageResource(R.drawable.bangumi_home_ic_season_1);
                break;

            case 2:
                //春季
                headViewHolder.mSeasonText.setText("4月新番");
                headViewHolder.mSeasonIcon.setImageResource(R.drawable.bangumi_home_ic_season_2);
                break;

            case 3:
                //夏季
                headViewHolder.mSeasonText.setText("7月新番");
                headViewHolder.mSeasonIcon.setImageResource(R.drawable.bangumi_home_ic_season_3);
                break;

            case 4:
                //秋季
                headViewHolder.mSeasonText.setText("10月新番");
                headViewHolder.mSeasonIcon.setImageResource(R.drawable.bangumi_home_ic_season_4);
                break;
        }
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {

        ItemViewHolder itemViewHolder
                = (ItemViewHolder) holder;

        SomeDramaEntity.ResultBean.PreviousBean.ListBean listBean = seasonNewBangumis.get(position);
        Glide.with(mContext)
                .load(listBean.getCover())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(itemViewHolder.mImage);

        itemViewHolder.mTitle.setText(listBean.getTitle());
        itemViewHolder.mPlay.setText(
                Integer.valueOf(listBean.getFavourites()) + "人追番");
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.tv_all_new_bangumi)
        TextView mAllNewBangumi;

        @InjectView(R.id.iv_season)
        ImageView mSeasonIcon;

        @InjectView(R.id.tv_season)
        TextView mSeasonText;


        HeaderViewHolder(View itemView) {

            super(itemView);
            ButterKnife.inject(this, itemView);
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


        public ItemViewHolder(View itemView) {

            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
