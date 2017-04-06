package com.example.android.project.view.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.android.project.R;
import com.example.android.project.adapter.AdapterNewsChannel;
import com.example.android.project.base.BaseFragment;
import com.example.android.project.bean.NewsChannel;
import com.example.android.project.presenter.NewChannelPresenter;
import com.example.android.project.view.INewsChannelView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2017/4/5.
 */

public class FragmentNews extends BaseFragment implements INewsChannelView {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private AdapterNewsChannel adapterNewsChannel;
    private NewChannelPresenter newChannelPresenter;

    private List<NewsChannel> newsChannels;

    @Override
    public int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    public void initView() {
        tabLayout = (TabLayout) rootView.findViewById(R.id.tablayout_news);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager_news);
    }

    @Override
    public void initDate() {
        newsChannels = new ArrayList<>();
        adapterNewsChannel = new AdapterNewsChannel(getActivity().getSupportFragmentManager(), getActivity(), newsChannels);
        viewPager.setAdapter(adapterNewsChannel);
        tabLayout.setupWithViewPager(viewPager);
        newChannelPresenter = new NewChannelPresenter(this);
        newChannelPresenter.getData();
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
    public void setData(List<NewsChannel> list) {
        newsChannels.clear();
        newsChannels.addAll(list);
        adapterNewsChannel.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        newChannelPresenter.detachView();
    }
}
