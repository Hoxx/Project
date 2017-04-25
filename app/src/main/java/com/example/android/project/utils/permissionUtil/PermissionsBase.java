package com.example.android.project.utils.permissionUtil;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Created by Android on 17/4/13.
 */

public abstract class PermissionsBase {

    private Activity activity;
    private Context context;
    //权限申请弹出框
    public AlertDialog PermissionDialog;
    private String dialogTitle = "权限申请";
    private String dialogSettingMessage = "应用程序需要您的权限，请点击确定，\n取消则会影响应用的使用。";
    private String dialogMessage = "应用程序需要您的权限，\n取消则会影响应用的使用。";
    private String dialogNegativeButton = "取消";
    private String dialogPositiveButton = "确定";

    private boolean gotoSetting = false;


    public PermissionsBase(Activity activity) {
        this.activity = activity;
//        context = ((Context) activity);
        initDialog(activity);
    }

    public void setDialogSettingMessage(String dialogSettingMessage) {
        this.dialogSettingMessage = dialogSettingMessage;
    }

    public void setDialogMessage(String dialogMessage) {
        this.dialogMessage = dialogMessage;
    }

    //初始化
    private void initDialog(Activity activity) {
        PermissionDialog = new AlertDialog.Builder(activity)
                .setTitle(dialogTitle)
                .setPositiveButton(dialogPositiveButton,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (gotoSetting) {
                                    gotoSetting();
                                } else {
                                    dialogPositiveClick();
                                }
                                dialog.dismiss();
                            }
                        })
                .setNegativeButton(dialogNegativeButton,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialogNegativeClick();
                                dialog.dismiss();
                            }
                        }).create();
    }

    public void gotoSettingPermissionDialog() {
        gotoSetting = true;
        PermissionDialog.setMessage(dialogSettingMessage);
        PermissionDialog.show();
    }

    private void gotoSetting() {
        Uri packageURI = Uri.parse("package:" + activity.getPackageName());
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
        activity.startActivity(intent);
    }

    public abstract void dialogPositiveClick();

    public abstract void dialogNegativeClick();

}
