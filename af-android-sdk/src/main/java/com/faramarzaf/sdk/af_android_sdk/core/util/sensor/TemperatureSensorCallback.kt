package com.faramarzaf.sdk.af_android_sdk.core.util.sensor

interface TemperatureSensorCallback {

    fun sensorNotAvailable(message:String)
    fun sensorAvailable(message:String)
    fun onSensorChanged(value:Float)
}