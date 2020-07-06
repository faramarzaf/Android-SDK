package com.faramarzaf.sdk.af_android_sdk.core.helper

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.request.target.Target
import com.faramarzaf.sdk.af_android_sdk.R


private var TAG = GlideHelper::class.java.simpleName

class GlideHelper {
    companion object {

        fun loadAdapterPicture(context: View, url: String, imageView: ImageView) {
            Glide.with(context).load(url)
                    .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                    //      .apply(RequestOptions.placeholderOf((R.drawable.place_holder_movie)).centerCrop())
                    .into(imageView)
        }

        fun loadTrailerPicture(context: Context, url: String, imageView: ImageView) {
            Glide.with(context)
                    .load(url)
                    .apply(RequestOptions.placeholderOf(R.color.colorPrimary).centerCrop())
                    .into(imageView)
        }

        fun loadBackDropPictureMovie(context: Context, url: String, imageView: ImageView) {
            Glide.with(context)
                    .load(url)
                    .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                    .into(imageView)
        }

        fun loadCastCrewPictures(context: Context, url: String, imageView: ImageView) {
            Glide.with(context)
                    .load(url)
                    // .apply(RequestOptions.placeholderOf(context.getDrawable(R.drawable.ic_place_holder_casts)).centerCrop())
                    //   .apply(RequestOptions.errorOf(context.getDrawable(R.drawable.ic_no_content)))
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageView)
        }

        fun roundedCorners(context: Context, url: String, radius: Int, imageView: ImageView) {
            Glide.with(context)
                    .load(url)
                    .apply(bitmapTransform(RoundedCorners(radius)))
                    .into(imageView)
        }

        fun circularImage(context: Context, url: String, imageView: ImageView) {
            Glide.with(context)
                    .load(url)
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageView)
        }

        fun loadImageIntoImageView(context: Context, url: String, imageView: AppCompatImageView) {
            Glide
                    .with(context)
                    .load(url)
                    .centerCrop()
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Drawable>, isFirstResource: Boolean): Boolean {
                            Log.e(TAG, "Load failed", e)

                            // You can also log the individual causes:
                            for (t in e!!.rootCauses) {
                                Log.e(TAG, "Caused by", t)
                            }
                            // Or, to log all root causes locally, you can use the built in helper method:
                            e.logRootCauses(TAG)

                            return false
                        }

                        override fun onResourceReady(resource: Drawable, model: Any, target: Target<Drawable>, dataSource: DataSource, isFirstResource: Boolean): Boolean {
                            return false
                        }
                    })
                    .into(imageView)
        }

        fun loadDrawableIntoImageView(context: Context, drawable: Drawable, imageView: AppCompatImageView) {
            Glide
                    .with(context)
                    .load(drawable)
                    .centerCrop()
                    .into(imageView)
        }

    }
}