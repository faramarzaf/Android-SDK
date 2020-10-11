package com.faramarzaf.sdk.af_android_sdk.core.enums


enum class ScreenOrientation constructor(private var valueStr: String?, private val value: Int) {

    UNDEFINE("UNDEFINE", -1),
    LANDSCAPE("landscape", 0),
    PORTRAIT("portrait", 1);

    companion object {

        operator fun get(value: String?): ScreenOrientation {
            if (value == null) {
                return UNDEFINE
            }

            val `arr$` = values()
            for (`val` in `arr$`) {
                if (`val`.valueStr!!.equals(value.trim { it <= ' ' }, ignoreCase = true)) {
                    return `val`
                }
            }

            return UNDEFINE
        }

        operator fun get(value: Int): ScreenOrientation {

            if (value == null) {
                return UNDEFINE
            }

            val `arr$` = values()
            for (`val` in `arr$`) {
                if (`val`.value === value) {
                    return `val`
                }
            }

            return UNDEFINE
        }
    }
}