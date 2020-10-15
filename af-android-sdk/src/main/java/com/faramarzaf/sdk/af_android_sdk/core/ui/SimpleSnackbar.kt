package com.faramarzaf.sdk.af_android_sdk.core.ui

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

        private lateinit var snackbar: Snackbar
        private lateinit var enum: EnumSnackBar
        /**
         *Simple snackbar without action just include text
         */

        @JvmStatic
        fun show(view: View, text: String, backgroundColor: Int, textColor: Int, isShortTime: Boolean) {

            if (isShortTime)
                enum = EnumSnackBar[EnumSnackBar.SHORT.value]
            else
                enum = EnumSnackBar[EnumSnackBar.LONG.value]

            snackbar = Snackbar.make(view, text, enum.value)
            val snackBarRootView = snackbar.view
            val snackbarText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackBarRootView.setBackgroundColor(backgroundColor)
            snackbarText.setTextColor(textColor)
            snackbar.show()
        }

        /**
         *Simple snackbar with font preferences
         */
        @JvmStatic
        fun show(context: Context, view: View, text: String, asset: String, backgroundColor: Int, textColor: Int, isShortTime: Boolean) {

            if (isShortTime)
                enum = EnumSnackBar[EnumSnackBar.SHORT.value]
            else
                enum = EnumSnackBar[EnumSnackBar.LONG.value]

            snackbar = Snackbar.make(view, text, enum.value)
            val snackBarRootView = snackbar.view
            val snackbarText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            val snackbarActionText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_action)
            prepareFont(context, asset, snackbarText, snackbarActionText)
            snackBarRootView.setBackgroundColor(backgroundColor)
            snackbarText.setTextColor(textColor)
            snackbar.show()
        }

        /**
         *Snackbar with action and callBack
         */
        @JvmStatic
        fun show(view: View, text: String, textAction: String, backgroundColor: Int, textColor: Int, textActionColor: Int, isShortTime: Boolean, callback: CallbackSnackBar) {

            if (isShortTime)
                enum = EnumSnackBar[EnumSnackBar.SHORT.value]
            else
                enum = EnumSnackBar[EnumSnackBar.LONG.value]

            snackbar = Snackbar.make(view, text, enum.value)
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

        /**
         *Snackbar with font preferences
         */
        @JvmStatic
        fun show(context: Context, view: View, text: String, textAction: String, backgroundColor: Int, textColor: Int, textActionColor: Int, asset: String, isShortTime: Boolean, callback: CallbackSnackBar) {

            if (isShortTime)
                enum = EnumSnackBar[EnumSnackBar.SHORT.value]
            else
                enum = EnumSnackBar[EnumSnackBar.LONG.value]

            snackbar = Snackbar.make(view, text, enum.value)
            val snackBarRootView = snackbar.view
            val snackbarText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            val snackbarActionText = snackBarRootView.findViewById<TextView>(com.google.android.material.R.id.snackbar_action)
            prepareFont(context, asset, snackbarText, snackbarActionText)
            snackBarRootView.setBackgroundColor(backgroundColor)
            snackbarText.setTextColor(textColor)
            snackbarActionText.setTextColor(textActionColor)

            snackbar.setAction(textAction) {
                callback.onActionClick()
            }
            snackbar.show()
        }

        private fun prepareFont(context: Context, asset: String, snackbarText: TextView, snackbarActionText: TextView) {
            try {
                val typeface: Typeface = Typeface.createFromAsset(context.assets, asset)
                snackbarText.typeface = typeface
                snackbarActionText.typeface = typeface
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}