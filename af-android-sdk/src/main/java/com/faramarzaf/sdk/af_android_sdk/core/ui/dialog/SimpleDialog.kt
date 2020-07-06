package com.faramarzaf.sdk.af_android_sdk.core.ui.dialog

import android.content.Context
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import androidx.annotation.StringRes
import com.faramarzaf.sdk.af_android_sdk.R
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DialogCallback
import kotlinx.android.synthetic.main.dialog_simple.*

class SimpleDialog(context: Context) : BaseDialog(context), View.OnClickListener {


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

    fun initViews() {
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

    fun setTitle(text: String) {
        dialogTitle = text
    }

    fun setNegativeButton(@StringRes text: Int, onNegativeButtonClickListener: View.OnClickListener) {
        val string = context.resources.getString(text)
        setNegativeButton(string, onNegativeButtonClickListener)
    }

    fun setNegativeButton(text: String, onNegativeButtonClickListener: View.OnClickListener) {
        negativeButtonText = text
    }

    fun setNegativeButton(@StringRes stringID: Int) {
        negativeButtonText = context.resources.getString(stringID)
    }


    fun setPositiveButton(@StringRes text: Int, onPositiveButtonClickListener: View.OnClickListener) {
        val string = context.resources.getString(text)
        setPositiveButton(string, onPositiveButtonClickListener)
    }

    fun setPositiveButton(@StringRes stringID: Int) {
        positiveButtonText = context.resources.getString(stringID)
    }

    fun setPositiveButton(text: String, onPositiveButtonClickListener: View.OnClickListener) {
        positiveButtonText = text
    }


    fun setText(@StringRes stringID: Int) {
        val string = context.resources.getString(stringID)
        setText(string)
    }

    fun setText(stringBuilder: SpannableStringBuilder) {
        this.spannableStringBuilder = stringBuilder
    }


    fun setNegativeButton(text: String) = apply { negativeButtonText = text }

    fun setPositiveButton(text: String) = apply { this.positiveButtonText = text }

    fun setText(string: String) = apply { this.dialogText = string }

    fun setCallBack(callback: DialogCallback) {
        this.dialogCallback = callback
    }

    fun showDialog() = apply { show() }


}