package com.cheesecake.data.remote.sidliend

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.SidelinedDTO
import retrofit2.Response
import javax.inject.Inject

class SidelinedRepository @Inject constructor(private val sidelinedApiService: ISidelinedApiService) {

    suspend fun getPlayerSidelined(playerId: Int): Response<BaseResponse<SidelinedDTO>> {
        return sidelinedApiService.getPlayerSidelined(playerId)
    }

    suspend fun getCoachSidelined(coachId: Int): Response<BaseResponse<SidelinedDTO>> {
        return sidelinedApiService.getCoachSidelined(coachId)
    }
}