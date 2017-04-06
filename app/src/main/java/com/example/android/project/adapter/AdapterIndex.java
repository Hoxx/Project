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
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.example.android.project.R;

import java.util.ArrayList;
import java.util.HashMap;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by Android on 2017/4/5.
 */

public class AdapterIndex extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<HashMap<String, Object>> list;


    public AdapterIndex(Context context, ArrayList<HashMap<String, Object>> list) {
        this.context = context;
        this.list = list;
    }

    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IndexItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_index, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        IndexItemViewHolder itemViewHolder = ((IndexItemViewHolder) holder);
        HashMap<String, Object> map = list.get(position);
        int iconResources = (int) map.get("ICON");
        String name = (String) map.get("NAME");
        itemViewHolder.tv_index_name.setText(name);
        Glide.with(context)
                .load(iconResources)
                .bitmapTransform(new BlurTransformation(context)) // “23”：设置模糊度(在0.0到25.0之间)，默认”25";"4":图片缩放比例,默认“1”。
                .into(itemViewHolder.iv_index_icon);
        itemViewHolder.cardview_index.setOnClickListener(new ItemOnClick(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class IndexItemViewHolder extends RecyclerView.ViewHolder {
        private CardView cardview_index;
        private ImageView iv_index_icon;
        private TextView tv_index_name;

        public IndexItemViewHolder(View itemView) {
            super(itemView);
            cardview_index = (CardView) itemView.findViewById(R.id.cardview_index);
            tv_index_name = (TextView) itemView.findViewById(R.id.tv_index_name);
            iv_index_icon = (ImageView) itemView.findViewById(R.id.iv_index_icon);
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

    public void setOnItemClickListener(AdapterIndex.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
