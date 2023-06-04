package com.cheesecake.data.repository.coach

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.CoachDTO
import com.cheesecake.data.remote.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class CoachRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {
    suspend fun getCoachById(playerID: Int): List<CoachDTO> {
        return remoteDataSource.getCoachById(playerID)
    }

    suspend fun getCoachByTeam(teamID: Int): List<CoachDTO> {
        return remoteDataSource.getCoachByTeam(teamID)
    }

    suspend fun getCoachBySearch(coachName: String): List<CoachDTO> {
        return remoteDataSource.getCoachBySearch(coachName)
    }
}
