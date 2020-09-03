package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.content.Context
import android.content.Context.BATTERY_SERVICE
import android.content.Context.POWER_SERVICE
import android.os.BatteryManager
import android.os.Build
import android.os.PowerManager
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.BatterySaveModeCallback
import java.util.*

/**
 * @author Faramarz Afzali
 * 3/sep/2020
 */

class BatteryHelper(private val context: Context) {

    fun checkSaveMode(callback: BatterySaveModeCallback) {
        val powerManager = context.getSystemService(POWER_SERVICE) as PowerManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && Objects.requireNonNull(powerManager)!!.isPowerSaveMode)
            callback.saveModeOn()
        else
            callback.saveModeOff()
    }

    fun getBatteryLevel(): Int {
        val bm = context.getSystemService(BATTERY_SERVICE) as BatteryManager?
        return Objects.requireNonNull(bm)!!.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
    }

}