package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.util.*
import android.os.Build
import android.annotation.TargetApi
import android.provider.Settings

/**
 * @author Faramarz Afzali
 * 3/sep/2020
 */

class NetworkHelper {

    companion object {

        private fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return Objects.requireNonNull(cm).activeNetworkInfo != null && Objects.requireNonNull<NetworkInfo>(cm.activeNetworkInfo).isConnected
        }

        fun checkNetwork(context: Context): Boolean {
            return isNetworkConnected(
                context
            )
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        fun isAirplaneModeOn(context: Context): Boolean {
            return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
                Settings.System.getInt(context.contentResolver, Settings.System.AIRPLANE_MODE_ON, 0) !== 0
            else
                Settings.Global.getInt(context.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) !== 0
        }
    }

}