package com.example.android.project.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.project.R;
import com.example.android.project.bean.NewsContent;

import java.util.List;

/**
 * Created by Android on 2017/4/1.
 */

public class AdapterNewsContent extends RecyclerView.Adapter {

    private List<NewsContent> list;
    private Context context;

    public AdapterNewsContent(List<NewsContent> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsContentHolder(LayoutInflater.from(context).inflate(R.layout.item_news_content, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewsContentHolder newsContentHolder = ((NewsContentHolder) holder);
        NewsContent content = list.get(position);
        if (content.getHavePic())
            Glide.with(context).load(content.getImageurls().get(0).getUrl()).centerCrop().fitCenter().into(newsContentHolder.iv_news_content);
        else
            Glide.with(context).load(R.mipmap.empty).centerCrop().fitCenter().into(newsContentHolder.iv_news_content);
        newsContentHolder.tv_news_content_title.setText(content.getTitle());
        newsContentHolder.tv_news_content_time.setText(content.getPubDate());
        newsContentHolder.tv_news_content_des.setText(content.getDesc());
        newsContentHolder.cardview_news_content.setOnClickListener(new ItemOnClick(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NewsContentHolder extends RecyclerView.ViewHolder {
        private CardView cardview_news_content;
        private ImageView iv_news_content;
        private TextView tv_news_content_title;
        private TextView tv_news_content_time;
        private TextView tv_news_content_des;

        public NewsContentHolder(View itemView) {
            super(itemView);
            cardview_news_content = (CardView) itemView.findViewById(R.id.cardview_news_content);
            iv_news_content = (ImageView) itemView.findViewById(R.id.iv_news_content);
            tv_news_content_title = (TextView) itemView.findViewById(R.id.tv_news_content_title);
            tv_news_content_time = (TextView) itemView.findViewById(R.id.tv_news_content_time);
            tv_news_content_des = (TextView) itemView.findViewById(R.id.tv_news_content_des);
        }
    }

    class ItemOnClick implements View.OnClickListener {

        private int position;

        public ItemOnClick(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null)
                onItemClickListener.onItemClick(position);
        }
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    private onItemClickListener onItemClickListener;

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
