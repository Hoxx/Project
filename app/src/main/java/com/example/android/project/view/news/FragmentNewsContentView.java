package com.example.android.project.view.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.project.R;
import com.example.android.project.adapter.AdapterNewsContent;
import com.example.android.project.base.BaseFragment;
import com.example.android.project.bean.NewsContent;
import com.example.android.project.net.Constant;
import com.example.android.project.presenter.NewsContentPresenter;
import com.example.android.project.view.INewsContentView;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class FragmentNewsContentView extends BaseFragment implements INewsContentView {

    private String ChannelID;
    private String ChannelTitle;

    private RecyclerView recycler_news_content;
    private AdapterNewsContent adapterNewsContent;

    private NewsContentPresenter newsContentPresenter;


    public static FragmentNewsContentView getInstance(String ChannelID, String ChannelTitle) {
        FragmentNewsContentView fragmentNewsContent = new FragmentNewsContentView();
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
        recycler_news_content = (RecyclerView) rootView.findViewById(R.id.recycler_news_content);
        recycler_news_content.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void initDate() {
        getData();
        newsContentPresenter = new NewsContentPresenter(this);
        newsContentPresenter.getData();
    }

    public void getData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            ChannelID = bundle.getString(Constant.CHANNEL_ID);
            ChannelTitle = bundle.getString(Constant.CHANNEL_TITLE);
        }

    }

    @Override
    public void showLoading() {
        showLoadingDialog();
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog();
    }

    @Override
    public void getData(List<NewsContent> list) {
        adapterNewsContent = new AdapterNewsContent(list, getActivity());
        recycler_news_content.setAdapter(adapterNewsContent);
    }

    @Override
    public String getChannelID() {
        return ChannelID;
    }

    @Override
    public String getChannelName() {
        return ChannelTitle;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        newsContentPresenter.detachView();
    }
}
