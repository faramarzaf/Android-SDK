package com.faramarzaf.sdk.af_android_sdk.core.ui.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;

import androidx.appcompat.app.AppCompatDialog;

import com.faramarzaf.sdk.af_android_sdk.R;
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DialogCallback;

import java.util.Objects;

import static com.faramarzaf.sdk.af_android_sdk.core.util.Constants.DIALOG_WIDTH_PERCENTAGE;


public abstract class BaseDialog extends AppCompatDialog {

    protected DialogCallback dialogCallback;

    public BaseDialog(Context context) {
        super(context, R.style.Dialog_Theme);
    }

    protected abstract int getDialogLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(getDialogLayout());
        initDialog();
    }

    private void initDialog() {
        int width = getWidthOfDialog();
        Objects.requireNonNull(getWindow()).setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    private int getWidthOfDialog() {
        return (int) (getContext().getResources().getDisplayMetrics().widthPixels * DIALOG_WIDTH_PERCENTAGE);
    }

    public void setDialogCallback(DialogCallback dialogCallback) {
        this.dialogCallback = dialogCallback;
    }

}
