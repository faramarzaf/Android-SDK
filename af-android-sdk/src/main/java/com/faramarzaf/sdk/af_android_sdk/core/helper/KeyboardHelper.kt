package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager


class KeyboardHelper {

    companion object {

        @JvmStatic
        fun closeKeyboard(activity: Activity) {
            var imm: InputMethodManager? = null
            var view: View? = null
            try {
                imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                view = activity.currentFocus
                if (view == null) {
                    view = View(activity)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            imm?.hideSoftInputFromWindow(view?.windowToken, 0)
        }

        @JvmStatic
        fun hideKeyboardTouchOutSide(activity: Activity): View.OnFocusChangeListener {
            return View.OnFocusChangeListener { view, focus ->
                if (!focus) {
                    closeKeyboard(
                        activity
                    )
                }
            }
        }

    }
}