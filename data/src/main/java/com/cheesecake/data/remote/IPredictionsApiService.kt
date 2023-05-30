package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SinglePredictionsResponse
import com.cheesecake.data.models.SingleSidelinedResponse
import com.cheesecake.data.utils.QueryParameters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IPredictionsApiService {

    @GET("predictions")
    suspend fun getPredictionsByFixtureId(
        @Query(QueryParameters.FIXTURE) fixtureId: Int
    ): Response<BaseResponse<SinglePredictionsResponse>>
}