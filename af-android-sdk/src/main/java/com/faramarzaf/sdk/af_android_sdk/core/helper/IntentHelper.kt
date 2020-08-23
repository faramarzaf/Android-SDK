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
    /**
     * call phone
     * send sms
     * open url
     * open setting page
     * turn on location on setting page
     */
    companion object {

        fun callPhone(context: Context, number: String) {
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null))
            context.startActivity(intent)
        }

        fun openSetting(context: Context) {
            val intent = Intent(ACTION_SECURITY_SETTINGS)
            context.startActivity(intent)
        }


        fun sendSMS(context: Context, number: String, message: String) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:$number"))
            intent.putExtra("sms_body", message)
            context.startActivity(intent)
        }

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