package com.faramarzaf.sdk.af_android_sdk.core.util.sensor

import android.content.Context

class SensorUtility {

    companion object {

        @JvmStatic
        fun getTypeTemperatureSensor(context: Context, callback: TemperatureSensorCallback) {
            val temperatureSensor = TemperatureSensor(callback)
            temperatureSensor.bindTypeTemperatureSensor(context)
        }

        @JvmStatic
        fun getTypeAmbientTemperatureSensor(context: Context, callback: TemperatureSensorCallback) {
            val temperatureSensor = TemperatureSensor(callback)
            temperatureSensor.bindTypeAmbientTemperatureSensor(context)
        }


    }


}