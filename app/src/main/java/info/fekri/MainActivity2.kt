package info.fekri

import android.app.Notification.BigPictureStyle
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import info.fekri.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    lateinit var notificationManager: NotificationManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 12, intent, 0)
        val notification = NotificationCompat
            .Builder(this, "my_notif")
            .setSmallIcon(android.R.drawable.stat_notify_chat)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.img_android
                )
            )
            .setContentTitle("Mohammad-Reza Fekri")
            .setContentText("Hello. Would like to have a cup of coffee?")
            .setContentIntent(pendingIntent)


        // big picture style
        binding.btn1.setOnClickListener {

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            val notificationWithBigPicStyle =
                notification.setStyle(
                    NotificationCompat.BigPictureStyle()
                        .bigPicture(
                            BitmapFactory.decodeResource(
                                resources,
                                R.drawable.img_humanity
                            )
                        )
                ).build()
            notificationManager.notify((10..1000).random(), notificationWithBigPicStyle)

        }

        // big text style
        binding.btn2.setOnClickListener {

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            val notificationBigTxtStyle =
                notification.setStyle(
                    NotificationCompat.BigTextStyle().bigText(
                        "Hey you. How are you doing? Hope your doing well.\n" +
                                "Can we have meeting about the design of Application?" +
                                " I think we need to make change. So, this is my opinion about the design.\n" +
                                "Oh my god... , look at me.. I'm really crazy, because this text is for testing my application new-option.\n" +
                                "I'm actually talkative. yes. I think I'm so cool. handsome..., clever... .\n" +
                                "In the couple of days, I'm trying hard to make myself better, update myself. I meant I'm trying to make my self cool.\n" +
                                "Of course, it's not important that I'm cool or something like this. It's important that I'm trying and going on."
                    )
                ).build()

            notificationManager.notify((10..1000).random(), notificationBigTxtStyle)

        }

        // inbox text style
        binding.btn3.setOnClickListener {

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            val notificationInboxTxtStyle =
                notification.setStyle(
                    NotificationCompat.InboxStyle()
                        .addLine("Do you wanna seen?")
                        .addLine("Why don't you seen?")
                        .addLine("What's the cause?")
                        .addLine("Come on...")
                ).build()

            notificationManager.notify((10..1000).random(), notificationInboxTxtStyle)

        }

    }
}