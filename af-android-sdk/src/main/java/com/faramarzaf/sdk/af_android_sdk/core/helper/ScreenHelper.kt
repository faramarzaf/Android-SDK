package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi

class ScreenHelper {

    companion object {


        //region screen method
        fun getScreenSize(context: Context): Double {
            val dm = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(dm)
            val x = Math.pow((dm.widthPixels / dm.xdpi).toDouble(), 2.0)
            val y = Math.pow((dm.heightPixels / dm.ydpi).toDouble(), 2.0)
            return Math.sqrt(x + y)
        }

        fun getScreenWidth(context: Context): Int {
            return context.resources.displayMetrics.widthPixels
        }

        fun getScreenHeight(context: Context): Int {
            return context.resources.displayMetrics.heightPixels
        }

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun hideToolbar(activity: Activity) {
            val window = activity.window
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }
}
