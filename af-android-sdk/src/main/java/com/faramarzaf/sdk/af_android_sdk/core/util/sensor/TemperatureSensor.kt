package com.faramarzaf.sdk.af_android_sdk.core.util.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class TemperatureSensor(private val callback: TemperatureSensorCallback) {


      fun bindTypeTemperatureSensor(context: Context) {
        val mySensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val temperatureSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE)
        if (temperatureSensor != null) {
            callback.sensorAvailable("Sensor.TYPE_TEMPERATURE Available")
            mySensorManager.registerListener(TemperatureSensorListener, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL)
        } else
            callback.sensorNotAvailable("Sensor.TYPE_TEMPERATURE NOT Available")
    }

      fun bindTypeAmbientTemperatureSensor(context: Context) {
        val mySensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val ambientTemperatureSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        if (ambientTemperatureSensor != null) {
            callback.sensorAvailable("Sensor.TYPE_AMBIENT_TEMPERATURE Available")
            mySensorManager.registerListener(AmbientTemperatureSensorListener, ambientTemperatureSensor, SensorManager.SENSOR_DELAY_NORMAL)
        } else {
            callback.sensorNotAvailable("Sensor.TYPE_AMBIENT_TEMPERATURE NOT Available")
        }
    }

    private val TemperatureSensorListener: SensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {

        }

        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_TEMPERATURE) {
                callback.onSensorChanged(event.values[0])
            }
        }
    }

    private val AmbientTemperatureSensorListener: SensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {

        }

        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
                callback.onSensorChanged(event.values[0])
            }
        }
    }

}