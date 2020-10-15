package com.faramarzaf.sdk.af_android_sdk.core.helper

import java.security.SecureRandom
import java.text.DecimalFormat

class StringHelper {

    companion object {
        private val persianNumbers = arrayOf("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹")

        @JvmStatic
        fun convertStringToInteger(value: String): Int {
            try {
                return Integer.parseInt(value)
            } catch (ex: Exception) {
                return 0
            }
        }

        @JvmStatic
        fun stringIsEmptyOrNull(string: String?): Boolean {
            try {
                return string == null || string.length == 0 || string.isEmpty() || string == "null" || string == ""
            } catch (ex: Exception) {
                return false
            }
        }

        @JvmStatic
        fun toEnglishNum(s: String): String {
            var s = s

            s = s.replace("١", "1")
            s = s.replace("٢", "2")
            s = s.replace("۲", "2")
            s = s.replace("٣", "3")
            s = s.replace("۳", "3")
            s = s.replace("٤", "4")
            s = s.replace("۴", "4")
            s = s.replace("۵", "5")
            s = s.replace("۶", "6")
            s = s.replace("۷", "7")
            s = s.replace("۸", "8")
            s = s.replace("۹", "9")
            s = s.replace("۰", "0")
            return s
        }

        @JvmStatic
        fun toPersianNumber(text: String): String {
            if (text.length == 0) {
                return ""
            }
            var out = ""
            val length = text.length
            for (i in 0 until length) {
                val c = text[i]
                if ('0' <= c && c <= '9') {
                    val number = Integer.parseInt(c.toString())
                    out += persianNumbers[number]
                } else if (c == '٫') {
                    out += '،'.toString()
                } else {
                    out += c
                }
            }
            return out
        }

        @JvmStatic
        fun getEnglishDurationString(seconds: Long): String {
            var seconds = seconds
            val hours = seconds / 3600
            val minutes = seconds % 3600 / 60
            seconds = seconds % 60
            return twoDigitString(minutes) + " : " + twoDigitString(seconds)
        }

        @JvmStatic
        fun getFarsiDurationString(seconds: Long): String {
            var seconds = seconds
            val hours = seconds / 3600
            val minutes = seconds % 3600 / 60
            seconds = seconds % 60
            return toPersianNumber(twoDigitString(minutes) + " : " + twoDigitString(seconds))
        }

        @JvmStatic
        fun twoDigitString(number: Long): String {
            if (number == 0L) {
                return "۰۰"
            }
            return if (number / 10 == 0L) {
                "۰$number"
            } else number.toString()
        }

        @JvmStatic
        fun randomString(length: Int): String {
            val root = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            val rand = SecureRandom()
            val sb = StringBuilder(length)
            for (i in 0 until length) {
                val index = (root.length * Math.random()).toInt()
                sb.append(root[index])
            }
            sb.append(root[rand.nextInt(root.length)])
            return sb.toString()
        }

        @JvmStatic
        fun tripleSplitter(number: Long): String {
            return DecimalFormat("###,###,###").format(number)
        }
    }
}