package com.faramarzaf.sdk.af_android_sdk.core.notification


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class NotificationProvider {


    companion object {

        @JvmStatic
        @RequiresApi(Build.VERSION_CODES.N)
        fun simpleNotification(context: Context, title: String, body: String, channelName: String, icon: Int, color: Int) {
            val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notificationId = 1
            val channelId = "channel-01"
            val importance = NotificationManager.IMPORTANCE_HIGH
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val mChannel = NotificationChannel(channelId, channelName, importance)
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

        @JvmStatic
        @RequiresApi(Build.VERSION_CODES.N)
        fun expandNotification(context: Context, title: String, body: String, channelName: String, bigContentTitle: String, listExpand: Array<String?>, icon: Int, color: Int) {
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
            val notificationId = 2
            val channelId = "channel-02"
            val importance = NotificationManager.IMPORTANCE_HIGH
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val mChannel = NotificationChannel(channelId, channelName, importance)
                notificationManager?.createNotificationChannel(mChannel)
            }

            val mBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(icon)
                .setContentTitle(title)
                .setColor(color)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentText(body)

            val inboxStyle = NotificationCompat.InboxStyle()
            inboxStyle.setBigContentTitle(bigContentTitle)

            for (i in listExpand.indices)
                inboxStyle.addLine(listExpand[i])

            mBuilder.setStyle(inboxStyle)
            mBuilder.setAutoCancel(true)
            notificationManager?.notify(notificationId, mBuilder.build())
        }
    }
}