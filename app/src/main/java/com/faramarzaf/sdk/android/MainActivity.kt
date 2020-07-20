package com.faramarzaf.sdk.android

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.faramarzaf.sdk.af_android_sdk.core.helper.SimpleSnackbar
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.CallbackSnackBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_click.setOnClickListener {


/*            SimpleSnackbar.show(root, "hello", "action", Color.RED, Color.YELLOW, Color.BLUE, false, object : CallbackSnackBar {
                override fun onActionClick() {
                    Toast.makeText(applicationContext, "clicked", Toast.LENGTH_SHORT).show()
                }
            })*/

            // SimpleSnackbar.show(root,"hi",Color.BLACK,Color.RED,true)

            SimpleSnackbar.show(this,root, "hello", "action", Color.RED, Color.YELLOW, Color.BLUE, "vazir_thin.ttf",false, object : CallbackSnackBar {
                override fun onActionClick() {
                    Toast.makeText(applicationContext, "clicked", Toast.LENGTH_SHORT).show()
                }
            })

        }
    }

}