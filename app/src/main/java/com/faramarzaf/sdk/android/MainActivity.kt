package com.faramarzaf.sdk.android

import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.faramarzaf.sdk.af_android_sdk.core.helper.ScreenHelper
import com.faramarzaf.sdk.af_android_sdk.core.interfaces.CallbackBrightnessValue
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekbar.setOnSeekBarChangeListener(this)

        btn_1.setOnClickListener {

        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        ScreenHelper.setBrightness(this, progress,object :CallbackBrightnessValue{
            override fun minBrightness() {
                Toast.makeText(this@MainActivity,"zero Brightness",Toast.LENGTH_SHORT).show()
            }

            override fun maxBrightness() {
                Toast.makeText(this@MainActivity,"255 Brightness",Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }

}