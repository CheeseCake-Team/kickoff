package com.cheesecake.data.remote.venues

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.VenuesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IVenuesApiService {

    @GET("venues")
    suspend fun getVenueById(
        @Query("id") venueId: Int
    ): Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun getVenueByName(
        @Query("name") venueName: String
    ) : Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun getVenuesByCityName(
        @Query("city") cityName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

    @GET("venues")
    suspend fun getVenuesByCountryName(
        @Query("country") countryName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

    @GET("venues")
    suspend fun searchVenueByName(
        @Query("search") venueName: String
    ) : Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun searchVenuesByCountryName(
        @Query("search") countryName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

    @GET("venues")
    suspend fun searchVenuesByCityName(
        @Query("search") cityName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

}