package com.example.android.project.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.project.bean.NewsChannel;
import com.example.android.project.view.news.FragmentNewsContentView;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class AdapterNewsChannel extends FragmentPagerAdapter {

    private Context context;
    private List<NewsChannel> channels;

    public AdapterNewsChannel(FragmentManager fm, Context context, List<NewsChannel> channels) {
        super(fm);
        this.context = context;
        this.channels = channels;
    }

    @Override
    public Fragment getItem(int position) {
        NewsChannel channel = channels.get(position);
        return FragmentNewsContentView.getInstance(channel.getChannelId(), channel.getName());
    }

    @Override
    public int getCount() {
        return channels.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return channels.get(position).getName();
    }


}
