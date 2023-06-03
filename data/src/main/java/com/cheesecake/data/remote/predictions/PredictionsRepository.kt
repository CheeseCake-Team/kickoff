package com.cheesecake.data.remote.predictions

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.PredictionsDTO
import retrofit2.Response
import javax.inject.Inject

class PredictionsRepository @Inject constructor(private val predictionsApiService: IPredictionsApiService) {
    suspend fun getPredictionsByFixtureId(fixtureId: Int): Response<BaseResponse<PredictionsDTO>> {
        return predictionsApiService.getPredictionsByFixtureId(fixtureId)
    }
}