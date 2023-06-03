package com.cheesecake.data.remote.sidliend

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.SidelinedDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ISidelinedApiService {
    @GET("sidelined")
    suspend fun getPlayerSidelined(
        @Query("player") playerId: Int
    ): Response<BaseResponse<SidelinedDTO>>


    @GET("sidelined")
    suspend fun getCoachSidelined(
        @Query("coach") coachId: Int
    ): Response<BaseResponse<SidelinedDTO>>

}