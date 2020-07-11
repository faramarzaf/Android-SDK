package com.faramarzaf.sdk.af_android_sdk.core.ui.dialog;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

import com.faramarzaf.sdk.af_android_sdk.R;
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DialogCallback;

public class ProgressDialogCustom extends BaseDialog {

    private Context context;
    private AppCompatImageView imageDialog;
    private int imageRes;
    private int layout;
    private boolean cancelable;

    @Override
    public void setDialogCallback(DialogCallback dialogCallback) {
        this.dialogCallback = dialogCallback;
    }

    public ProgressDialogCustom(Context context, int layout, int imageRes, boolean cancelable) {
        super(context);
        this.context = context;
        this.layout = layout;
        this.imageRes = imageRes;
        this.cancelable = cancelable;
    }

    @Override
    protected int getDialogLayout() {
        return layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageDialog = findViewById(R.id.imageViewLogo);
        setImageDialog();
        checkCancelable();
    }

    private void setImageDialog() {
        if (imageDialog != null)
            imageDialog.setImageDrawable(ContextCompat.getDrawable(context, imageRes));
    }

    private void checkCancelable() {
        if (cancelable) {
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        } else {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        }
    }
}
