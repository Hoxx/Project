package com.example.android.project.datainterface;

import com.example.android.project.base.IBaseDataInterface;
import com.example.android.project.bean.NewsContent;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public interface INewsContentCallback extends IBaseDataInterface {

    void onSuccess(List<NewsContent> list);
}
