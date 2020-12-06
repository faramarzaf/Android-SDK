package com.faramarzaf.sdk.af_android_sdk.core.ui

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.faramarzaf.sdk.af_android_sdk.core.helper.StringHelper.Companion.stringIsEmptyOrNull

/**
 * @author Faramarz Afzali
 * 28/oct/2020
 */

class ToastHelper private constructor() {

    private var icon = 0
    private var duration = 0
    private var floatX = 0
    private var floatY = 0
    private var padding = 0
    private var bgColor = 0
    private var gravity = 0
    private var textSize = 0
    private var mImageSize = 0
    private var textColor: String? = null
    private var message: String? = null
    private var context: Context? = null
    private var mToast: Toast? = null
    private var mLayout: LinearLayout? = null
    private var mImageView: ImageView? = null
    private var mTxtContent: TextView? = null

    class Builder(context: Context?) {
        private var toast = ToastHelper()
        fun setMessage(message: String?): Builder {
            toast.message = message
            return this
        }

        fun setGravity(gravity: Int): Builder {
            toast.gravity = gravity
            return this
        }

        fun setIcon(icon: Int): Builder {
            toast.icon = icon
            return this
        }

        fun setTextColor(textColor: String?): Builder {
            toast.textColor = textColor
            return this
        }

        fun setTextSize(textSize: Int): Builder {
            toast.textSize = textSize
            return this
        }

        fun setImageSize(imageSize: Int): Builder {
            toast.mImageSize = imageSize
            return this
        }

        fun setBackgroundColor(bgColor: Int): Builder {
            toast.bgColor = bgColor
            return this
        }

        fun setPadding(padding: Int): Builder {
            toast.padding = padding
            return this
        }

        fun build(): ToastHelper {
            toast.setLayoutView()
            return toast
        }

        init {
            toast.context = context
        }
    }

    fun setLayoutView() {
        mToast = Toast(context)
        mImageView = ImageView(context)

        val lParams = LinearLayout.LayoutParams(mImageSize, mImageSize)
        val lParams1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        mImageView!!.setImageResource(icon)
        lParams.gravity = Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL
        lParams.setMargins(5, 5, 5, 5)
        mImageView!!.layoutParams = lParams
        mTxtContent = TextView(context)
        if (!stringIsEmptyOrNull(textColor))
            mTxtContent!!.setTextColor(Color.parseColor(textColor))
        if (textSize != 0)
            mTxtContent!!.textSize = textSize.toFloat()
        mTxtContent!!.layoutParams = lParams1
        mLayout = LinearLayout(context)
        mLayout!!.orientation = LinearLayout.HORIZONTAL
        mLayout!!.layoutParams = params
        mLayout!!.addView(mImageView)
        mLayout!!.addView(mTxtContent)


        if (bgColor != 0)
            mLayout!!.setBackgroundResource(bgColor)
        if (padding != 0)
            mLayout!!.setPadding(padding, padding, padding, padding)
        if (gravity != 0)
            mToast!!.setGravity(gravity, floatX, floatY)

        mToast!!.view = mLayout
        if (duration != 0)
            mToast!!.duration = duration
        if (!stringIsEmptyOrNull(message))
            mTxtContent!!.text = message
        mToast!!.show()
    }
}