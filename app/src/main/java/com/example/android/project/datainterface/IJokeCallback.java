package com.example.android.project.datainterface;

import com.example.android.project.base.IBaseDataInterface;
import com.example.android.project.bean.Joke;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public interface IJokeCallback extends IBaseDataInterface {

    void onSuccess(List<Joke> list);

}
