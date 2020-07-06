package com.faramarzaf.sdk.af_android_sdk.core.helper

class StringHelper {

    companion object {
        private val persianNumbers = arrayOf("۰", "۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹")

        fun convertStringToInteger(value: String): Int {
            try {
                return Integer.parseInt(value)
            } catch (ex: Exception) {
                return 0
            }

        }


        fun StringIsEmptyOrNull(string: String?): Boolean {
            try {
                return string == null || string.length == 0 || string.isEmpty() || string == "null" || string == ""
            } catch (ex: Exception) {
                return false
            }

        }

        //region change Number language
        fun toEnglishNum(s: String): String {
            var s = s
            val cApple: Char = 217.toChar()
            val cNokia: Char = 219.toChar()

            s = s.replace(String(charArrayOf(cApple, 160.toChar())), "0")
            s = s.replace(String(charArrayOf(cApple, 161.toChar())), "1")
            s = s.replace(String(charArrayOf(cApple, 162.toChar())), "2")
            s = s.replace(String(charArrayOf(cApple, 163.toChar())), "3")
            s = s.replace(String(charArrayOf(cApple, 164.toChar())), "4")
            s = s.replace(String(charArrayOf(cApple, 165.toChar())), "5")
            s = s.replace(String(charArrayOf(cApple, 166.toChar())), "6")
            s = s.replace(String(charArrayOf(cApple, 167.toChar())), "7")
            s = s.replace(String(charArrayOf(cApple, 168.toChar())), "8")
            s = s.replace(String(charArrayOf(cApple, 169.toChar())), "9")

            s = s.replace(String(charArrayOf(cNokia, 176.toChar())), "0")
            s = s.replace(String(charArrayOf(cNokia, 177.toChar())), "1")
            s = s.replace(String(charArrayOf(cNokia, 178.toChar())), "2")
            s = s.replace(String(charArrayOf(cNokia, 179.toChar())), "3")
            s = s.replace(String(charArrayOf(cNokia, 180.toChar())), "4")
            s = s.replace(String(charArrayOf(cNokia, 181.toChar())), "5")
            s = s.replace(String(charArrayOf(cNokia, 182.toChar())), "6")
            s = s.replace(String(charArrayOf(cNokia, 183.toChar())), "7")
            s = s.replace(String(charArrayOf(cNokia, 184.toChar())), "8")
            s = s.replace(String(charArrayOf(cNokia, 185.toChar())), "9")

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

        fun toPersianNumberWithTAAppend(text: String): String {
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
            return "$out تا "
        }

        fun getDurationString(seconds: Long): String {
            var seconds = seconds
            val hours = seconds / 3600
            val minutes = seconds % 3600 / 60
            seconds = seconds % 60
            return toPersianNumber(
                twoDigitString(
                    minutes
                ) + " : " + twoDigitString(
                    seconds
                )
            )
        }

        fun twoDigitString(number: Long): String {
            if (number == 0L) {
                return "۰۰"
            }
            return if (number / 10 == 0L) {
                "۰$number"
            } else number.toString()
        }
    }
}
