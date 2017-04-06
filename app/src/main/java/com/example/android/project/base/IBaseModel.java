package com.example.android.project.base;

import io.reactivex.Observer;

/**
 * Created by Android on 2017/4/1.
 */

public interface IBaseModel {

     void getData(IBaseDataInterface dataInterface);

     void onRefreshData();

     void onLoadData(int page);

}
