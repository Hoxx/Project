package com.example.android.project.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.project.R;
import com.example.android.project.bean.Joke;

import java.util.List;

/**
 * Created by Android on 2017/4/1.
 */

public class AdapterJoke extends RecyclerView.Adapter {

    private List<Joke> list;
    private Context context;

    public AdapterJoke(List<Joke> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JokeHolder(LayoutInflater.from(context).inflate(R.layout.item_joke, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        JokeHolder jokeHolder = ((JokeHolder) holder);
        Joke joke = list.get(position);
        Glide.with(context).load(joke.getImg()).asGif().centerCrop().fitCenter().into(jokeHolder.iv_joke);
        jokeHolder.tv_joke.setText(joke.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class JokeHolder extends RecyclerView.ViewHolder {
        private ImageView iv_joke;
        private TextView tv_joke;

        public JokeHolder(View itemView) {
            super(itemView);
            iv_joke = (ImageView) itemView.findViewById(R.id.iv_joke);
            tv_joke = (TextView) itemView.findViewById(R.id.tv_joke);
        }
    }
}
