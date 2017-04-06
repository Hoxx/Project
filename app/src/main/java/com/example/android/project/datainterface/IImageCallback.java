package com.example.android.project.datainterface;

import com.example.android.project.base.IBaseDataInterface;

import java.util.List;

/**
 * Created by Android on 2017/4/1.
 */

public interface IImageCallback extends IBaseDataInterface {

    void onSuccess(List<String> list);

}
