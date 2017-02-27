package com.example.administrator.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.section.StatelessSection;
import com.example.administrator.mvp.entity.SomeDramaEntity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by wangjingyun on 2017/2/27.
 *
 */

public class SomeDramaBanner extends StatelessSection {


    private List<SomeDramaEntity.ResultBean.AdBean.HeadBean> banners;

    public SomeDramaBanner(List<SomeDramaEntity.ResultBean.AdBean.HeadBean> banners) {
        super(R.layout.item_somedramebanner);

        this.banners=banners;
    }

    @Override
    public int getContentItemsTotal() {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {

        return new BannerViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {

        BannerViewHolder bannerViewHolder=(BannerViewHolder)holder;

        bannerViewHolder.banner.setImages(getBanner()).setImageLoader(new GlideImageLoader()).start();
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder{

        Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);

            banner= (Banner) itemView.findViewById(R.id.banner);
        }

    }private class GlideImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context).load(path).into(imageView);
        }
    }

    public List<String> getBanner(){

        List<String> imgUrl=new ArrayList<String>();
        for(int i=0;i<banners.size();i++){

            imgUrl.add(banners.get(i).getImg());
        }

        return imgUrl;
    }

}
