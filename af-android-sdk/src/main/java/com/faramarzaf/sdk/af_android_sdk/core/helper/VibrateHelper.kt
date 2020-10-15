package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import java.util.*

class VibrateHelper {
    companion object {

        @JvmStatic
        fun vibrate(context: Context, duration: Long) {
            val vibe = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Objects.requireNonNull(vibe).vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                //deprecated in API 26
                Objects.requireNonNull(vibe).vibrate(duration)
            }
        }

    }
}