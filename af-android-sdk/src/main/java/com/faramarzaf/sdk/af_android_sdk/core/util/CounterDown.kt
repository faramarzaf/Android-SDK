package com.faramarzaf.sdk.af_android_sdk.core.util


import android.os.CountDownTimer
import android.widget.TextView
import com.faramarzaf.sdk.af_android_sdk.core.helper.StringHelper

/**
 * @author Faramarz Afzali
 * 10/july/2020
 */

class CounterDown {

    companion object {
        private lateinit var countDownTimer: CountDownTimer
        private lateinit var message: String

        @JvmStatic
        fun printer(duration: Long, interval: Long, textView: TextView, disableColor: Int, enableColor: Int, retrySentence: String, farsiTimer: Boolean) {
            textView.isEnabled = false
            textView.setTextColor(disableColor)
            countDownTimer = object : CountDownTimer(duration, interval) {
                override fun onTick(millisUntilFinished: Long) {
                    if (farsiTimer) {
                        message = StringHelper.getFarsiDurationString(millisUntilFinished / 1000)
                    } else {
                        message = StringHelper.getEnglishDurationString(millisUntilFinished / 1000)
                    }
                    textView.text = message
                }

                override fun onFinish() {
                    textView.text = retrySentence
                    textView.isEnabled = true
                    textView.setTextColor(enableColor)
                }
            }
            countDownTimer.start()
        }
    }
}