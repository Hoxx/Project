package com.example.android.project.view;

import com.example.android.project.base.IBaseView;
import com.example.android.project.bean.NewsChannel;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public interface INewsChannelView extends IBaseView {

    void setData(List<NewsChannel> list);
}
