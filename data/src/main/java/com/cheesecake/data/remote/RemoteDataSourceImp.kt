package com.cheesecake.data.remote

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.remote.api.FootballApiService
import com.cheesecake.data.remote.response.FixtureResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val service: FootballApiService
) : RemoteDataSource {
    override suspend fun getFixtureById(timeZone: String, fixtureId: Int): List<FixtureResponse> {
       return wrap { service.getFixtureById(timeZone,fixtureId)
        }
    }


    private suspend fun <T> wrap(
        function: suspend () -> Response<BaseResponse<T>>,
    ): List<T> {
        val response = function()
        return if (response.isSuccessful) {
            response.body()?.response
        } else {
            throw Throwable(" Not Success Request ")
        } as List<T>
    }
}