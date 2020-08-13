package com.faramarzaf.sdk.af_android_sdk.core.enums


enum class CalendarType constructor(var valueStr: String?, val value: Int) {

    UNDEFINE("UNDEFINE", -1),
    DARK("DARK", 0),
    LIGHT("LIGHT", 1);

    companion object {

        operator fun get(value: String?): CalendarType {
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

        operator fun get(value: Int): CalendarType {

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

