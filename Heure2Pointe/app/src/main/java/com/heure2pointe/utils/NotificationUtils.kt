//package com.heure2pointe.utils
//
//import android.app.*
//import android.content.Context
//import android.content.Intent
//import android.os.Build
//import android.os.SystemClock
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import com.heure2pointe.LoginActivity
//import com.heure2pointe.R
//import com.heure2pointe.outilsandroid.NotificationReceiver
//
//const val CHANNEL_ID = "MonSuperChannel"
//const val CHANNEL_NAME = "Commandes"
//
//
///**Création du channel */
//private fun initChannel(c: Context) {
//    // Uniquement à partir d’Oreo
//    if (Build.VERSION.SDK_INT < 26) {
//        return
//    }
//    val nm = c.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//    // Réglage du channel
//    val channel = NotificationChannel(
//        CHANNEL_ID, CHANNEL_NAME,
//        NotificationManager.IMPORTANCE_HIGH
//    )
//    channel.description = "Commandes" // Description
//    channel.enableLights(true) // Lumière
//    channel.enableVibration(true) // Vibration
//    channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
//    // Création du channel
//    nm.createNotificationChannel(channel)
//}
//
///**Envoyer une notification immediate */
//fun nuCreateInstantNotification(c: Context, message: String) {
//    //Initialisation du chanel
//    initChannel(c)
//    //Ce qui se passera quand on cliquera sur la notif
//    val intent = Intent(c, LoginActivity::class.java)
//    val pi = PendingIntent.getActivity(c, 0, intent, PendingIntent.FLAG_ONE_SHOT)
//    //La notification
//    val nb = NotificationCompat.Builder(c, CHANNEL_ID)
//    nb.setSmallIcon(R.drawable.ic_warning)
//    nb.setContentTitle("Heur2Pointe")
//    nb.setContentText(message)
//    nb.setContentIntent(pi) //le clic dessus
//    nb.setPriority(NotificationManager.IMPORTANCE_HIGH)
//    nb.setDefaults(Notification.DEFAULT_ALL) //Son + afficher la notification
//    //Envoyer la notification
//    val ncm = NotificationManagerCompat.from(c)
//    //ENVOIE
//    ncm.notify(29, nb.build())
//}
//
///**Envoyer une notification à retardement */
//fun nuScheduleNotification(c: Context, message: String, delay: Long) {
//    //Initialisation du chanel
//    initChannel(c)
//    //La notification
//    val builder = NotificationCompat.Builder(c, CHANNEL_ID)
//    builder.setContentTitle("Heur2Pointe")
//    builder.setContentText(message)
//    builder.setSmallIcon(R.drawable.ic_warning)
//    //Redirection vers le broadcast
//    val intent = Intent(c, LoginActivity::class.java)
//    intent.putExtra("MaCle", builder.build())
//    val pendingIntent = PendingIntent.getBroadcast(
//        c, 0, intent,
//        PendingIntent.FLAG_UPDATE_CURRENT
//    )
//    //Temps dans le futur
//    val futureInMillis = SystemClock.elapsedRealtime() + delay
//    val alarmManager = c.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//    alarmManager.set(
//        AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis,
//        pendingIntent
//    )
//}
//
//fun scheduleNotification(context:Context, time:Long, title:String, text:String) {
//    val intent = Intent(context, NotificationReceiver::class.java)
//    intent.putExtra("title", title)
//    intent.putExtra("text", text)
//    val pending = PendingIntent.getBroadcast(context, 42, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//    // Schdedule notification
//    val manager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//    manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, pending)
//}
//
//fun cancelNotification(context:Context, title:String, text:String) {
//    val intent = Intent(context, NotificationReceiver::class.java)
//    intent.putExtra("title", title)
//    intent.putExtra("text", text)
//    val pending = PendingIntent.getBroadcast(context, 42, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//    // Cancel notification
//    val manager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//    manager.cancel(pending)
//}