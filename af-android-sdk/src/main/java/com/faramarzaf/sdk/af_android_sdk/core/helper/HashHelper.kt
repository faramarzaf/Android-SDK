package com.faramarzaf.sdk.af_android_sdk.core.helper

import com.google.common.hash.Hashing
import java.nio.charset.StandardCharsets

class HashHelper {

    companion object {

        @JvmStatic
        fun sha256(input: String): String {
            val hashed = Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString()
            return hashed
        }

    }
}