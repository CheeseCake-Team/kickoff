package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.CoachResponse
import com.cheesecake.data.utils.QueryParameters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICoachApiService {

    @GET("coachs")
    suspend fun getCoachById(
        @Query(QueryParameters.ID) playerID: Int
    ): Response<BaseResponse<CoachResponse>>

    @GET("coachs")
    suspend fun getCoachByTeam(
        @Query(QueryParameters.TEAM) teamID: Int
    ): Response<BaseResponse<CoachResponse>>

    @GET("coachs")
    suspend fun getCoachBySearch(
        @Query(QueryParameters.SEARCH) getCoachName: String
    ): Response<BaseResponse<CoachResponse>>
}