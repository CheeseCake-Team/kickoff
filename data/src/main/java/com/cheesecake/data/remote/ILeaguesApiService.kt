package com.cheesecake.data.remote

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.LeagueResponse
import com.cheesecake.data.utils.QueryParameters
import com.cheesecake.data.utils.QueryParameters.Companion.CODE
import com.cheesecake.data.utils.QueryParameters.Companion.COUNTRY
import com.cheesecake.data.utils.QueryParameters.Companion.ID
import com.cheesecake.data.utils.QueryParameters.Companion.NAME
import com.cheesecake.data.utils.QueryParameters.Companion.SEASON
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ILeaguesApiService {

    @GET("leagues")
    suspend fun getAllLeagues():Response<BaseResponse<List<LeagueResponse>>>

    @GET("leagues")
    suspend fun getLeaguesById(
        @Query(QueryParameters.ID) leagueId: Int
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByName(
        @Query(NAME) leagueName: String
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByCountryName(
        @Query(COUNTRY) countryName: String
    ): Response<BaseResponse<List<LeagueResponse>>>

    @GET("leagues")
    suspend fun getLeaguesByCountryCode(
        @Query(CODE) countryCode: String
    ): Response<BaseResponse<List<LeagueResponse>>>

    @GET("leagues")
    suspend fun getLeaguesOfSeason(
        @Query (SEASON) season: Int
    ): Response<BaseResponse<List<LeagueResponse>>>

    @GET("leagues")
    suspend fun getLeagueByIdBySeason(
        @Query(ID) leagueId: Int,
        @Query(SEASON) season: Int
    ): Response<BaseResponse<LeagueResponse>>

}