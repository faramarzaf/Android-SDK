package com.faramarzaf.sdk.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DialogCallback
import com.faramarzaf.sdk.af_android_sdk.core.ui.dialog.SimpleDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShow.setOnClickListener {
            showAlertDialog()
        }
    }


    fun showAlertDialog() {
        SimpleDialog(this)
            .cancelable(true)
            .setNegativeButton("Text_Negative")
            .setPositiveButton("Text_Positive")
            .setText("This is a title")
            .showDialog()
            .setImageDialogBackground(R.drawable.ic_launcher_foreground)
            .setNegativeBackground(R.drawable.shape_2)
            .setPositiveBackground(R.drawable.shape_1)
            .setDialogBackground(R.drawable.shape_round_corner_dialog)

            .setCallBack(object : DialogCallback {
                override fun onPositiveButtonClicked() {
                    // do your work
                }

                override fun onNegativeButtonClicked() {
                    // do your work
                }
            })


    }

}
