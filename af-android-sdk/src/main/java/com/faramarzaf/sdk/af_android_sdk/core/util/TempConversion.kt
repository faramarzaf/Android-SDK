package com.faramarzaf.sdk.af_android_sdk.core.util

class TempConversion {

    object CToF {
        fun convert(temp: Float): Float {
            return (temp * 9) / 5 + 32
        }
    }

    object CToK {
        fun convert(temp: Float): Float {
            return temp+273.15f
        }
    }

    object FToC {
        fun convert(temp: Float): Float {
            return (temp - 32) * 5 / 9
        }
    }

    object FToK {
        fun convert(temp: Float): Float {
            return temp+255.3722222222f
        }
    }

    object KToC {
        fun convert(temp: Float): Float {
            return temp - 273.15f
        }
    }

    object KToF {
        fun convert(temp: Float): Float {
            return temp -459.67f
        }
    }

}