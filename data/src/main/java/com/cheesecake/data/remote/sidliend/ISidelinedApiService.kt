package com.cheesecake.data.remote.sidliend

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SingleSidelinedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ISidelinedApiService {
    @GET("sidelined")
    suspend fun getPlayerSidelined(
        @Query("player") playerId: Int
    ):Response<BaseResponse<SingleSidelinedResponse>>


    @GET("sidelined")
    suspend fun getCoachSidelined(
        @Query("coach") coachId: Int
    ):Response<BaseResponse<SingleSidelinedResponse>>

}