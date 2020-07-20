package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import com.faramarzaf.sdk.af_android_sdk.core.enums.EnumSnackBar
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.CallbackSnackBar
import com.google.android.material.snackbar.Snackbar

/**
 * @author Faramarz Afzali
 * 20/july/2020
 */

class SimpleSnackbar {


    companion object {


        fun show(view: View, text: String, backgroundColor: Int, textColor: Int, isShortTime: Boolean) {
            val enum: Int?
            if (isShortTime)
                enum = EnumSnackBar.SHORT.value
            else
                enum = EnumSnackBar.LONG.value
            val snackbar = Snackbar.make(view, text, enum)
            val snackBarRootView = snackbar.view
            val snackbarText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackBarRootView.setBackgroundColor(backgroundColor)
            snackbarText.setTextColor(textColor)
            snackbar.show()
        }

        fun show(view: View, text: String, textAction: String, backgroundColor: Int, textColor: Int, textActionColor: Int, isShortTime: Boolean, callback: CallbackSnackBar) {
            val enum: Int?
            if (isShortTime)
                enum = EnumSnackBar.SHORT.value
            else
                enum = EnumSnackBar.LONG.value

            val snackbar = Snackbar.make(view, text, enum)
            val snackBarRootView = snackbar.view
            val snackbarText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            val snackbarActionText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_action)
            snackBarRootView.setBackgroundColor(backgroundColor)
            snackbarText.setTextColor(textColor)
            snackbarActionText.setTextColor(textActionColor)

            snackbar.setAction(textAction) {
                callback.onActionClick()
            }
            snackbar.show()
        }


        fun show(context: Context, view: View, text: String, textAction: String, backgroundColor: Int, textColor: Int, textActionColor: Int, asset: String, isShortTime: Boolean, callback: CallbackSnackBar) {
            val enum: Int?
            if (isShortTime)
                enum = EnumSnackBar.SHORT.value
            else
                enum = EnumSnackBar.LONG.value

            val snackbar = Snackbar.make(view, text, enum)
            val snackBarRootView = snackbar.view
            val snackbarText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            val snackbarActionText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_action)

            try {
                val typeface: Typeface = Typeface.createFromAsset(context.assets, asset)
                snackbarText.typeface = typeface
                snackbarActionText.typeface = typeface
            } catch (e: Exception) {
                e.printStackTrace()
            }
            snackBarRootView.setBackgroundColor(backgroundColor)
            snackbarText.setTextColor(textColor)
            snackbarActionText.setTextColor(textActionColor)

            snackbar.setAction(textAction) {
                callback.onActionClick()
            }
            snackbar.show()
        }


    }

}