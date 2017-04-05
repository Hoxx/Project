package com.example.android.project.model;

import com.example.android.project.base.IBaseModel;

/**
 * Created by Android on 2017/4/1.
 */

public interface IImageModel extends IBaseModel {

    void onRefreshData();

    void onLoadData(int page);

}
