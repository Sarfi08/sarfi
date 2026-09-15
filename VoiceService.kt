package com.auraai

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder

class VoiceService : Service() {
    override fun onCreate() {
        super.onCreate()
        val channel = NotificationChannel("aura_voice", "AuraAI Voice", NotificationManager.IMPORTANCE_LOW)
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        val n: Notification = Notification.Builder(this, "aura_voice")
            .setContentTitle("AuraAI voice service")
            .setContentText("Voice service is running")
            .setSmallIcon(android.R.drawable.ic_btn_speak_now)
            .build()
        startForeground(1001, n)
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int = START_STICKY
    override fun onBind(intent: Intent?): IBinder? = null
}
