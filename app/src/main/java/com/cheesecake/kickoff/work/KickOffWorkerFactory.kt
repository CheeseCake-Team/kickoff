package com.cheesecake.kickoff.work

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.cheesecake.domain.usecases.GetAllTeamsInLeagueWithSeasonUseCase
import com.cheesecake.domain.usecases.GetMatchDetailsUseCase
import javax.inject.Inject

class KickOffWorkerFactory @Inject constructor(
    private val getMatchDetailsUseCase: GetMatchDetailsUseCase
): WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker {
        return when(workerClassName) {
            MatchWorker::class.java.name -> MatchWorker(
                getMatchDetailsUseCase ,
                appContext, workerParameters)

            else -> { throw Exception("Unknown Worker Name.")}
        }
    }

}