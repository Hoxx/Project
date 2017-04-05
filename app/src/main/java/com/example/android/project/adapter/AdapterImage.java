package com.example.android.project.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.project.R;
import com.example.android.project.bean.Results;

import java.util.List;

/**
 * Created by Android on 2017/4/1.
 */

public class AdapterImage extends RecyclerView.Adapter {

    private List<Results> list;
    private Context context;

    public AdapterImage(List<Results> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainHolder(LayoutInflater.from(context).inflate(R.layout.main_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainHolder mainHolder = ((MainHolder) holder);
        Results results = list.get(position);
        Glide.with(context).load(results.getUrl()).fitCenter().centerCrop().into(mainHolder.imageView);
        mainHolder.textview.setText(results.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MainHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textview;

        public MainHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textview = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
