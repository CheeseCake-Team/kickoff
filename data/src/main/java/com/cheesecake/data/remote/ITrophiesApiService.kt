package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SingleTrophyResponse
import com.cheesecake.data.utils.QueryParameters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITrophiesApiService {

    @GET("trophies")
    suspend fun getPlayerTrophies(
        @Query (QueryParameters.ID) playerId: Int
    ): Response<BaseResponse<SingleTrophyResponse>>


    @GET("trophies")
    suspend fun getCoachTrophies(
        @Query (QueryParameters.ID) CoachId: Int
    ): Response<BaseResponse<SingleTrophyResponse>>


}