package com.faramarzaf.sdk.af_android_sdk.core.ui.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.faramarzaf.sdk.af_android_sdk.R;

/**
 * @author Faramarz Afzali
 * 22/july/2020
 */

public class PasswordEditText extends LinearLayout {

    private View rootView;
    private TypedArray typedArray;
    private ImageView iconPassword;
    private EditText mainEditText;
    private Drawable srcIcon;
    private int defaultTextColor;
    private int backgroundIconColor;
    private float textSize;
    private String hint;
    private String fontFamily;


    public PasswordEditText(Context context) {
        super(context);
        init(context);
        doClick();
    }


    public PasswordEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
        setHint(attrs);
        setIconResource(attrs);
        setBackgroundIconColor(attrs);
        setTextSize(attrs);
        setTextColor(attrs);
        setFont(context, attrs);
        doClick();
    }


    private void init(Context context) {
        setSaveEnabled(true);
        rootView = inflate(context, R.layout.layout_password_edittext, this);
        iconPassword = rootView.findViewById(R.id.iconPassword);
        mainEditText = rootView.findViewById(R.id.mainEditText);
    }


    private void setHint(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.PasswordEditText);
        hint = typedArray.getString(R.styleable.PasswordEditText_pet_hint);
        mainEditText.setHint(hint);
        typedArray.recycle();
    }

    private void setTextColor(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.PasswordEditText);
        defaultTextColor = typedArray.getInt(R.styleable.PasswordEditText_pet_textColor, Color.BLACK);
        mainEditText.setTextColor(defaultTextColor);
        typedArray.recycle();
    }

    private void setIconResource(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.PasswordEditText);
        srcIcon = typedArray.getDrawable(R.styleable.PasswordEditText_pet_srcIconEditText);
        iconPassword.setImageDrawable(srcIcon);
    }


    private void setBackgroundIconColor(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.PasswordEditText);
        backgroundIconColor = typedArray.getColor(R.styleable.PasswordEditText_pet_backgroundIconColor, Color.GRAY);
        iconPassword.setColorFilter(backgroundIconColor);
    }

    private void setTextSize(AttributeSet set) {
        checkNullSet(set);
        typedArray = getContext().obtainStyledAttributes(set, R.styleable.PasswordEditText);
        textSize = typedArray.getDimension(R.styleable.PasswordEditText_pet_textSize, 18f);
        mainEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }

    private void setFont(Context ctx, AttributeSet attrs) {
        checkNullSet(attrs);
        typedArray = ctx.obtainStyledAttributes(attrs, R.styleable.PasswordEditText);
        fontFamily = typedArray.getString(R.styleable.PasswordEditText_pet_customFontFamily);
        prepareFont(ctx, fontFamily);
        typedArray.recycle();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void doClick() {
        iconPassword.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    iconPassword.setImageResource(R.drawable.ic_password_hide);
                    mainEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mainEditText.setSelection(mainEditText.getText().length()); // to prevent move cursor to the first of text view
                    break;
                case MotionEvent.ACTION_DOWN:
                    iconPassword.setImageResource(R.drawable.ic_password_show);
                    mainEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mainEditText.setSelection(mainEditText.getText().length());
                    break;
            }
            return true;
        });
    }

    private boolean prepareFont(Context ctx, String asset) {
        Typeface tf;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), asset);
        } catch (Exception e) {
            Log.e("TAG", "Could not get typeface: " + e.getMessage());
            return false;
        }
        mainEditText.setTypeface(tf);
        return true;
    }

    private void checkNullSet(AttributeSet set) {
        if (set == null) {
            return;
        }
    }


    public String getText() {
        return mainEditText.getText().toString();
    }

    public int getLength() {
        return mainEditText.length();
    }

    public void setText(String text) {
        mainEditText.setText(text);
    }
}