package com.example.android.project.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.android.project.R;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by Android on 2017/4/6.
 */

public class PhotoViewDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private View viewDialog;
    private PhotoView photoView;
    private ImageView imageView;

    public PhotoViewDialog(Context context) {
        super(context, R.style.Transparent);
        init(context);
    }


    private void init(Context context) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        viewDialog = inflater.inflate(R.layout.dialog_photoview, null);
        photoView = (PhotoView) viewDialog.findViewById(R.id.pv_dialog);
        imageView = (ImageView) viewDialog.findViewById(R.id.iv_dialog_close);
        imageView.setOnClickListener(this);
        setContentView(viewDialog);
    }

    public void setImage(String url) {
        Glide.with(context).load(url).into(photoView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_dialog_close:
                PhotoViewDialog.this.dismiss();
                break;
        }
    }
}
