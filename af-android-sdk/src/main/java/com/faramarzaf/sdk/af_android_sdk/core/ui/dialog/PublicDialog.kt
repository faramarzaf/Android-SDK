package com.faramarzaf.sdk.af_android_sdk.core.ui.dialog

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DialogCallback

class PublicDialog {

    companion object {

        @JvmStatic
        fun yesNoDialog(context: Context, title: String, message: String, textYes: String, textNo: String, icon: Int, callback: DialogCallback) {
            AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(textYes) { dialog, which ->
                    callback.onPositiveButtonClicked()
                }
                .setNegativeButton(textNo) { dialog, which ->
                    callback.onNegativeButtonClicked()
                }
                .setIcon(icon)
                .show()
        }
    }
}