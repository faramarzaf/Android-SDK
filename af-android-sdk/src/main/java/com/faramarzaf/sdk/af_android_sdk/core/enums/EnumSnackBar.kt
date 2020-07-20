package com.faramarzaf.sdk.af_android_sdk.core.enums

import com.google.android.material.snackbar.Snackbar


enum class EnumSnackBar constructor(var valueStr: String?, val value: Int) {

    UNDEFINE("UNDEFINE", -1),
    SHORT("Snackbar.LENGTH_SHORT", Snackbar.LENGTH_SHORT),
    LONG("Snackbar.LENGTH_LONG", Snackbar.LENGTH_LONG);

    companion object {

        operator fun get(value: String?): EnumSnackBar {
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

        operator fun get(value: Int): EnumSnackBar {

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

