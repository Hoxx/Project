package com.example.android.project.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Android on 2017/4/7.
 */

public class MessageDialog extends Dialog {

    private Context context;
    private View viewDialog;

    public MessageDialog(Context context, int layout) {
        super(context);
        init(context, layout);
    }

    private void init(Context context, int layout) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        viewDialog = inflater.inflate(layout, null);
        setContentView(viewDialog);
    }


}
