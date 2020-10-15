package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation

class AnimationHelper {
    companion object {

        @JvmStatic
        fun shakeAnimation(fromX: Float, toX: Float, fromY: Float, toY: Float, duration: Long, cylcles: Float, view: View) {
            val shake = TranslateAnimation(fromX, toX, fromY, toY)
            shake.duration = duration
            shake.interpolator = CycleInterpolator(cylcles)
            view.startAnimation(shake)
        }

        @JvmStatic
        fun objectAnimator(view: View, duration: Long, values: Float) {
            val objectAnimatorX = ObjectAnimator.ofFloat(view, "scaleX", values)
            val objectAnimatorY = ObjectAnimator.ofFloat(view, "scaleY", values)
            objectAnimatorX.duration = duration
            objectAnimatorY.duration = duration
            objectAnimatorX.start()
            objectAnimatorY.start()
        }

    }
}