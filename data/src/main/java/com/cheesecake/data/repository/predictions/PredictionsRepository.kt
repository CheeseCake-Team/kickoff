package com.cheesecake.data.repository.predictions

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.PredictionsDTO
import com.cheesecake.data.remote.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class PredictionsRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {
    suspend fun getPredictionsByFixtureId(fixtureId: Int):List<PredictionsDTO> {
        return remoteDataSource.getPredictionsByFixtureId(fixtureId)
    }
}