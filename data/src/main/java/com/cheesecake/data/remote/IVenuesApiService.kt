package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.VenuesResponse
import com.cheesecake.data.utils.QueryParameters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IVenuesApiService {

    @GET("venues")
    suspend fun getVenueById(
        @Query(QueryParameters.ID) venueId: Int
    ): Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun getVenueByName(
        @Query(QueryParameters.Name) venueName: String
    ) : Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun getVenuesByCityName(
        @Query(QueryParameters.City) cityName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

    @GET("venues")
    suspend fun getVenuesByCountryName(
        @Query(QueryParameters.Country) countryName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

    @GET("venues")
    suspend fun searchVenueByName(
        @Query(QueryParameters.SEARCH) venueName: String
    ) : Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun searchVenuesByCountryName(
        @Query(QueryParameters.SEARCH) countryName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

    @GET("venues")
    suspend fun searchVenuesByCityName(
        @Query(QueryParameters.SEARCH) cityName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

}