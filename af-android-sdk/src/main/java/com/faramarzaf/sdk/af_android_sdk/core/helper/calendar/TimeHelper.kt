package com.faramarzaf.sdk.af_android_sdk.core.helper.calendar


import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * @author Faramarz Afzali
 * 23/august/2020
 */
class TimeHelper {


    companion object {

        @JvmStatic
        fun getCurrentDate(yearFormat: String, monthFormat: String, dayFormat: String, monthInCenter: Boolean): String {
            var timeStamp: String? = null
            when (monthInCenter) {
                false -> {
                    timeStamp = SimpleDateFormat("$yearFormat/$dayFormat/$monthFormat").format(Calendar.getInstance().time)
                }

                true -> {
                    timeStamp = SimpleDateFormat("$yearFormat/$monthFormat/$dayFormat").format(Calendar.getInstance().time)

                }
            }
            return timeStamp
        }

        @JvmStatic
        @RequiresApi(Build.VERSION_CODES.O)
        fun getCurrentTime(): String? {
            val dtf = DateTimeFormatter.ofPattern("HH:mm:ss")
            val now = LocalDateTime.now()
            return dtf.format(now)
        }
    }
}