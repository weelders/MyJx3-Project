package com.heure2pointe.outilsandroid

import android.app.Notification
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.heure2pointe.R

class NotificationPublisher : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        //Log.w("TAG_", "BRNotification")
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        //TODO("MyBroadcastReceiverNotification.onReceive() is not implemented")
        //On récupère la notification reçu
        //on l'affiche
        intent.getParcelableExtra<Notification>("MaCle")?.let {
            //on l'affiche
            val ncm = NotificationManagerCompat.from(context)
            ncm.notify(28, it)
        }
    }
}
