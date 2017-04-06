package com.example.android.project.model;

import android.util.Log;

import com.example.android.project.base.BaseModel;
import com.example.android.project.base.IBaseDataInterface;
import com.example.android.project.bean.ImageRoot;
import com.example.android.project.datainterface.IImageCallback;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by Android on 2017/4/1.
 */

public class ImageModel extends BaseModel implements IImageModel {

    private IImageCallback iImageCallback;

    private Observer<List<String>> observer = new Observer<List<String>>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<String> list) {
            for (String s : list) {
                Log.e("TAG", "结果:" + s);
            }
            if (iImageCallback != null)
                iImageCallback.onSuccess(list);
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

    private Function<ImageRoot, List<String>> function = new Function<ImageRoot, List<String>>() {
        @Override
        public List<String> apply(ImageRoot imageRoot) throws Exception {
            Log.e("TAG", "结果getShowapi_res_code*:" + imageRoot.getShowapi_res_code());
            Log.e("TAG", "getShowapi_res_error*:" + imageRoot.getShowapi_res_error());
            List<String> list = imageRoot.getShowapi_res_body().getData();
            for (String s : list) {
                Log.e("TAG", "结果*:" + s);
            }
            return list;
        }
    };


    public void loadData() {
        request(iAPI.getImageList("1"), function, observer);
    }

    @Override
    public void onRefreshData() {
        loadData();
    }

    @Override
    public void onLoadData(int page) {
        request(iAPI.getImageList("" + page), function, observer);
    }

    @Override
    public void getData(IBaseDataInterface dataInterface) {
        iImageCallback = (IImageCallback) dataInterface;
        loadData();
    }
}
