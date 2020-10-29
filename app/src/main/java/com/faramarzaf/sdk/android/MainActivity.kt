package com.faramarzaf.sdk.android

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.faramarzaf.sdk.af_android_sdk.core.ui.EzToast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btntoast.setOnClickListener {

            EzToast.Builder(this)
                .setMessage("hello")
                .setTextColor("#457787")
                .setTextSize(15)
                .setPadding(10)
                .setImageSize(64)
                .setIcon(R.drawable.ic_baseline_adb_24)
                .setBackgroundColor(R.color.colorAccent)
                .setGravity(Gravity.CENTER)
                .build()
        }

    }

}