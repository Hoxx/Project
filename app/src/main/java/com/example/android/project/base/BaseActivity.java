package com.example.android.project.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Android on 2017/4/1.
 */

public abstract class BaseActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutView());
        initView();
        initData();
        initialize();
    }


    private void initialize() {

    }

    public void showLoadingDialog() {
        if (progressDialog == null)
            progressDialog = ProgressDialog.show(this, "", "加载中...");
        else
            progressDialog.show();
    }

    public void hideLoadingDialog() {
        if (progressDialog != null)
            progressDialog.cancel();
    }

    public abstract int setLayoutView();

    public abstract void initView();

    public abstract void initData();
}
