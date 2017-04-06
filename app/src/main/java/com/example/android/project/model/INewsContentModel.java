package com.example.android.project.model;

import com.example.android.project.base.IBaseModel;

/**
 * Created by Android on 2017/4/6.
 */

public interface INewsContentModel extends IBaseModel {

    void loadData(String channelID, String channelName, String page);

}
