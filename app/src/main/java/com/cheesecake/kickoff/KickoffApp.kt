package com.cheesecake.kickoff

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.work.BackoffPolicy
import androidx.work.Configuration
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.cheesecake.kickoff.work.KickOffWorkerFactory
import com.cheesecake.kickoff.work.MatchWorker
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class KickoffApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: KickOffWorkerFactory

    override fun onCreate() {
        super.onCreate()
        val workRequest = OneTimeWorkRequestBuilder<MatchWorker>()
            .setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS)
            .build()
        WorkManager.getInstance(this).enqueueUniqueWork(
            "TeamWorker",
            ExistingWorkPolicy.KEEP,
            workRequest
        )

        createTeamsNotificationChannel()

    }

    private fun createTeamsNotificationChannel() {
        val channel = NotificationChannel("1", "Teams channel", NotificationManager.IMPORTANCE_HIGH)
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }

    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(workerFactory)
            .build()

}