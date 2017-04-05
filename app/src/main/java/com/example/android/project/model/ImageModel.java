package com.example.android.project.model;

import com.example.android.project.base.BaseModel;
import com.example.android.project.base.IBaseDataInterface;
import com.example.android.project.bean.Root;
import com.example.android.project.datainterface.IImageCallback;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Android on 2017/4/1.
 */

public class ImageModel extends BaseModel implements IImageModel {

    private IImageCallback iImageCallback;

    private Observer<Root> observer = new Observer<Root>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(Root root) {
            if (iImageCallback != null)
                iImageCallback.onSuccess(root);
        }

        @Override
        public void onError(Throwable e) {
            if (iImageCallback != null)
                iImageCallback.onError(e.toString());
        }

        @Override
        public void onComplete() {

        }
    };


    public void loadData() {
        httpManager.request(iAPI.getVideoList("100", "3"), observer);
    }

    @Override
    public void onRefreshData() {
        loadData();
    }

    @Override
    public void onLoadData(int page) {
        httpManager.request(iAPI.getVideoList("100", "" + page), observer);
    }

    @Override
    public void getData(IBaseDataInterface dataInterface) {
        iImageCallback = (IImageCallback) dataInterface;
        loadData();
    }
}
