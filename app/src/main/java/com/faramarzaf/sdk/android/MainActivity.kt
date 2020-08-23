package com.faramarzaf.sdk.android

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.faramarzaf.sdk.af_android_sdk.core.helper.IntentHelper
import com.faramarzaf.sdk.af_android_sdk.core.helper.StringHelper
import com.faramarzaf.sdk.af_android_sdk.core.helper.calendar.TimeHelper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener {

           /* Log.d("TAG00", TimeHelper.getCurrentTime())
            Log.d("TAG00", TimeHelper.getCurrentDate("yy", "MM", "dd", true))
            Log.d("TAG00", StringHelper.randomString(5))*/

            IntentHelper.callPhone(this,"09393285616")
        }

        btn_2.setOnClickListener {
            IntentHelper.openSetting(this)
        }

        btn_3.setOnClickListener {
            IntentHelper.openUrl(this,"github.com/faramarzaf")
        }

        btn_4.setOnClickListener {
            IntentHelper.sendSMS(this,"09393285616","hi")
        }


    }


}