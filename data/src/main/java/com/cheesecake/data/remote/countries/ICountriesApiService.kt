package com.cheesecake.data.remote.countries

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.TeamCountries
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ICountriesApiService {
    @GET("countries")
    suspend fun getAllCountries(): Response<BaseResponse<TeamCountries>>

    @GET("countries")
    suspend fun getCountryByName(
        @Query("name") countryName: String
    ): Response<BaseResponse<TeamCountries>>

    @GET("countries")
    suspend fun getCountryByCode(
        @Query("code") countryCode: String
    ): Response<BaseResponse<TeamCountries>>

    @GET("countries")
    suspend fun searchInCountries(
        @Query("search") searchQuery: String
    ): Response<BaseResponse<TeamCountries>>

}
