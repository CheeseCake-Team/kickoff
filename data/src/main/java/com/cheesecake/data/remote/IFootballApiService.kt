package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.CountriesResponse
import com.cheesecake.data.models.LeagueResponse
import com.cheesecake.data.models.SinglePlayerResponse
import com.cheesecake.data.models.TimezoneResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IFootballApiService {


    // Countries
    @GET("countries")
    suspend fun getCountries(): YourResponseClass



}
