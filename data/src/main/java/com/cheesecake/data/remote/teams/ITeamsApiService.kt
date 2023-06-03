package com.cheesecake.data.remote.teams

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.base.BaseStaticResponse
import com.cheesecake.data.models.dto.TeamCountriesDTO
import com.cheesecake.data.models.dto.TeamInformationDTO
import com.cheesecake.data.models.dto.TeamStatisticsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITeamsApiService {

    @GET("teams")
    suspend fun getTeamsByLeagueAndSeason(
        @Query("league") leagueId: Int,
        @Query("season") seasonId: Int
    ): Response<BaseResponse<TeamInformationDTO>>

    @GET("teams")
    suspend fun getTeamById(
        @Query("id") teamId: Int
    ): Response<BaseResponse<TeamInformationDTO>>

    @GET("teams/statistics")
    suspend fun getTeamStatistics(
        @Query("team") teamId: Int,
        @Query("season") season: Int,
        @Query("league") leagueId: Int
    ): Response<BaseStaticResponse<TeamStatisticsDTO>>

    @GET("teams/seasons")
    suspend fun getTeamSeasons(
        @Query("team") teamId: Int
    ): Response<BaseResponse<Int>>

    @GET("teams/countries")
    suspend fun getTeamCountries(): Response<BaseResponse<TeamCountriesDTO>>
}