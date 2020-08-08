package com.faramarzaf.sdk.af_android_sdk.core.notification


import android.app.DownloadManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class NotificationProvider {


    companion object {

        @RequiresApi(Build.VERSION_CODES.N)
        fun simpleNotification(context: Context, title: String, body: String, channelName: String, icon: Int, color: Int) {
            val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notificationId = 1
            val channelId = "channel-01"
            val importance = NotificationManager.IMPORTANCE_HIGH
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val mChannel = NotificationChannel(
                    channelId, channelName, importance
                )
                notificationManager.createNotificationChannel(mChannel)
            }

            val mBuilder: NotificationCompat.Builder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(icon)
                .setContentTitle(title)
                .setColor(color)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentText(body)

            mBuilder.setAutoCancel(true)
            notificationManager.notify(notificationId, mBuilder.build())
        }


        fun downloadNotification(context: Context, url: String) {
            val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?
            val uri = Uri.parse(url)
            val request = DownloadManager.Request(uri)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            val reference = downloadManager!!.enqueue(request)
        }

    }


}