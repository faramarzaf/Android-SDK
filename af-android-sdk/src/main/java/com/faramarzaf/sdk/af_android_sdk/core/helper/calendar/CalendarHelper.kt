package com.faramarzaf.sdk.af_android_sdk.core.helper.calendar

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.faramarzaf.sdk.af_android_sdk.core.enums.CalendarType
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.CalendarCallBack
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.SetDateOnView

/**
 * @author Faramarz Afzali
 * 13/august/2020
 */

class CalendarHelper {


    companion object {
        private var dialogFragment: DialogFragment? = null

        @JvmStatic
        fun showDialog(activity: FragmentActivity, type: CalendarType, callback: CalendarCallBack) {
            val call: CalendarCallBack? = callback
            dialogFragment = DatePickerDialog(type, object : SetDateOnView {
                override fun setDate(year: Int, month: Int, day: Int) {
                    call?.setDate(year, month, day)
                }
            })

            (dialogFragment as DatePickerDialog).show(activity.supportFragmentManager, "Tag1")

        }
    }
}