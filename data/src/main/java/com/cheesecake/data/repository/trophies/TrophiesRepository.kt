package com.cheesecake.data.repository.trophies

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.TrophyDTO
import retrofit2.Response
import javax.inject.Inject

class TrophiesRepository @Inject constructor(private val trophiesApiService: ITrophiesApiService) {

    suspend fun getPlayerTrophies(playerId: Int): Response<BaseResponse<TrophyDTO>> {
        return trophiesApiService.getPlayerTrophies(playerId)
    }

    suspend fun getCoachTrophies(coachId: Int): Response<BaseResponse<TrophyDTO>> {
        return trophiesApiService.getCoachTrophies(coachId)
    }
}