package com.example.android.project.base;

import android.Manifest;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.project.utils.permissionUtil.PermissionHelper;
import com.example.android.project.utils.permissionUtil.PermissionsHelper;

/**
 * Created by Android on 2017/4/1.
 */

public abstract class BaseActivity extends AppCompatActivity implements PermissionHelper.onPermissionResultListener {


    private ProgressDialog progressDialog;

    //权限
    private String[] FileSystemsPermissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE};
//    private PermissionHelper permissionHelper;
    private PermissionsHelper permissionsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutView());
        initView();
        initData();
        initialize();
    }


    private void initialize() {
        permissionsHelper = new PermissionsHelper(this);
        permissionsHelper.requestPermission(FileSystemsPermissions);
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

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionsHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionGranted() {
        Log.e("TAG", "权限允许");
    }

    @Override
    public void onPermissionDenied() {
        Log.e("TAG", "权限禁止");
    }

    public abstract int setLayoutView();

    public abstract void initView();

    public abstract void initData();
}
