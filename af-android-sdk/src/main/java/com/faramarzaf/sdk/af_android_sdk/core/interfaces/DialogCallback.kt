package com.faramarzaf.sdk.af_android_sdk.core.interfaces

interface DialogCallback {
    fun onPositiveButtonClicked()
    fun onPositiveButtonClicked(text: String)
    fun onNegativeButtonClicked()
}