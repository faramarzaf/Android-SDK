package com.faramarzaf.sdk.af_android_sdk.core.ui.menu

import android.content.Context
import android.view.View
import androidx.appcompat.widget.PopupMenu
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.CallbackPopUpMenu

class SimpleMenuInflater {

    companion object {
        fun showPopUpMenu(
            context: Context, title: List<String>, view: View, callback: CallbackPopUpMenu) {
            val menu = PopupMenu(context, view)
            for (i in title) {
                menu.menu.add(i)
            }
            menu.setOnMenuItemClickListener {
                callback.onClick(it.title.toString())
                return@setOnMenuItemClickListener true
            }

            menu.show()
        }
    }
}