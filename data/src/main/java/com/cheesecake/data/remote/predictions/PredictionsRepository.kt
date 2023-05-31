package com.cheesecake.data.remote.predictions

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SinglePredictionsResponse
import retrofit2.Response
import javax.inject.Inject

class PredictionsRepository @Inject constructor(private val predictionsApiService: IPredictionsApiService) {
    suspend fun getPredictionsByFixtureId(fixtureId: Int): Response<BaseResponse<SinglePredictionsResponse>> {
        return predictionsApiService.getPredictionsByFixtureId(fixtureId)
    }
}