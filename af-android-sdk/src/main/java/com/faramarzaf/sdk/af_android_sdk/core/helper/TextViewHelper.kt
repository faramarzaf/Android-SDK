package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.graphics.Paint
import android.os.Build
import android.text.Layout.JUSTIFICATION_MODE_INTER_WORD
import android.widget.TextView
import androidx.annotation.RequiresApi

class TextViewHelper {


    companion object {

        @JvmStatic
        fun underlineTextView(textView: TextView) {
            textView.paintFlags = textView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        }

        @JvmStatic
        @RequiresApi(Build.VERSION_CODES.O)
        fun justifyTextView(textView: TextView) {
            textView.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }
    }

}