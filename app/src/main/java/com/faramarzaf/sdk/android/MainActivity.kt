package com.faramarzaf.sdk.android

import android.os.Bundle
import android.widget.Toast
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

        SimpleDialog(
            this,
            R.drawable.shape_round_corner_dialog,
            R.drawable.shape_2,
            R.drawable.shape_1,
            R.drawable.shape_2
        )
            .setNegativeButton("no").setPositiveButton("OK")
            .setText("This is a title")
            .setCallBack(object : DialogCallback {
                override fun onPositiveButtonClicked() {
                    Toast.makeText(applicationContext, "ok", Toast.LENGTH_SHORT).show()
                }

                override fun onNegativeButtonClicked() {
                    Toast.makeText(applicationContext, "no", Toast.LENGTH_SHORT).show()
                }
            }).showDialog()
    }

}
