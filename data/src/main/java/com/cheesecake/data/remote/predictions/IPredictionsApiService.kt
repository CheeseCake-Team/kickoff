package com.cheesecake.data.remote.predictions

import com.cheesecake.data.models.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IPredictionsApiService {

    @GET("predictions")
    suspend fun getPredictionsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<SinglePredictionsResponse>>
}