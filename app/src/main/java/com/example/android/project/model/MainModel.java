package com.example.android.project.model;

import android.util.Log;

import com.example.android.project.api.IMainAPI;
import com.example.android.project.base.BaseModel;
import com.example.android.project.base.IBaseDataInterface;
import com.example.android.project.bean.Root;
import com.example.android.project.datainterface.IMainCallback;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Android on 2017/4/1.
 */

public class MainModel extends BaseModel implements IMainModel {

    private IMainAPI mainAPI;
    private IMainCallback iMainCallback;

    public MainModel() {
        mainAPI = retrofit.create(IMainAPI.class);

    }


    private Observer<Root> observer = new Observer<Root>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(Root root) {
            Log.e("TAG", "Model-结果");
            if (iMainCallback != null)
                iMainCallback.onSuccess(root);
        }

        @Override
        public void onError(Throwable e) {
            if (iMainCallback != null)
                iMainCallback.onError(e.toString());
        }

        @Override
        public void onComplete() {

        }
    };


    public void loadData() {
        Log.e("TAG", "Model-getData");
        httpManager.request(mainAPI.getVideoList("30", "3"), observer);
    }

    @Override
    public void onRefreshData() {
        loadData();
    }

    @Override
    public void onLoadData(int page) {
        httpManager.request(mainAPI.getVideoList("30", "" + page), observer);
    }

    @Override
    public void getData(IBaseDataInterface dataInterface) {
        iMainCallback = (IMainCallback) dataInterface;
        loadData();
    }
}
