package com.example.android.project.model;

import com.example.android.project.base.BaseModel;
import com.example.android.project.base.IBaseDataInterface;
import com.example.android.project.bean.NewsChannel;
import com.example.android.project.bean.NewsChannelRoot;
import com.example.android.project.datainterface.INewsChannelCallback;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsChannelModel extends BaseModel implements INewsChannelModel {

    private INewsChannelCallback iNewsChannelCallback;

    private Observer<List<NewsChannel>> observer = new Observer<List<NewsChannel>>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<NewsChannel> list) {
            if (iNewsChannelCallback != null)
                iNewsChannelCallback.onSuccess(list);
        }

        @Override
        public void onError(Throwable e) {
            if (iNewsChannelCallback != null)
                iNewsChannelCallback.onError(e.toString());
        }

        @Override
        public void onComplete() {

        }
    };

    private Function<NewsChannelRoot, List<NewsChannel>> function = new Function<NewsChannelRoot, List<NewsChannel>>() {
        @Override
        public List<NewsChannel> apply(NewsChannelRoot newsChannelRoot) throws Exception {
            return newsChannelRoot.getShowapi_res_body().getChannelList();
        }
    };

    @Override
    public void getData(IBaseDataInterface dataInterface) {
        iNewsChannelCallback = (INewsChannelCallback) dataInterface;
        loadData();
    }

    @Override
    public void onRefreshData() {
        loadData();
    }

    @Override
    public void onLoadData(int page) {

    }

    private void loadData() {
        request(iAPI.getNewsChannel(), function, observer);
    }
}
