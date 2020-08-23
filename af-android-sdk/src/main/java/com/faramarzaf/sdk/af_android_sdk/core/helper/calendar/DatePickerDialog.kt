package com.faramarzaf.sdk.af_android_sdk.core.helper.calendar

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.faramarzaf.sdk.af_android_sdk.core.enums.CalendarType
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.SetDateOnView
import java.util.*

/**
 * @author Faramarz Afzali
 * 13/august/2020
 */

class DatePickerDialog(type: CalendarType, callback: SetDateOnView) : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private val callback: SetDateOnView? = callback
    private val type: CalendarType? = type

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return when (type) {
            CalendarType.DARK -> {
                DatePickerDialog(activity!!, AlertDialog.THEME_DEVICE_DEFAULT_DARK, this, year, month, day)
            }
            CalendarType.LIGHT -> {
                DatePickerDialog(activity!!, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT, this, year, month, day)
            }
            else -> DatePickerDialog(activity!!, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT, this, year, month, day)
        }
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        callback?.setDate(year, month, day)

    }
}