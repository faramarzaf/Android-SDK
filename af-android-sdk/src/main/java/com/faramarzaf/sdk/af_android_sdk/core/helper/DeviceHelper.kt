package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import kotlin.math.sqrt


/**
 * @author Faramarz Afzali
 * 11/sep/2020
 */

class DeviceHelper {


    companion object {

        @JvmStatic
        fun getModel(): String {
            return Build.MODEL
        }

        @JvmStatic
        fun getId(): String {
            return Build.ID
        }

        @JvmStatic
        fun getManufacturer(): String {
            return Build.MANUFACTURER
        }

        @JvmStatic
        fun getApiLevel(): String {
            return Build.VERSION.SDK_INT.toString()
        }

        @JvmStatic
        fun isTablet(activity: Activity): Boolean {
            val metrics = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(metrics)
            val yInches = metrics.heightPixels / metrics.ydpi
            val xInches = metrics.widthPixels / metrics.xdpi
            val diagonalInches = sqrt(xInches * xInches + yInches * yInches.toDouble())
            return diagonalInches >= 6.5
        }
    }
}