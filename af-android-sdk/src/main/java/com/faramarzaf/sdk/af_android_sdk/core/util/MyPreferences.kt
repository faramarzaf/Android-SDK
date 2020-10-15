package com.faramarzaf.sdk.af_android_sdk.core.util

import android.content.Context
import android.content.SharedPreferences

/**
 * @author Faramarz Afzali
 * 14/jun/2020
 */


class MyPreferences {

    companion object Prefs {

        private const val PREF_NAME: String = "SharedPreferences"
        private const val mode: Int = Context.MODE_PRIVATE

        @JvmStatic
        fun writeBoolean(context: Context, key: String, value: Boolean) {
            getEditor(context).putBoolean(key, value).commit()
        }

        @JvmStatic
        fun readBoolean(context: Context, key: String, defValue: Boolean): Boolean {
            return getPreferences(context).getBoolean(key, defValue)
        }

        @JvmStatic
        fun writeInteger(context: Context, key: String, value: Int) {
            getEditor(context).putInt(key, value).commit()
        }

        @JvmStatic
        fun readInteger(context: Context, key: String, defValue: Int): Int {
            return getPreferences(context).getInt(key, defValue)
        }

        @JvmStatic
        fun writeString(context: Context, key: String, value: String) {
            getEditor(context).putString(key, value).commit()
        }

        @JvmStatic
        fun readString(context: Context, key: String, defValue: String): String {
            return getPreferences(context).getString(key, defValue).toString()
        }

        @JvmStatic
        fun writeFloat(context: Context, key: String, value: Float) {
            getEditor(context).putFloat(key, value).commit()
        }

        @JvmStatic
        fun readFloat(context: Context, key: String, defValue: Float): Float {
            return getPreferences(context).getFloat(key, defValue)
        }

        @JvmStatic
        fun writeLong(context: Context, key: String, value: Long) {
            getEditor(context).putLong(key, value).commit()
        }

        @JvmStatic
        fun readLong(context: Context, key: String, defValue: Long): Long {
            return getPreferences(context).getLong(key, defValue)
        }

        @JvmStatic
        fun clearAll(context: Context) {
            getEditor(context).clear().commit()
        }

        @JvmStatic
        fun clear(context: Context, key: String) {
            getPreferences(context).edit().remove(key).apply()
        }

        private fun getPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREF_NAME, mode)
        }

        private fun getEditor(context: Context): SharedPreferences.Editor {
            return getPreferences(context).edit()
        }
    }
}