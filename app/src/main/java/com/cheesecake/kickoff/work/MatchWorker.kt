package com.cheesecake.kickoff.work

import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.cheesecake.domain.usecases.GetMatchDetailsUseCase
import com.cheesecake.kickoff.R
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlin.random.Random

@HiltWorker
class MatchWorker @AssistedInject constructor(
    @Assisted private val getMatchDetailsUseCase: GetMatchDetailsUseCase,
    @Assisted private val appContext: Context,
    @Assisted workerParams: WorkerParameters,


) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            getMatchDetailsUseCase()
            showNotification("1", "Match Started", " The Match You Fallowed Have Started")
            Result.success()
        } catch (e: Exception) {
            Log.e("Worker error ", e.message.toString())
            Result.failure()
        }
    }

    private suspend fun showNotification(channelID: String, title: String, body: String) {
        setForeground(
            ForegroundInfo(
                Random.nextInt(),
                NotificationCompat.Builder(appContext, channelID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle(title)
                    .setContentText(body)
                    .build()
            )
        )
    }

}