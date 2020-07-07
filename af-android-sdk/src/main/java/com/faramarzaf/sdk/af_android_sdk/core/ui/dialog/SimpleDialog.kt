package com.faramarzaf.sdk.af_android_sdk.core.ui.dialog

import android.content.Context
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.faramarzaf.sdk.af_android_sdk.R
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DialogCallback
import kotlinx.android.synthetic.main.dialog_simple.*

class SimpleDialog(
    var myContext: Context,
    var dialogBgSrc: Int,
    var dialogPosSrc: Int,
    var dialogNegSrc: Int,
    var dialogImageSrc: Int
) : BaseDialog(myContext), View.OnClickListener {


    private var dialogTitle: String? = null
    private var negativeButtonText: String? = null
    private var positiveButtonText: String? = null
    private var dialogText: String? = null
    private var spannableStringBuilder: SpannableStringBuilder? = null
    private var root: LinearLayout? = null
    private var btnPositive: AppCompatButton? = null
    private var btnNegative: AppCompatButton? = null
    private var imageViewDialog: AppCompatImageView? = null

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
        btnPositive = findViewById(R.id.btn_dialog_positive)
        btnNegative = findViewById(R.id.btn_dialog_negative)
        root = findViewById(R.id.rootViewDialogSimple)
        imageViewDialog = findViewById(R.id.imageViewDialogSimple)

        setDialogBackgroundColor(dialogBgSrc)
        setImageBackground(dialogImageSrc)
        setNegativeBackground(dialogNegSrc)
        setPositiveBackground(dialogPosSrc)
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


    private fun setDialogBackgroundColor(color: Int) {
        root?.setBackgroundDrawable(ContextCompat.getDrawable(myContext, color))
    }

    private fun setImageBackground(color: Int) {
        imageViewDialog?.setBackgroundDrawable(ContextCompat.getDrawable(myContext, color))
    }

    private fun setPositiveBackground(color: Int) {
        btnPositive?.setBackgroundDrawable(ContextCompat.getDrawable(myContext, color))
    }

    private fun setNegativeBackground(color: Int) {
        btnNegative?.setBackgroundDrawable(ContextCompat.getDrawable(myContext, color))
    }

    fun setNegativeButton(text: String) = apply { negativeButtonText = text }

    fun setPositiveButton(text: String) = apply { this.positiveButtonText = text }

    fun setText(string: String) = apply { this.dialogText = string }

    fun setCallBack(callback: DialogCallback) = apply {
        this.dialogCallback = callback
    }

    fun showDialog() = apply { show() }

}