package com.example.android.project.model;

import android.text.TextUtils;
import android.util.Log;

import com.example.android.project.base.BaseModel;
import com.example.android.project.base.IBaseDataInterface;
import com.example.android.project.bean.NewsContent;
import com.example.android.project.bean.NewsContentRoot;
import com.example.android.project.datainterface.INewsContentCallback;
import com.example.android.project.net.Constant;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsContentModel extends BaseModel implements INewsContentModel {

    private INewsContentCallback iNewsContentCallback;
    private String ChannelID, ChannelName;

    private String needContent = "1";
    private String needHtml = "1";
    private String needAllList = "0";

    private Observer<List<NewsContent>> observer = new Observer<List<NewsContent>>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<NewsContent> list) {
            if (iNewsContentCallback != null)
                iNewsContentCallback.onSuccess(list);
        }

        @Override
        public void onError(Throwable e) {
            if (iNewsContentCallback != null)
                iNewsContentCallback.onError(e.toString());
        }

        @Override
        public void onComplete() {

        }
    };

    private Function<NewsContentRoot, List<NewsContent>> function = new Function<NewsContentRoot, List<NewsContent>>() {
        @Override
        public List<NewsContent> apply(NewsContentRoot newsContentRoot) throws Exception {
            return newsContentRoot.getShowapi_res_body().getPagebean().getContentlist();
        }
    };

    @Override
    public void getData(IBaseDataInterface dataInterface) {
        iNewsContentCallback = (INewsContentCallback) dataInterface;
    }

    @Override
    public void onRefreshData() {
        if (!TextUtils.isEmpty(ChannelID) && !TextUtils.isEmpty(ChannelName))
            request(iAPI.getNewsContent(ChannelID, ChannelName, "", "1", needContent, needHtml, needAllList, Constant.MAX_RESULT),
                    function, observer);
    }

    @Override
    public void onLoadData(int page) {
        if (!TextUtils.isEmpty(ChannelID) && !TextUtils.isEmpty(ChannelName))
            request(iAPI.getNewsContent(ChannelID, ChannelName, "", "" + page, needContent, needHtml, needAllList, Constant.MAX_RESULT),
                    function, observer);
    }

    @Override
    public void loadData(String channelID, String channelName, String page) {
        ChannelID = channelID;
        ChannelName = channelName;
        request(iAPI.getNewsContent(channelID, channelName, "", page, needContent, needHtml, needAllList, Constant.MAX_RESULT),
                function, observer);
    }
}
