package com.cheesecake.data.remote.coach

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.CoachResponse
import retrofit2.Response
import javax.inject.Inject

class CoachRepository @Inject constructor(private val coachApiService: ICoachApiService) {
    suspend fun getCoachById(playerID: Int): Response<BaseResponse<CoachResponse>> {
        return coachApiService.getCoachById(playerID)
    }

    suspend fun getCoachByTeam(teamID: Int): Response<BaseResponse<CoachResponse>> {
        return coachApiService.getCoachByTeam(teamID)
    }

    suspend fun getCoachBySearch(coachName: String): Response<BaseResponse<CoachResponse>> {
        return coachApiService.getCoachBySearch(coachName)
    }
}