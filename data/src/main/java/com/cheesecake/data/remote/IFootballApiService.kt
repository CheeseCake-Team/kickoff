package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.CountriesResponse
import com.cheesecake.data.models.LeagueResponse
import com.cheesecake.data.models.TimezoneResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IFootballApiService {

    @GET("timezone")
    suspend fun getAllTimezones():Response<BaseResponse<TimezoneResponse>>

    @GET("countries")
    suspend fun getAllCountries():Response<BaseResponse<CountriesResponse>>

    @GET("leagues")
    suspend fun getLeagueById(@Query("id") id: Int):Response<BaseResponse<LeagueResponse>>



}