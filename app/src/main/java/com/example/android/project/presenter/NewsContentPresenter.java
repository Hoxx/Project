package com.example.android.project.presenter;

import com.example.android.project.base.BasePresenter;
import com.example.android.project.base.IBaseView;
import com.example.android.project.bean.NewsContent;
import com.example.android.project.datainterface.INewsContentCallback;
import com.example.android.project.model.INewsContentModel;
import com.example.android.project.model.NewsContentModel;
import com.example.android.project.view.INewsContentView;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsContentPresenter extends BasePresenter {

    private INewsContentView iNewsContentView;
    private INewsContentModel iNewsContentModel;

    public NewsContentPresenter(IBaseView baseView) {
        super(baseView);
        iNewsContentView = (INewsContentView) baseView;
        iNewsContentModel = new NewsContentModel();
    }

    @Override
    public void getData() {
        iNewsContentView.showLoading();
        iNewsContentModel.getData(new INewsContentCallback() {
            @Override
            public void onSuccess(List<NewsContent> list) {
                if (iNewsContentView != null)
                    iNewsContentView.getData(list);
                iNewsContentView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                iNewsContentView.hideLoading();
            }
        });
        iNewsContentModel.loadData(iNewsContentView.getChannelID(), iNewsContentView.getChannelName(), "1");
    }

    @Override
    public void refreshData() {
        iNewsContentModel.onRefreshData();
    }

    @Override
    public void LoadData(int page) {
        iNewsContentModel.onLoadData(page);
    }
}
