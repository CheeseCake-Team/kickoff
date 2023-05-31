package com.cheesecake.data.remote.timezone

import com.cheesecake.data.models.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface ITimeZoneApiService {
    @GET("timezone")
    suspend fun getTimezoneList(): Response<BaseResponse<String>>
}