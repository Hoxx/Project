package com.example.android.project.presenter;

import android.util.Log;

import com.example.android.project.base.BasePresenter;
import com.example.android.project.base.IBaseView;
import com.example.android.project.bean.Root;
import com.example.android.project.datainterface.IMainCallback;
import com.example.android.project.model.IMainModel;
import com.example.android.project.model.MainModel;
import com.example.android.project.view.IMainActivityView;

/**
 * Created by Android on 2017/4/1.
 */

public class MainPresenter extends BasePresenter {

    private IMainActivityView iMainActivityView;
    private IMainModel mainModel;

    public MainPresenter(IBaseView baseView) {
        super(baseView);
        iMainActivityView = (IMainActivityView) baseView;
        mainModel = new MainModel();
    }

    public void getData() {
        Log.e("TAG","Presenter-getData");
        iMainActivityView.showLoading();
        mainModel.getData(new IMainCallback() {
            @Override
            public void onSuccess(Root root) {
                Log.e("TAG","Presenter-结果");
                iMainActivityView.setData(root);
                iMainActivityView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                iMainActivityView.hideLoading();
            }
        });
    }

}
