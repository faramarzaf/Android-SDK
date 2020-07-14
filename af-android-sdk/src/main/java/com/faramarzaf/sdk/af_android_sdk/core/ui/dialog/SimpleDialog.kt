package com.faramarzaf.sdk.af_android_sdk.core.ui.dialog

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.annotation.StringRes
import com.faramarzaf.sdk.af_android_sdk.R
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DialogCallback
import kotlinx.android.synthetic.main.dialog_simple.*

/**
 * @author Faramarz Afzali
 * 6/july/2020
 */


class SimpleDialog(
    context: Context
) : BaseDialog(context), View.OnClickListener {

    private var dialogTitle: String? = null
    private var negativeButtonText: String? = null
    private var positiveButtonText: String? = null
    private var dialogText: String? = null
    private var spannableStringBuilder: SpannableStringBuilder? = null

    override fun getDialogLayout(): Int {
        return R.layout.dialog_simple
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        btn_dialog_positive.setOnClickListener(this)
        btn_dialog_negative.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_dialog_positive -> {
                dismiss()
                if (dialogCallback != null)
                    dialogCallback.onPositiveButtonClicked()
            }
            R.id.btn_dialog_negative -> {
                dismiss()
                if (dialogCallback != null)
                    dialogCallback.onNegativeButtonClicked()
            }
        }
    }

    private fun initViews() {
        if (dialogText != null) {
            txtview_alert_dialog_text.text = dialogText
        } else if (spannableStringBuilder != null) {
            txtview_alert_dialog_text.text = spannableStringBuilder
        }
        if (positiveButtonText != null) {
            btn_dialog_positive.visibility = View.VISIBLE
            btn_dialog_positive.text = positiveButtonText
        } else {
            btn_dialog_positive.visibility = View.GONE
        }
        if (negativeButtonText != null) {
            btn_dialog_negative.visibility = View.VISIBLE
            btn_dialog_negative.text = negativeButtonText
        } else {
            btn_dialog_negative.visibility = View.GONE
        }

    }

    override fun setTitle(@StringRes text: Int) {
        val string = context.resources.getString(text)
        setTitle(string)
    }

    private fun setTitle(text: String) {
        dialogTitle = text
    }

    private fun setNegativeButton(@StringRes text: Int, onNegativeButtonClickListener: View.OnClickListener) {
        val string = context.resources.getString(text)
        setNegativeButton(string, onNegativeButtonClickListener)
    }

    private fun setNegativeButton(
        text: String,
        onNegativeButtonClickListener: View.OnClickListener
    ) {
        negativeButtonText = text
    }

    private fun setNegativeButton(@StringRes stringID: Int) {
        negativeButtonText = context.resources.getString(stringID)
    }


    private fun setPositiveButton(@StringRes text: Int, onPositiveButtonClickListener: View.OnClickListener) {
        val string = context.resources.getString(text)
        setPositiveButton(string, onPositiveButtonClickListener)
    }

    private fun setPositiveButton(@StringRes stringID: Int) {
        positiveButtonText = context.resources.getString(stringID)
    }

    private fun setPositiveButton(
        text: String,
        onPositiveButtonClickListener: View.OnClickListener
    ) {
        positiveButtonText = text
    }


    private fun setText(@StringRes stringID: Int) {
        val string = context.resources.getString(stringID)
        setText(string)
    }

    private fun setText(stringBuilder: SpannableStringBuilder) {
        this.spannableStringBuilder = stringBuilder
    }


    fun setImageDialogBackground(color: Int) = apply {
        imageViewDialogSimple?.setBackgroundResource(color)
    }

    fun setDialogBackground(color: Int) = apply {
        rootViewDialogSimple?.setBackgroundResource(color)
    }

    fun setPositiveBackground(color: Int, textColor: Int) = apply {
        btn_dialog_positive?.setBackgroundResource(color)
        btn_dialog_positive.setTextColor(textColor)
    }

    fun setNegativeBackground(color: Int, textColor: Int) = apply {
        btn_dialog_negative?.setBackgroundResource(color)
        btn_dialog_negative.setTextColor(textColor)
    }


    fun setNegativeButton(text: String) = apply { negativeButtonText = text }

    fun setPositiveButton(text: String) = apply { this.positiveButtonText = text }

    fun setText(string: String) = apply { this.dialogText = string }

    fun setCallBack(callback: DialogCallback) = apply {
        this.dialogCallback = callback
    }

    fun cancelable(cancelable: Boolean) = apply {
        if (cancelable) {
            setCancelable(true)
            setCanceledOnTouchOutside(true)
        } else {
            setCancelable(false)
            setCanceledOnTouchOutside(false)
        }
    }

    fun setTitleColor(color: Int) = apply {
        txtview_alert_dialog_text.setTextColor(color)
    }

    fun showDialog() = apply {
        super.show()
    }

    fun setTypeface(asset: String) = apply {
        var tf: Typeface? = null
        try {
            tf = Typeface.createFromAsset(this.context.assets, asset)
        } catch (e: Exception) {
            Log.e(
                "***SimpleDialog***",
                "Could not get typeface: ${e.message} place your custom fonts in assets folder"
            )
        }
        txtview_alert_dialog_text.typeface = tf
        btn_dialog_positive.typeface = tf
        btn_dialog_negative.typeface = tf
    }

    fun setTextSize(sizeTitle: Float, titleButtons: Float) = apply {
        txtview_alert_dialog_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeTitle)
        btn_dialog_positive.setTextSize(TypedValue.COMPLEX_UNIT_SP, titleButtons)
        btn_dialog_negative.setTextSize(TypedValue.COMPLEX_UNIT_SP, titleButtons)
    }

}