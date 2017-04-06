package com.example.android.project.view;

import com.example.android.project.base.IBaseView;
import com.example.android.project.bean.NewsContent;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public interface INewsContentView extends IBaseView {

    void getData(List<NewsContent> list);

    String getChannelID();

    String getChannelName();

}
