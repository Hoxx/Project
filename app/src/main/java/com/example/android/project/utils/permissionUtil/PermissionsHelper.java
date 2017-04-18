package com.example.android.project.utils.permissionUtil;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Android on 17/4/13.
 */

public class PermissionsHelper extends PermissionsBase {
    private Activity activity;

    private ArrayList<PermissionBean> requestList;
    private ArrayList<PermissionBean> DeniedList;

    public PermissionsHelper(Activity activity) {
        super(activity);
        this.activity = activity;
        requestList = new ArrayList<>();
        DeniedList = new ArrayList<>();
    }

    private void checkPermission(String[] permissions) {
        checkPermission(permissions, null);
    }

    private void checkPermission(String[] permissions, Boolean[] permissionMasts) {
        for (int i = 0; i < permissions.length; i++) {
            PermissionBean bean = new PermissionBean();
            bean.setPermissionName(permissions[i]);
            bean.setPermissionCode(i);
            bean.setPermissionMast(permissionMasts != null ? permissionMasts[i] : false);
            bean.checkPermissionAllowed(activity);
            requestList.add(bean);
        }
    }

    private void checkDeniedPermission() {
        for (PermissionBean bean : requestList) {
            if (!bean.isPermissionAllow()) {
                DeniedList.add(bean);
            }
        }
    }

    public void requestPermission(String[] permissions) {
        checkPermission(permissions);
        checkDeniedPermission();
        if (DeniedList.size() <= 0) {
            //所有权限都已允许
            Log.e("TAG","所有权限都已允许");
            return;
        }
        //开始申请权限
        for (PermissionBean bean : DeniedList) {
            Log.e("TAG","开始申请权限"+bean.getPermissionName());
            bean.requestPermission(activity);
        }

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (PermissionBean bean : DeniedList) {
            if (requestCode == bean.getPermissionCode() && permissions[0].equals(bean.getPermissionName())) {
                //处理结果
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //权限允许，清除list中的bean
                    Log.e("TAG","权限允许，清除list中的bean:"+bean.getPermissionName());
                    DeniedList.remove(bean);
                } else {
                    //权限不允许
                    Log.e("TAG","权限不允许:"+bean.getPermissionName());
                    if(bean.isPermissionMast()){
                        //权限是必须
                        Log.e("TAG","权限是必须:"+bean.getPermissionName());
                        if(bean.showPermissionRationale(activity)){
                            //权限需要提醒
                            Log.e("TAG","权限需要提醒:"+bean.getPermissionName());
                        }else {
                            //权限不需要提醒
                            Log.e("TAG","权限不需要提醒:"+bean.getPermissionName());
                        }
                    }else {
                        //权限不是必须
                        Log.e("TAG","权限不是必须:"+bean.getPermissionName());
                    }
                }
            }
        }
    }

    @Override
    public void dialogPositiveClick() {

    }

    @Override
    public void dialogNegativeClick() {

    }
}
