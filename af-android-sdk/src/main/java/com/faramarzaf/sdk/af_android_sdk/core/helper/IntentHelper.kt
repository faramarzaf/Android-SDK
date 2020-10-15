package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings.ACTION_SECURITY_SETTINGS


/**
 * @author Faramarz Afzali
 * 23/august/2020
 */

class IntentHelper {

    companion object {

        @JvmStatic
        fun callPhone(context: Context, number: String) {
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null))
            context.startActivity(intent)
        }

        @JvmStatic
        fun openSetting(context: Context) {
            val intent = Intent(ACTION_SECURITY_SETTINGS)
            context.startActivity(intent)
        }

        @JvmStatic
        fun sendSMS(context: Context, number: String, message: String) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:$number"))
            intent.putExtra("sms_body", message)
            context.startActivity(intent)
        }

        @JvmStatic
        fun openUrl(context: Context, url: String) {
            try {
                /* if (!url.startsWith("http://") && !url.startsWith("https://"))
                      url = "http://$url"
                      url.plus("http://$url")*/
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(browserIntent)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }
}