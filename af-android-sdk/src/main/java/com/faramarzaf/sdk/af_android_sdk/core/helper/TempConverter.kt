package com.faramarzaf.sdk.af_android_sdk.core.helper

/**
 * @author Faramarz Afzali
 * 14/jun/2020
 */

class TempConverter {

    object CToF {
        @JvmStatic
        fun convert(temp: Float): Float {
            return (temp * 9) / 5 + 32
        }
    }

    object CToK {
        @JvmStatic
        fun convert(temp: Float): Float {
            return temp + 273.15f
        }
    }

    object FToC {
        @JvmStatic
        fun convert(temp: Float): Float {
            return (temp - 32) * 5 / 9
        }
    }

    object FToK {
        @JvmStatic
        fun convert(temp: Float): Float {
            return temp + 255.3722222222f
        }
    }

    object KToC {
        @JvmStatic
        fun convert(temp: Float): Float {
            return temp - 273.15f
        }
    }

    object KToF {
        @JvmStatic
        fun convert(temp: Float): Float {
            return temp - 459.67f
        }
    }

}