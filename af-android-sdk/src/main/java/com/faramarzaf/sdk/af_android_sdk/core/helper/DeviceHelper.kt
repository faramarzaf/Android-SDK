package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.os.Build

/**
 * @author Faramarz Afzali
 * 11/sep/2020
 */

class DeviceHelper {


    companion object {

        fun getModel(): String {
            return Build.MODEL
        }

        fun getId(): String {
            return Build.ID
        }

        fun getManufacturer(): String {
            return Build.MANUFACTURER
        }

        fun getApiLevel(): String {
            return Build.VERSION.SDK_INT.toString()
        }
    }
}