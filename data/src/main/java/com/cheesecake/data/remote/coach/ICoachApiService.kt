package com.cheesecake.data.remote.coach

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.CoachResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICoachApiService {

    @GET("coachs")
    suspend fun getCoachById(
        @Query("id") playerID: Int
    ): Response<BaseResponse<CoachResponse>>

    @GET("coachs")
    suspend fun getCoachByTeam(
        @Query("team") teamID: Int
    ): Response<BaseResponse<CoachResponse>>

    @GET("coachs")
    suspend fun getCoachBySearch(
        @Query("search") getCoachName: String
    ): Response<BaseResponse<CoachResponse>>
}