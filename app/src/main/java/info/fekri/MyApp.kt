package info.fekri

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        /* check the api-level / version | is the api-level 26 / version bigger than 8 or not.*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // create notification manager
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            // create notification manager
            val notificationChannel =
                NotificationChannel("my_notif", "Football", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.description = "This channel shows notifications about Football."

            // set notificationChannel to notificationManager
            notificationManager.createNotificationChannel(notificationChannel)

        }

    }

}