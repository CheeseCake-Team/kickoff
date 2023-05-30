package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SingleSidelinedResponse
import com.cheesecake.data.utils.QueryParameters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ISidelinedApiService {
    @GET("sidelined")
    suspend fun getPlayerSidelined(
        @Query(QueryParameters.ID) playerId: Int
    ):Response<BaseResponse<SingleSidelinedResponse>>


    @GET("sidelined")
    suspend fun getCoachSidelined(
        @Query(QueryParameters.ID) coachId: Int
    ):Response<BaseResponse<SingleSidelinedResponse>>

}