package com.example.android.project.utils.permissionUtil;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by Android on 17/4/13.
 */

public abstract class PermissionsBase {

    private Activity activity;
    private Context context;
    //权限申请弹出框
    private AlertDialog PermissionDialog;
    private String dialogTitle = "权限申请";
    private String dialogNegativeButton = "取消";
    private String dialogPositiveButton = "确定";


    public PermissionsBase(Activity activity) {
        this.activity = activity;
        context = ((Context) activity);
    }

    //初始化
    private void initDialog(Activity activity) {
        PermissionDialog = new AlertDialog.Builder(activity).setTitle(dialogTitle)
                .setPositiveButton(dialogPositiveButton,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialogPositiveClick();
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

    public abstract void dialogPositiveClick();

    public abstract void dialogNegativeClick();

}
