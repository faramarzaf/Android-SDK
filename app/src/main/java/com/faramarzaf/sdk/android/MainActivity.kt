package com.faramarzaf.sdk.android

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DialogCallback
import com.faramarzaf.sdk.af_android_sdk.core.ui.dialog.SimpleDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showAlertDialog()
    }


    fun showAlertDialog() {

        SimpleDialog(this).setNegativeButton("nooop").setPositiveButton("OK").setText("This is a title")
            .showDialog().setCallBack(object : DialogCallback {
                override fun onPositiveButtonClicked() {
                    Toast.makeText(applicationContext, "ok", Toast.LENGTH_SHORT).show()
                }

                override fun onNegativeButtonClicked() {
                    Toast.makeText(applicationContext, "no", Toast.LENGTH_SHORT).show()
                }
            })
    }

}
