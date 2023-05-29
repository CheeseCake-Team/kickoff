package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.TimezoneResponse
import retrofit2.http.GET

interface IFootballApiService {

    @GET("timezone")
    suspend fun getAllTimezones():BaseResponse<TimezoneResponse>

}