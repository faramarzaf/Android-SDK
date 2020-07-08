package com.faramarzaf.sdk.android

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.CallbackPopUpMenu
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.DialogCallback
import com.faramarzaf.sdk.af_android_sdk.core.ui.dialog.SimpleDialog
import com.faramarzaf.sdk.af_android_sdk.core.ui.menu.SimpleMenuInflater
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnShow.setOnClickListener {
            //   showAlertDialog()

            val mylist = listOf("Title1", "Title1", "Title3")
            SimpleMenuInflater.showPopUpMenu(this, mylist, btnShow, object : CallbackPopUpMenu {
                override fun onClick(title: String) {
                    Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }


    fun showAlertDialog() {
        SimpleDialog(this)
            .cancelable(true)
            .setNegativeButton("Text_Negative")
            .setPositiveButton("Text_Positive")
            .setText("This is a title")
            .showDialog()
            .setTitleColor(Color.YELLOW)
            .setTypeface(this, "vazir_thin.ttf")
            .setTextSize(28f, 12f)
            .setImageDialogBackground(R.drawable.ic_launcher_foreground)
            .setDialogBackground(R.drawable.shape_round_corner_dialog)
            .setPositiveBackground(R.drawable.shape_1, Color.RED)
            .setNegativeBackground(R.drawable.shape_2, Color.rgb(255, 255, 255))
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
