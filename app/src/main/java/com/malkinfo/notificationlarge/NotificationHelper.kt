package com.malkinfo.notificationlarge

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationHelper(var c:Context) {
    private val CHANNEL_ID = "back Id"
    private val NOTIFICATION_ID = 111
    /**set createNotification*/
    fun createNotification(){
        CreateNotificationChannel()
        val openInt = Intent(c,MainActivity::class.java)
            .apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        val pendingInt = PendingIntent.getActivities(c,0, arrayOf(openInt),0)
        val icon = BitmapFactory.decodeResource(c.resources,R.drawable.food)
        /**set Notification dialog*/
        val notifiyM = NotificationCompat.Builder(c,CHANNEL_ID)
            .setSmallIcon(R.drawable.food)
            .setLargeIcon(icon)
            .setContentTitle("Foods Information")
            .setContentText("Check Out the New Foods in your App")
        /**set Large Icon in Notification*/
            .setStyle(
                NotificationCompat.BigPictureStyle()
                        /** ok we set icon*/
                    .bigLargeIcon(icon)
                    .bigPicture(icon)
            /**ok run it*/
            )
            .setContentIntent(pendingInt)
            .setPriority(
                NotificationCompat.PRIORITY_DEFAULT
            )
            .build()
        NotificationManagerCompat.from(c).notify(NOTIFICATION_ID,notifiyM)
    }
    /** set CreateNotificationChannel*/
    private fun CreateNotificationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val name = CHANNEL_ID
            val derscrip = "Channel dersription"
            val impo = NotificationManager.IMPORTANCE_DEFAULT
            val isChannel = NotificationChannel(CHANNEL_ID,name,impo).apply {
                description = derscrip
            }
            val notifiyM = c.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notifiyM.createNotificationChannel(isChannel)
        }
    }
}