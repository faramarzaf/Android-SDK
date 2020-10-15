package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.text.TextUtils
import android.util.Patterns

class ValidateHelper {

    companion object {

        @JvmStatic
        fun isValidEmail(target: CharSequence): Boolean {
            return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

}
