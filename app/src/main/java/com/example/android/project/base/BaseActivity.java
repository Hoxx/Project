package com.example.android.project.base;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.project.utils.PermissionHelper;

import java.io.File;

/**
 * Created by Android on 2017/4/1.
 */

public abstract class BaseActivity extends AppCompatActivity implements PermissionHelper.onPermissionResultListener {


    private ProgressDialog progressDialog;

    //权限
    private String[] FileSystemsPermissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private PermissionHelper permissionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutView());
        initView();
        initData();
        initialize();
    }


    private void initialize() {
        permissionHelper = new PermissionHelper(this);
        permissionHelper.requestPermission(FileSystemsPermissions, "请允许存储权限", this);
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
        permissionHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
