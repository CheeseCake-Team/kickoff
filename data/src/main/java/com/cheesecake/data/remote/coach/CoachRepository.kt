package com.cheesecake.data.remote.coach

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.CoachDTO
import retrofit2.Response
import javax.inject.Inject

class CoachRepository @Inject constructor(private val coachApiService: ICoachApiService) {
    suspend fun getCoachById(playerID: Int): Response<BaseResponse<CoachDTO>> {
        return coachApiService.getCoachById(playerID)
    }

    suspend fun getCoachByTeam(teamID: Int): Response<BaseResponse<CoachDTO>> {
        return coachApiService.getCoachByTeam(teamID)
    }

    suspend fun getCoachBySearch(coachName: String): Response<BaseResponse<CoachDTO>> {
        return coachApiService.getCoachBySearch(coachName)
    }
}
