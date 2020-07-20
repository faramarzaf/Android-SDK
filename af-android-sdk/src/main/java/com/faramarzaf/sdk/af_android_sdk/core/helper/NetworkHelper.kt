package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.util.*

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
    }


}