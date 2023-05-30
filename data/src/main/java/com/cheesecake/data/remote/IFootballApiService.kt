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


    // Fixtures
    @GET("fixtures")
    suspend fun getFixtures(): YourResponseClass
    @GET("fixtures/rounds")
    suspend fun getFixtureRounds(): YourResponseClass
    @GET("fixtures/headtohead")
    suspend fun getHeadToHead(
        @Query("team1Id") team1Id: String,
        @Query("team2Id") team2Id: String
    ): YourResponseClass
    @GET("fixtures/statistics")
    suspend fun getFixtureStatistics(@Query("fixtureId") fixtureId: String): YourResponseClass
    @GET("fixtures/events")
    suspend fun getFixtureEvents(@Query("fixtureId") fixtureId: String): YourResponseClass
    @GET("fixtures/lineups")
    suspend fun getFixtureLineups(@Query("fixtureId") fixtureId: String): YourResponseClass
    @GET("fixtures/players")
    suspend fun getFixturePlayers(@Query("fixtureId") fixtureId: String): YourResponseClass




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
    @GET("timezone")
    suspend fun getTimezone(): YourResponseClass
}
