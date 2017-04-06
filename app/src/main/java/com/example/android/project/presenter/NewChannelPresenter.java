package com.example.android.project.presenter;

import com.example.android.project.base.BasePresenter;
import com.example.android.project.base.IBaseView;
import com.example.android.project.bean.NewsChannel;
import com.example.android.project.datainterface.INewsChannelCallback;
import com.example.android.project.model.INewsChannelModel;
import com.example.android.project.model.NewsChannelModel;
import com.example.android.project.view.INewsChannelView;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class NewChannelPresenter extends BasePresenter {

    private INewsChannelView iNewsChannelView;
    private INewsChannelModel iNewsChannelModel;

    public NewChannelPresenter(IBaseView baseView) {
        super(baseView);
        iNewsChannelView = (INewsChannelView) baseView;
        iNewsChannelModel = new NewsChannelModel();
    }

    @Override
    public void getData() {
        iNewsChannelView.showLoading();
        iNewsChannelModel.getData(new INewsChannelCallback() {
            @Override
            public void onSuccess(List<NewsChannel> list) {
                if (iNewsChannelView != null)
                    iNewsChannelView.setData(list);
                iNewsChannelView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                iNewsChannelView.hideLoading();
            }
        });
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void LoadData(int page) {

    }
}
