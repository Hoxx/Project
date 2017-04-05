package com.example.android.project.datainterface;

import com.example.android.project.base.IBaseDataInterface;
import com.example.android.project.bean.Root;

/**
 * Created by Android on 2017/4/1.
 */

public interface IMainCallback extends IBaseDataInterface {

    void onSuccess(Root root);

}
