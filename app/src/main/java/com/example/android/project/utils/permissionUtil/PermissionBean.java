package com.example.android.project.utils.permissionUtil;

import android.app.Activity;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.SharedPreferencesCompat;
import android.text.TextUtils;

/**
 * Created by Android on 17/4/13.
 */

public class PermissionBean {

    private String permissionName;//权限名称
    private int permissionCode;//权限申请Code
    private boolean permissionAllow;//PERMISSION_GRANTED权限是否允许
    private boolean permissionMast;//权限是否必须

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public int getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(int permissionCode) {
        this.permissionCode = permissionCode;
    }

    public boolean isPermissionAllow() {
        return permissionAllow;
    }

    public void setPermissionAllow(boolean permissionAllow) {
        this.permissionAllow = permissionAllow;
    }

    public boolean isPermissionMast() {
        return permissionMast;
    }

    public void setPermissionMast(boolean permissionMast) {
        this.permissionMast = permissionMast;
    }

    public void checkPermissionAllowed(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            setPermissionAllow(true);
            return;
        }
        if (TextUtils.isEmpty(permissionName)) return;
        if (ContextCompat.checkSelfPermission(context, permissionName) == PackageManager.PERMISSION_GRANTED)
            setPermissionAllow(true);
        else
            setPermissionAllow(false);
    }

    public void requestPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{getPermissionName()}, getPermissionCode());
    }

    //检查权限是否需要提醒
    public boolean showPermissionRationale(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            setPermissionAllow(true);
            return false;
        }
        if (TextUtils.isEmpty(permissionName)) return false;
        //用户第一次运行，false
        //用户第一次点拒绝后，不勾选不再提示选项，之后调用返回true 显示申请权限的信息
        //用户勾选不再提醒后，false
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionName);
//        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionName)) {
//            //显示申请权限的信息
//            return true;
//        } else {
//            if (readData(activity)) {
//                //不显示申请权限的信息
//                saveData(activity);
//                return false;
//            } else {
//                //不再提示申请权限
//                return false;
//            }
//        }
    }

    private void saveData(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(permissionName + "firstRequest", false).commit();
    }

    private boolean readData(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(permissionName + "firstRequest", true);
    }
}
