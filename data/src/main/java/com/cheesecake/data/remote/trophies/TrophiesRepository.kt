package com.cheesecake.data.remote.trophies

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SingleTrophyResponse
import retrofit2.Response
import javax.inject.Inject

class TrophiesRepository @Inject constructor(private val trophiesApiService: ITrophiesApiService) {

    suspend fun getPlayerTrophies(playerId: Int): Response<BaseResponse<SingleTrophyResponse>> {
        return trophiesApiService.getPlayerTrophies(playerId)
    }

    suspend fun getCoachTrophies(coachId: Int): Response<BaseResponse<SingleTrophyResponse>> {
        return trophiesApiService.getCoachTrophies(coachId)
    }
}