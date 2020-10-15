//package com.heure2pointe.outilsandroid
//
//import android.app.NotificationManager
//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import androidx.core.app.NotificationCompat
//import com.heure2pointe.R
//
//class NotificationReceiver:BroadcastReceiver() {
//    override fun onReceive(context:Context, intent:Intent) {
//        // Build notification based on Intent
//        val notification = NotificationCompat.Builder(context)
//            .setSmallIcon(R.drawable.ic_notification_small_icon)
//            .setContentTitle(intent.getStringExtra("title", ""))
//            .setContentText(intent.getStringExtra("text", ""))
//            .build()
//        // Show notification
//        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        manager.notify(42, notification)
//    }
//}