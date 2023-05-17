package com.betulnecanli.weatherapp.util

import android.util.Log
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d("TAG", "Message Notification Body: ${it.body}")
        }
        NotificationManagerCompat.from(this).sendNotification(
            title = remoteMessage.notification?.title.toString(),
            desc = remoteMessage.notification?.body.toString(),
            this
        )
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }
}