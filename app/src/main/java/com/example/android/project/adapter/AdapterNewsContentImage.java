package com.example.android.project.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.android.project.R;
import com.example.android.project.bean.NewsContentImage;
import com.example.android.project.utils.Tools;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class AdapterNewsContentImage extends RecyclerView.Adapter {

    private Context context;
    private List<NewsContentImage> list;

    public AdapterNewsContentImage(Context context, List<NewsContentImage> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsContentImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news_content_image, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewsContentImageViewHolder newsContentImageViewHolder = ((NewsContentImageViewHolder) holder);
        int imageSize = (Tools.getScreenWidth(context) - 20) / 2;
        ViewGroup.LayoutParams layoutParams = newsContentImageViewHolder.iv_news_content_image.getLayoutParams();
        layoutParams.width = imageSize;
        layoutParams.height = imageSize;
        Glide.with(context).load(list.get(position).getUrl()).fitCenter().centerCrop().into(newsContentImageViewHolder.iv_news_content_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NewsContentImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_news_content_image;

        public NewsContentImageViewHolder(View itemView) {
            super(itemView);
            iv_news_content_image = (ImageView) itemView.findViewById(R.id.iv_news_content_image);
        }
    }


}
