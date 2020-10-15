package com.faramarzaf.sdk.af_android_sdk.core.util

import android.os.SystemClock
import android.view.View
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DoGuardTask
/**
 * @author Faramarz Afzali
 * 22/June/2020
 * <p>
 * This class is supposed to prevent fast and rapid End-user's clicks on views
 * <p>
 */

class ClickGuard {


    companion object {
        private var mLastClickTime: Long = 0

        @JvmStatic
        fun guardView(view: View, delay: Long, callback: DoGuardTask) {
            view.setOnClickListener { v ->
                if (SystemClock.elapsedRealtime() - mLastClickTime < delay) {
                    return@setOnClickListener
                }
                mLastClickTime = SystemClock.elapsedRealtime()
                callback.onGuard(v)
            }
        }

        @JvmStatic
        fun guardView(view: List<View>, delay: Long, doGuardTask: DoGuardTask?) {
            for (i in view.indices) {
                view[i].setOnClickListener(View.OnClickListener { v ->
                    if (SystemClock.elapsedRealtime() - mLastClickTime < delay) {
                        return@OnClickListener
                    }
                    mLastClickTime = SystemClock.elapsedRealtime()
                    doGuardTask?.onGuard(v)
                })
            }
        }
    }
}