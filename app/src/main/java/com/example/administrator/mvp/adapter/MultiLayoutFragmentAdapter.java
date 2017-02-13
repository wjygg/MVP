package com.example.administrator.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.mvp.R;
import com.example.administrator.mvp.adapter.recycleviewadapter.RecycleViewViewHolder;
import com.example.administrator.mvp.entity.MultiLayoutEntitiy;
import com.example.administrator.mvp.widget.CircleImageView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */

public class MultiLayoutFragmentAdapter extends RecyclerView.Adapter<RecycleViewViewHolder>{


    //jsonobject 首页整体数据
    private MultiLayoutEntitiy datas;

    private Context context;

    public MultiLayoutFragmentAdapter(MultiLayoutEntitiy datas,Context context){

        this.context=context;

        this.datas=datas;
    }


    @Override
    public RecycleViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){

            case R.layout.item_multilayout_banner:

                return  RecycleViewViewHolder.getViewHolder(R.layout.item_multilayout_banner,parent,context);

            case R.layout.item_multilayout_locallayout:

                return RecycleViewViewHolder.getViewHolder(R.layout.item_multilayout_locallayout,parent,context);
            case R.layout.item_multilayout_calsslayout:

                return RecycleViewViewHolder.getViewHolder(R.layout.item_multilayout_calsslayout,parent,context);

            case R.layout.item_multilayout_cardlayout:

                return RecycleViewViewHolder.getViewHolder(R.layout.item_multilayout_cardlayout,parent,context);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecycleViewViewHolder holder, int position) {

        //banner 布局设置 属性
       if(getItemViewType(position)==R.layout.item_multilayout_banner){

          Banner banner= holder.getView(R.id.banner);

          //设置banner样式（显示圆形指示器和标题）
           banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
           //设置图片加载器
           banner.setImageLoader(new GlideImageLoader());
           //设置图片集合
           banner.setImages(getBanner());
           //设置banner动画效果（正方体旋转式）
           banner.setBannerAnimation(Transformer.CubeOut);
           //设置标题集合（当banner样式有显示title时）
         //  banner.setBannerTitles(Arrays.asList(titles));
           //设置自动轮播，默认为true
           banner.isAutoPlay(true);
           //设置轮播时间
           banner.setDelayTime(2000);
           //设置指示器位置：左侧显示（当banner模式中有指示器时）
           banner.setIndicatorGravity(BannerConfig.LEFT);
           //banner设置方法全部调用完毕时最后调用
           banner.start();

           //本地分类
       }else if(getItemViewType(position)==R.layout.item_multilayout_locallayout){

           //分类布局
       }else if(getItemViewType(position)==R.layout.item_multilayout_calsslayout){

           MultiLayoutEntitiy.DataBean.PartitionsBean.PartitionBean partition = datas.getData().getPartitions().get(getItemTitle(position)).getPartition();

           ImageView img=holder.getView(R.id.item_live_partition_icon);

           Glide.with(context)
                   .load(partition.getSub_icon().getSrc())
                   .diskCacheStrategy(DiskCacheStrategy.ALL)
                   .into(img);

           TextView name=holder.getView(R.id.item_live_partition_title);
           name.setText(partition.getName());

           SpannableStringBuilder stringBuilder = new SpannableStringBuilder(
                   "当前" + partition.getCount() + "个直播");
           ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                   context.getResources().getColor(R.color.pink_text_color));
           stringBuilder.setSpan(foregroundColorSpan, 2,
                   stringBuilder.length() - 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

           TextView count=holder.getView(R.id.item_live_partition_count);
           count.setText(stringBuilder);
           //卡片布局
       }else {

         MultiLayoutEntitiy.DataBean.PartitionsBean.LivesBean livesBean=datas.getData().getPartitions().get(getItemTitle(position)).getLives().get(getCard(position));

           ImageView itemLiveCover=holder.getView(R.id.item_live_cover);
           Glide.with(context)
                   .load(livesBean.getCover().getSrc())
                   .centerCrop()
                   .diskCacheStrategy(DiskCacheStrategy.ALL)
                   .dontAnimate()
                   .into(itemLiveCover);

           CircleImageView itemLiveUserCover=holder.getView(R.id.item_live_user_cover);
           Glide.with(context)
                   .load(livesBean.getCover().getSrc())
                   .centerCrop()
                   .dontAnimate()
                   .placeholder(R.drawable.ico_user_default)
                   .diskCacheStrategy(DiskCacheStrategy.ALL)
                   .into(itemLiveUserCover);

           holder.setText(R.id.item_live_title,livesBean.getTitle());
           holder.setText(R.id.item_live_user,livesBean.getOwner().getName());
           holder.setText(R.id.item_live_count,String.valueOf(livesBean.getOnline()));

       }
    }

    @Override
    public int getItemCount() {

        //2 添加的banner 位置 和 分类位置
        if(datas!=null){

            return 2+datas.getData().getPartitions().size()*5;
        }
        return  0;
    }

    @Override
    public int getItemViewType(int position) {

        //返回banner
        if(position==0){

            return R.layout.item_multilayout_banner;
        //返回本地分类布局
        }else if(position==1){

            return R.layout.item_multilayout_locallayout;
        //返回 分类 title 的布局
        }else if(getItemPosition(position)){

            return R.layout.item_multilayout_calsslayout;

        }

        return R.layout.item_multilayout_cardlayout;
    }

    public  boolean getItemPosition(int position){

        //判断 分类 title 的位置
        if((position+3)%5==0){

            return true;
        }
        return false;
    }


    public int getItemTitle(int position){

        return (position+3)/5;

    }

    public int getCard(int position){

        return (position+2)%5;
    }


    public List<String> getBanner(){

        List<String> imgUrl=new ArrayList<String>();
        for(int i=0;i<datas.getData().getBanner().size();i++){

            imgUrl.add(datas.getData().getBanner().get(i).getImg());
        }

        return imgUrl;
    }


    private class GlideImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context).load(path).into(imageView);
        }
    }

    public int getSpanSize(int pos) {

        int viewType = getItemViewType(pos);
        switch (viewType) {

            case R.layout.item_multilayout_banner:
                return 2;
            case R.layout.item_multilayout_locallayout:
                return 2;
            case R.layout.item_multilayout_calsslayout:
                return 2;
            case R.layout.item_multilayout_cardlayout:
                return 1;
        }
        return 0;
    }





}
