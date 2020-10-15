package com.faramarzaf.sdk.af_android_sdk.core.ui.menu

import android.content.Context
import android.view.View
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.appcompat.widget.PopupMenu
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.CallbackPopUpMenu

/**
 * @author Faramarz Afzali
 * 8/july/2020
 */

class SimpleMenuInflater {

    companion object {

        @JvmStatic
        fun showPopUpMenu(context: Context, title: List<String>, view: View, callback: CallbackPopUpMenu) {
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

        @JvmStatic
        fun iconPopUpMenu(context: Context, view: View, layoutMenu: Int, callback: CallbackPopUpMenu) {
            val menu = PopupMenu(context, view)
            menu.inflate(layoutMenu)
            menu.setOnMenuItemClickListener {
                callback.onClick(it.title.toString())
                return@setOnMenuItemClickListener true
            }
            val menuHelper = MenuPopupHelper(context, menu.menu as MenuBuilder, view)
            menuHelper.setForceShowIcon(true)
            menuHelper.show()
        }
    }
}