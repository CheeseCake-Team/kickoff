package com.cheesecake.data.remote.teams

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.BaseStaticResponse
import com.cheesecake.data.models.TeamCountries
import com.cheesecake.data.models.TeamInformationResponse
import com.cheesecake.data.models.TeamStatisticsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITeamsApiService {

    @GET("teams")
    suspend fun getTeamsByLeagueAndSeason(
        @Query("league") leagueId: Int,
        @Query("season") seasonId: Int
    ): Response<BaseResponse<TeamInformationResponse>>

    @GET("teams")
    suspend fun getTeamById(
        @Query("id") teamId: Int
    ): Response<BaseResponse<TeamInformationResponse>>

    @GET("teams/statistics")
    suspend fun getTeamStatistics(
        @Query("team") teamId: Int,
        @Query("season") season: Int,
        @Query("league") leagueId: Int
    ): Response<BaseStaticResponse<TeamStatisticsResponse>>

    @GET("teams/seasons")
    suspend fun getTeamSeasons(
        @Query("team") teamId: Int
    ): Response<BaseResponse<Int>>

    @GET("teams/countries")
    suspend fun getTeamCountries(): Response<BaseResponse<TeamCountries>>
}