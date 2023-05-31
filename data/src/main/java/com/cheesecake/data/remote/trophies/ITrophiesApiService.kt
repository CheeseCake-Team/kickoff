package com.cheesecake.data.remote.trophies

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SingleTrophyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITrophiesApiService {

    @GET("trophies")
    suspend fun getPlayerTrophies(
        @Query("player") playerId: Int
    ): Response<BaseResponse<SingleTrophyResponse>>


    @GET("trophies")
    suspend fun getCoachTrophies(
        @Query("coach") coachId: Int
    ): Response<BaseResponse<SingleTrophyResponse>>


}