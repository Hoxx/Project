package com.example.android.project.view.news;

import android.os.Bundle;

import com.example.android.project.R;
import com.example.android.project.base.BaseFragment;
import com.example.android.project.net.Constant;

/**
 * Created by Android on 2017/4/6.
 */

public class FragmentNewsContent extends BaseFragment {

    private String ChannelID;
    private String ChannelTitle;


    public static FragmentNewsContent getInstance(String ChannelID, String ChannelTitle) {
        FragmentNewsContent fragmentNewsContent = new FragmentNewsContent();
        Bundle bundle = new Bundle();
        bundle.putString(Constant.CHANNEL_ID, ChannelID);
        bundle.putString(Constant.CHANNEL_TITLE, ChannelTitle);
        fragmentNewsContent.setArguments(bundle);
        return fragmentNewsContent;
    }

    @Override
    public int setLayout() {
        return R.layout.fragment_news_content;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initDate() {
        getData();
    }

    public void getData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            ChannelID = bundle.getString(Constant.CHANNEL_ID);
            ChannelTitle = bundle.getString(Constant.CHANNEL_TITLE);
        }
    }
}
