package com.example.android.project.presenter;

import android.util.Log;

import com.example.android.project.base.BasePresenter;
import com.example.android.project.base.IBaseView;
import com.example.android.project.bean.Root;
import com.example.android.project.datainterface.IImageCallback;
import com.example.android.project.model.IImageModel;
import com.example.android.project.model.ImageModel;
import com.example.android.project.view.IImageView;

/**
 * Created by Android on 2017/4/1.
 */

public class ImagePresenter extends BasePresenter {

    private IImageView iImageView;
    private IImageModel indexModel;

    public ImagePresenter(IBaseView baseView) {
        super(baseView);
        iImageView = (IImageView) baseView;
        indexModel = new ImageModel();
    }

    public void getData() {
        Log.e("TAG", "Presenter-getData");
        iImageView.showLoading();
        indexModel.getData(new IImageCallback() {
            @Override
            public void onSuccess(Root root) {
                Log.e("TAG", "Presenter-结果");
                iImageView.setData(root);
                iImageView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                iImageView.hideLoading();
            }
        });
    }

}
