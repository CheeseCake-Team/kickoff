package com.cheesecake.data.repository.trophies

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.TrophyDTO
import com.cheesecake.data.remote.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class TrophiesRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getPlayerTrophies(playerId: Int): List<TrophyDTO> {
        return remoteDataSource.getPlayerTrophies(playerId)
    }

    suspend fun getCoachTrophies(coachId: Int): List<TrophyDTO> {
        return remoteDataSource.getCoachTrophies(coachId)
    }
}