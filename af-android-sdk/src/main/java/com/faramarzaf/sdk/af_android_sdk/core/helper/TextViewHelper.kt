package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.graphics.Paint
import android.widget.TextView

class TextViewHelper {


    companion object {

        fun underlineTextView(textView: TextView){
            textView.paintFlags = textView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        }
    }

}