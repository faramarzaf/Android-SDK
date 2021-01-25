package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Faramarz Afzali
 * 25/Jan/2021
 */

class RecyclerviewHelper {

    companion object {

        @JvmStatic
        fun setRecyclerviewDivider(context: Context, recyclerView: RecyclerView) {
            recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        @JvmStatic
        fun setRecyclerviewDivider(context: Context, recyclerView: RecyclerView, resId: Int) {
            val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            divider.setDrawable(ContextCompat.getDrawable(context, resId)!!)
            recyclerView.addItemDecoration(divider)
        }

    }

}