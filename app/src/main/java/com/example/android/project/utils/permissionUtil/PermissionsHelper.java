package com.example.android.project.utils.permissionUtil;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Android on 17/4/13.
 */

public class PermissionsHelper extends PermissionsBase {
    private Activity activity;

    private ArrayList<PermissionBean> requestList;
    private ArrayList<PermissionBean> DeniedList;

    private int requestIndex = 0;
    private boolean isStop = false;

    public PermissionsHelper(Activity activity) {
        super(activity);
        this.activity = activity;
        requestList = new ArrayList<>();
        DeniedList = new ArrayList<>();
    }


    public void requestPermission(String[] permissions) {
        requestPermission(permissions, null);
    }

    public void requestPermission(String[] permissions, Boolean[] permissionMasts) {
        PermissionToBean(permissions, permissionMasts);
        if (requestList.size() > 0) {//开始申请第一个权限
            requestPermission();
        }
    }

    //把权限转换成Bean类
    private void PermissionToBean(String[] permissions, Boolean[] permissionMasts) {
        for (int i = 0; i < permissions.length; i++) {
            PermissionBean bean = new PermissionBean();
            bean.setPermissionName(permissions[i]);
            bean.setPermissionCode(i);
            bean.setPermissionMast(permissionMasts != null ? permissionMasts[i] : true);
            bean.checkPermissionAllowed(activity);
            bean.showPermissionRationale(activity);
            if (!bean.isPermissionAllow()) {
                requestList.add(bean);
            }
        }
    }

    private void requestPermission() {
        requestList.get(requestIndex).requestPermission(activity);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.e("TAG", "回调的权限：" + Arrays.toString(permissions));
        Log.e("TAG", "回调的结果：" + Arrays.toString(grantResults));
        if (permissions.length <= 0 || grantResults.length <= 0) return;
        for (PermissionBean bean : requestList) {
            //判断是否为当前权限
            if (requestCode == bean.getPermissionCode() && permissions[0].equals(bean.getPermissionName())) {
                //处理结果
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //权限允许，设置允许属性
                    bean.setPermissionAllow(true);
                } else {
                    //权限不允许，设置不允许属性
                    bean.setPermissionAllow(false);
                }
            }
        }
        //是否申请完毕
        if (!isRequestEnd()) {
            requestPermission();
        } else {//处理结果
            requestEnd();
            checkDeniedPermission();
        }

    }

    private void checkDeniedPermission() {
        //检查拒绝的权限，是否需要提醒
        if (DeniedList.size() > 0) {
            for (PermissionBean bean : DeniedList) {
                requestList.add(bean);
            }
            if (DeniedList.get(requestIndex).showPermissionRationale(activity)) {
                PermissionDialog.setMessage("应用程序需要您的权限，\n取消则会影响应用的使用。");
                PermissionDialog.show();
            } else {
                gotoSettingPermissionDialog();
            }
        }
    }

    //请求权限完毕处理
    private void requestEnd() {
        requestIndex = 0;
        DeniedList.clear();
        for (PermissionBean bean : requestList) {
            if (bean.isPermissionMast() && !bean.isPermissionAllow()) {//权限是必须的，并且没有被允许，添加到请求列表
                DeniedList.add(bean);
            }
        }
        requestList.clear();
    }

    //权限是否请求完毕
    private boolean isRequestEnd() {
        requestIndex++;
        return requestIndex >= requestList.size();
    }

    @Override
    public void dialogPositiveClick() {
        requestPermission();
    }

    @Override
    public void dialogNegativeClick() {

    }

    public void onResume() {
        if (DeniedList.size() > 0 && isStop) {
            isStop = false;
            requestPermission();
        }
    }

    public void onStop() {
        isStop = true;
    }
}
