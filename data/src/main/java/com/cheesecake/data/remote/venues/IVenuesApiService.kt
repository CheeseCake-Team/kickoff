package com.cheesecake.data.remote.venues

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.VenuesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IVenuesApiService {

    @GET("venues")
    suspend fun getVenueById(
        @Query("id") venueId: Int
    ): Response<BaseResponse<VenuesDTO>>

    @GET("venues")
    suspend fun getVenueByName(
        @Query("name") venueName: String
    ): Response<BaseResponse<VenuesDTO>>

    @GET("venues")
    suspend fun getVenuesByCityName(
        @Query("city") cityName: String
    ): Response<BaseResponse<VenuesDTO>>

    @GET("venues")
    suspend fun getVenuesByCountryName(
        @Query("country") countryName: String
    ): Response<BaseResponse<VenuesDTO>>

    @GET("venues")
    suspend fun searchVenue(
        @Query("search") name: String
    ): Response<BaseResponse<VenuesDTO>>

}