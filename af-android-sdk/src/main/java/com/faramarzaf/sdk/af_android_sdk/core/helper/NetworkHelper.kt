package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.Manifest
import android.annotation.TargetApi
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresPermission
import java.util.*


class NetworkHelper {

    companion object {

        private fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return Objects.requireNonNull(cm).activeNetworkInfo != null && Objects.requireNonNull<NetworkInfo>(cm.activeNetworkInfo).isConnected
        }

        @JvmStatic
        fun checkNetwork(context: Context): Boolean {
            return isNetworkConnected(context)
        }

        @JvmStatic
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        fun isAirplaneModeOn(context: Context): Boolean {
            return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
                Settings.System.getInt(context.contentResolver, Settings.System.AIRPLANE_MODE_ON, 0) !== 0
            else
                Settings.Global.getInt(context.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) !== 0
        }

        @JvmStatic
        @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
        fun getNetworkType(context: Context): String {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo: List<NetworkInfo> = connectivityManager.allNetworkInfo.toList()
            for (info in networkInfo) {
                if (info.typeName.equals("WIFI", true))
                    if (info.isConnected)
                        return "Wifi"
                    else if (info.typeName.equals("MOBILE", true))
                        if (info.isConnected)
                            return "Mobile data"
            }
            return ""
        }
    }
}