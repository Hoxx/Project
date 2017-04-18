package com.example.android.project.utils.permissionUtil;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Android on 2017/4/7.
 */

public class PermissionHelper {

    private Context context;
    private Activity activity;
    private final int PermissionsRequestCode = 0x1;

    private AlertDialog PermissionDialog;

    private String[] requestPermissions;
    private String showRequestPermissionRationale;

    private onPermissionResultListener onPermissionResultListener;

    private String dialogTitle = "权限申请";
    private String dialogNegativeButton = "取消";
    private String dialogPositiveButton = "确定";

    public PermissionHelper(Activity activity) {
        this.activity = activity;
        this.context = ((Context) activity);
        initDialog(activity);
    }

    public void requestPermission(String[] permissions, String ShowRequestPermissionRationale, onPermissionResultListener listener) {
        onPermissionResultListener = listener;
        requestPermissions = permissions;
        showRequestPermissionRationale = ShowRequestPermissionRationale;
        if (PermissionDialog != null)
            PermissionDialog.setMessage(showRequestPermissionRationale);
        checkPermission();
    }

    public void requestPermission(String[] permissions, onPermissionResultListener listener) {
        onPermissionResultListener = listener;
        requestPermissions = permissions;
        checkPermission();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (int i : grantResults) {
            Log.e("TAG", "grantResults:" + i);
        }
        for (String s : permissions) {
            Log.e("TAG", "permissions:" + s);
        }
        Log.e("TAG", "requestCode:" + requestCode);
        if (requestCode == PermissionsRequestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //申请权限成功
                if (onPermissionResultListener != null)
                    onPermissionResultListener.onPermissionGranted();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                //申请权限禁止
                if (onPermissionResultListener != null)
                    onPermissionResultListener.onPermissionDenied();
            } else {
                Log.e("TAG", "申请权限--其他");
            }
        }

    }

    //校验系统版本，检查权限
    private void checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (onPermissionResultListener != null)
                onPermissionResultListener.onPermissionGranted();
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, requestPermissions[0])) {
            //用户第一次点拒绝后，不勾选不再提示选项，之后调用返回true
            Log.e("TAG", "显示申请权限的信息");
            if (!TextUtils.isEmpty(showRequestPermissionRationale)) {
                PermissionDialog.show();
            }
        } else {
            //用户第一次运行，false
            //用户勾选不再提醒后，false
            if (readData()) {
                Log.e("TAG", "不显示申请权限的信息");
                saveData();
                requestPermission();
            } else {
                Log.e("TAG", "不再提示申请权限");
            }
        }
    }

    //申请权限
    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(context, requestPermissions[0]) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, requestPermissions, PermissionsRequestCode);
        } else {
            //已有存储权限
            if (onPermissionResultListener != null)
                onPermissionResultListener.onPermissionGranted();
        }
    }

    //初始化
    private void initDialog(Activity activity) {
        PermissionDialog = new AlertDialog.Builder(activity).setTitle(dialogTitle)
                .setPositiveButton(dialogPositiveButton,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestPermission();
                                dialog.dismiss();
                            }
                        })
                .setNegativeButton(dialogNegativeButton,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
    }

    public interface onPermissionResultListener {
        void onPermissionGranted();

        void onPermissionDenied();
    }

    public interface onPermissionAndShowRationaleListener extends onPermissionResultListener {
        void onShowRationalePositive();
    }

    public void saveData() {
        context.getSharedPreferences("config", Context.MODE_PRIVATE).edit().putBoolean("firstRequest", false).commit();
    }

    public boolean readData() {
        return context.getSharedPreferences("config", Context.MODE_PRIVATE).getBoolean("firstRequest", true);
    }
}
