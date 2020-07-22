package com.faramarzaf.sdk.af_android_sdk.core.ui.customview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import com.faramarzaf.sdk.af_android_sdk.R

/**
 * @author Faramarz Afzali
 * 22/july/2020
 */

class PasswordEditText : LinearLayout {

    private var myRootView: View? = null
    private var typedArray: TypedArray? = null
    private var iconPassword: ImageView? = null
    private var mainEditText: EditText? = null
    private var srcIconHide: Drawable? = null
    private var srcIconShow: Drawable? = null
    private var defaultTextColor: Int = 0
    private var backgroundIconColor: Int = 0
    private var textSize: Float = 0.toFloat()
    private var hint: String? = null
    private var fontFamily: String? = null


    var text: String
        get() = mainEditText!!.text.toString()
        set(text) = mainEditText!!.setText(text)

    val length: Int
        get() = mainEditText!!.length()


    constructor(context: Context) : super(context) {
        init(context)
        doClick()
    }


    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
        setHint(attrs)
        setIconShowResource(attrs)
        setIconHideResource(attrs)
        setBackgroundIconColor(attrs)
        setTextSize(attrs)
        setTextColor(attrs)
        setFont(context, attrs)
        doClick()
    }


    private fun init(context: Context) {
        isSaveEnabled = true
        myRootView = View.inflate(context, R.layout.layout_password_edittext, this)
        iconPassword = myRootView!!.findViewById(R.id.iconPassword)
        mainEditText = myRootView!!.findViewById(R.id.mainEditText)
    }


    private fun setHint(set: AttributeSet?) {
        checkNullSet(set)
        typedArray = context.obtainStyledAttributes(set, R.styleable.PasswordEditText)
        hint = typedArray!!.getString(R.styleable.PasswordEditText_pet_hint)
        mainEditText!!.hint = hint
        typedArray!!.recycle()
    }

    private fun setTextColor(set: AttributeSet?) {
        checkNullSet(set)
        typedArray = context.obtainStyledAttributes(set, R.styleable.PasswordEditText)
        defaultTextColor = typedArray!!.getInt(R.styleable.PasswordEditText_pet_textColor, Color.BLACK)
        mainEditText!!.setTextColor(defaultTextColor)
        typedArray!!.recycle()
    }

    private fun setIconShowResource(set: AttributeSet?) {
        checkNullSet(set)
        typedArray = context.obtainStyledAttributes(set, R.styleable.PasswordEditText)
        srcIconShow = typedArray!!.getDrawable(R.styleable.PasswordEditText_pet_srcIconShow)
        iconPassword!!.setImageDrawable(srcIconShow)
    }

    private fun setIconHideResource(set: AttributeSet?) {
        checkNullSet(set)
        typedArray = context.obtainStyledAttributes(set, R.styleable.PasswordEditText)
        srcIconHide = typedArray!!.getDrawable(R.styleable.PasswordEditText_pet_srcIconHide)
        iconPassword!!.setImageDrawable(srcIconHide)
    }

    private fun setBackgroundIconColor(set: AttributeSet?) {
        checkNullSet(set)
        typedArray = context.obtainStyledAttributes(set, R.styleable.PasswordEditText)
        backgroundIconColor = typedArray!!.getColor(R.styleable.PasswordEditText_pet_backgroundIconColor, Color.GRAY)
        iconPassword!!.setColorFilter(backgroundIconColor)
    }

    private fun setTextSize(set: AttributeSet?) {
        checkNullSet(set)
        typedArray = context.obtainStyledAttributes(set, R.styleable.PasswordEditText)
        textSize = typedArray!!.getDimension(R.styleable.PasswordEditText_pet_textSize, 18f)
        mainEditText!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
    }

    private fun setFont(ctx: Context, attrs: AttributeSet?) {
        checkNullSet(attrs)
        typedArray = ctx.obtainStyledAttributes(attrs, R.styleable.PasswordEditText)
        fontFamily = typedArray!!.getString(R.styleable.PasswordEditText_pet_customFontFamily)
        prepareFont(ctx, fontFamily)
        typedArray!!.recycle()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun doClick() {
        iconPassword!!.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_UP -> {
                    iconPassword!!.setImageDrawable(srcIconHide)
                    mainEditText!!.transformationMethod = PasswordTransformationMethod.getInstance()
                    mainEditText!!.setSelection(mainEditText!!.text.length) // to prevent move cursor to the first of text view
                }
                MotionEvent.ACTION_DOWN -> {
                    iconPassword!!.setImageDrawable(srcIconShow)
                    mainEditText!!.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    mainEditText!!.setSelection(mainEditText!!.text.length)
                }
            }
            true
        }
    }

    private fun prepareFont(ctx: Context, asset: String?): Boolean {
        val tf: Typeface
        try {
            tf = Typeface.createFromAsset(ctx.assets, asset)
        } catch (e: Exception) {
            Log.e("TAG", "Could not get typeface: " + e.message)
            return false
        }

        mainEditText!!.typeface = tf
        return true
    }

    private fun checkNullSet(set: AttributeSet?) {
        if (set == null) {
            return
        }
    }
}