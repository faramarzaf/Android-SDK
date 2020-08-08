package com.faramarzaf.sdk.android

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.faramarzaf.sdk.af_android_sdk.core.notification.NotificationProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changes = arrayOfNulls<String>(5)
        changes[0] = "Delete option"
        changes[1] = "Update option"
        changes[2] = "Share option"
        changes[3] = "Introduction option"

        btn_click.setOnClickListener {
            NotificationProvider.expandNotification(
                this, "This is title", "This is body",
                "This is channel", "This is big content",
                changes, R.drawable.ic_password_show, Color.RED
            )
        }
    }

}