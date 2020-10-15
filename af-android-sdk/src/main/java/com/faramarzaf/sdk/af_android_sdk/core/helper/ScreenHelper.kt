package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.annotation.TargetApi
import android.app.Activity
import android.app.KeyguardManager
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.faramarzaf.sdk.af_android_sdk.core.enums.ScreenOrientation
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.CallbackBrightnessValue
import kotlin.math.pow
import kotlin.math.sqrt

class ScreenHelper {

    companion object {

        @JvmStatic
        fun getScreenSize(context: Context): Double {
            val dm = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(dm)
            val x = (dm.widthPixels / dm.xdpi).toDouble().pow(2.0)
            val y = (dm.heightPixels / dm.ydpi).toDouble().pow(2.0)
            return sqrt(x + y)
        }

        @JvmStatic
        fun getScreenWidth(context: Context): Int {
            return context.resources.displayMetrics.widthPixels
        }

        @JvmStatic
        fun getScreenHeight(context: Context): Int {
            return context.resources.displayMetrics.heightPixels
        }

        @JvmStatic
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun hideToolbar(activity: Activity) {
            val window = activity.window
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }

        /**
         * min brightness 0
         *
         * max brightness 255
         */
        @JvmStatic
        @TargetApi(Build.VERSION_CODES.M)
        @RequiresPermission(android.Manifest.permission.WRITE_SETTINGS)
        fun setBrightness(context: Context, brightness: Int, callback: CallbackBrightnessValue) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.System.canWrite(context)) {
                    val cResolver: ContentResolver = context.contentResolver
                    Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, brightness)
                    if (brightness == 0)
                        callback.minBrightness()
                    else if (brightness == 255)
                        callback.maxBrightness()
                } else {
                    val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
                    intent.data = Uri.parse("package:" + context.packageName)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(intent)
                }
            }
        }

        @JvmStatic
        fun getBrightness(context: Context): Int {
            return Settings.System.getInt(context.contentResolver, Settings.System.SCREEN_BRIGHTNESS)
        }

        @JvmStatic
        fun isLandscape(context: Context): Boolean {
            val orientation = context.resources.configuration.orientation
            return orientation == Configuration.ORIENTATION_LANDSCAPE
        }

        @JvmStatic
        fun isScreenLocked(context: Context): Boolean {
            val myKm: KeyguardManager = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            return myKm.isKeyguardLocked
        }

        @JvmStatic
        fun setOrientation(activity: Activity, screenOrientation: ScreenOrientation) {
            when (screenOrientation) {
                ScreenOrientation.LANDSCAPE -> activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                ScreenOrientation.PORTRAIT -> activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                ScreenOrientation.UNDEFINE -> return
            }
        }

    }
}