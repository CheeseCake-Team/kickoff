package com.cheesecake.data.remote.league

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.LeagueResponse
import com.cheesecake.data.utils.LeagueType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ILeaguesApiService {

    @GET("leagues")
    suspend fun getAllLeagues(): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesById(
        @Query("id") leagueId: Int
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByName(
        @Query("name") leagueName: String
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByCountryName(
        @Query("country") countryName: String
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByCountryCode(
        @Query("code") countryCode: String
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesOfSeason(
        @Query("season") season: Int
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeagueByIdBySeason(
        @Query("id") leagueId: Int,
        @Query("season") season: Int
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByType(
        @Query("type") type: LeagueType
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByTypeById(
        @Query("type") type: LeagueType,
        @Query("id") id: Int
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getLeagueByTypeByIdBySeason(
        @Query("type") type: LeagueType,
        @Query("id") id: Int,
        @Query("season") season: Int
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun getCurrentActiveLeagues(
        @Query("current") current: Boolean
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues")
    suspend fun searchByLeagueName(
        @Query("search") name: String
    ): Response<BaseResponse<LeagueResponse>>

    @GET("leagues/seasons")
    suspend fun getLeaguesSeasons(): Response<BaseResponse<LeagueResponse>>

}