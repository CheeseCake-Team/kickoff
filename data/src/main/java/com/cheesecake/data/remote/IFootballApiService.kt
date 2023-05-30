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


    // Teams
    @GET("teams")
    suspend fun getTeams(): YourResponseClass
    @GET("teams/statistics")
    suspend fun getTeamStatistics(@Query("teamId") teamId: String): YourResponseClass
    @GET("teams/seasons")
    suspend fun getTeamSeasons(@Query("teamId") teamId: String): YourResponseClass
    @GET("teams/countries")
    suspend fun getTeamCountries(): YourResponseClass



    // Leagues
    @GET("leagues")
    suspend fun getLeagues(): YourResponseClass
    @GET("leagues/seasons")
    suspend fun getLeagueSeasons(@Query("leagueId") leagueId: String): YourResponseClass



    // Countries
    @GET("countries")
    suspend fun getCountries(): YourResponseClass


    // Timezone

}
