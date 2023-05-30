package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.VenuesResponse
import com.cheesecake.data.utils.QueryParameters
import com.cheesecake.data.utils.QueryParameters.Companion.CITY
import com.cheesecake.data.utils.QueryParameters.Companion.COUNTRY
import com.cheesecake.data.utils.QueryParameters.Companion.ID
import com.cheesecake.data.utils.QueryParameters.Companion.NAME
import com.cheesecake.data.utils.QueryParameters.Companion.SEARCH
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IVenuesApiService {

    @GET("venues")
    suspend fun getVenueById(
        @Query(ID) venueId: Int
    ): Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun getVenueByName(
        @Query(NAME) venueName: String
    ) : Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun getVenuesByCityName(
        @Query(CITY) cityName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

    @GET("venues")
    suspend fun getVenuesByCountryName(
        @Query(COUNTRY) countryName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

    @GET("venues")
    suspend fun searchVenueByName(
        @Query(SEARCH) venueName: String
    ) : Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun searchVenuesByCountryName(
        @Query(SEARCH) countryName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

    @GET("venues")
    suspend fun searchVenuesByCityName(
        @Query(SEARCH) cityName: String
    ) : Response<BaseResponse<List<VenuesResponse>>>

}