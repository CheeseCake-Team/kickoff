package com.cheesecake.data.remote.api

import com.cheesecake.data.remote.response.BaseResponse
import com.cheesecake.data.remote.response.BaseStaticResponse
import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.remote.response.LineupResponse
import com.cheesecake.data.remote.response.PlayerResponse
import com.cheesecake.data.remote.response.PredictionsResponse
import com.cheesecake.data.remote.response.SidelinedResponse
import com.cheesecake.data.remote.response.SquadResponse
import com.cheesecake.data.remote.response.StandingsResponse
import com.cheesecake.data.remote.response.TeamCountriesResponse
import com.cheesecake.data.remote.response.TeamInformationResponse
import com.cheesecake.data.remote.response.TeamStatisticsResponse
import com.cheesecake.data.remote.response.TransferResponse
import com.cheesecake.data.remote.response.TrophyResponse
import com.cheesecake.data.remote.response.VenuesResponse

import com.cheesecake.data.utils.FixtureStatus
import com.cheesecake.data.utils.LeagueType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApiService {

    //region coachs

    @GET("coachs")
    suspend fun getCoachById(
        @Query("id") playerID: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.CoachResponse>>

    @GET("coachs")
    suspend fun getCoachByTeam(
        @Query("team") teamID: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.CoachResponse>>

    @GET("coachs")
    suspend fun getCoachBySearch(
        @Query("search") getCoachName: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.CoachResponse>>
    //endregion

    //region countries
    @GET("countries")
    suspend fun getAllCountries(): Response<BaseResponse<TeamCountriesResponse>>

    @GET("countries")
    suspend fun getCountryByName(
        @Query("name") countryName: String
    ): Response<BaseResponse<TeamCountriesResponse>>

    @GET("countries")
    suspend fun getCountryByCode(
        @Query("code") countryCode: String
    ): Response<BaseResponse<TeamCountriesResponse>>

    @GET("countries")
    suspend fun searchInCountries(
        @Query("search") searchQuery: String
    ): Response<BaseResponse<TeamCountriesResponse>>
    //endregion

    //region fixtures
    //region Rounds
    @GET("fixtures/rounds")
    suspend fun getFixtureRounds(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BaseResponse<String>>

    @GET("fixtures/rounds")
    suspend fun getCurrentRoundByLeagueIdAndSeason(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int,
        @Query("current") current: Boolean,
    ): Response<BaseResponse<String>>
    //endregion

    //region Fixtuers
    @GET("fixtures")
    suspend fun getFixtureById(
        @Query("timezone") timeZone: String, @Query("id") fixtureId: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesBySeasonIdByTeamId(
        @Query("timezone") timeZone: String,
        @Query("season") season: String,
        @Query("team") teamId: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesBySeasonIdAndLeagueId(
        @Query("timezone") timeZone: String,
        @Query("season") season: String,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesByDate(
        @Query("timezone") timeZone: String, @Query("date") date: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesFromDate(
        @Query("timezone") timeZone: String, @Query("from") date: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesToDate(
        @Query("timezone") timeZone: String, @Query("to") date: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesFromDateToDate(
        @Query("timezone") timeZone: String,
        @Query("season") season: String,
        @Query("team") teamId: Int,
        @Query("from") from: String,
        @Query("to") date: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesStatus(
        @Query("timezone") timeZone: String, @Query("status") fixtureStatusType: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixtureResponse>>


    //endregion

    //region Head 2 Head
    @GET("fixtures/headtohead")
    suspend fun getHeadToHead(
        @Query("h2h") teamsId: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByDate(
        @Query("h2h") teamsId: String,
        @Query("date") date: String,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatus(
        @Query("h2h") teamsId: String,
        @Query("status") status: FixtureStatus,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTO(
        @Query("h2h") teamsId: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByByDateAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("date") date: String,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatusAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("status") status: FixtureStatus,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.HeadToHeadResponse>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTOAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.HeadToHeadResponse>>
    //endregion

    //region Statistics
    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixtureStatisticsResponse>>

    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int, @Query("team") teamId: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixtureStatisticsResponse>>
    //endregion

    //region Events
    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.EventResponse>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int, @Query("team") teamId: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.EventResponse>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int,
        @Query("player") playerId: Int,
    ): Response<BaseResponse<com.cheesecake.data.remote.response.EventResponse>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int,
        @Query("player") playerId: Int,
        @Query("type") fixtureEventType: String,
    ): Response<BaseResponse<com.cheesecake.data.remote.response.EventResponse>>
    //endregion

    //region Lineups
    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<LineupResponse>>


    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int, @Query("team") teamId: Int
    ): Response<BaseResponse<LineupResponse>>

    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        @Query("fixture") fixtureId: Int, @Query("player") playerId: Int
    ): Response<BaseResponse<LineupResponse>>

    //endregion

    //region Players

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureId(
        @Query("fixture") fixtureId: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixturesResponse>>

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int, @Query("team") teamId: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.FixturesResponse>>

    //endregion

    //endregion

    //region injuries
    @GET("injuries")
    suspend fun getInjuriesByFixtureID(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.InjuriesResponse>>

    @GET("injuries")
    suspend fun getInjuriesByLeagueIDAndSeason(
        @Query("league") leagueId: Int, @Query("season") season: Int

    ): Response<BaseResponse<com.cheesecake.data.remote.response.InjuriesResponse>>

    @GET("injuries")
    suspend fun getInjuriesByTeamIDAndSeason(
        @Query("team") teamId: Int, @Query("season") season: Int

    ): Response<BaseResponse<com.cheesecake.data.remote.response.InjuriesResponse>>

    @GET("injuries")
    suspend fun getInjuriesByPlayerIDAndSeason(
        @Query("player") playerId: Int, @Query("season") season: Int

    ): Response<BaseResponse<com.cheesecake.data.remote.response.InjuriesResponse>>

    @GET("injuries")
    suspend fun getInjuriesByTimeZone(
        @Query("timezone") timeZone: String,
    ): Response<BaseResponse<com.cheesecake.data.remote.response.InjuriesResponse>>

    @GET("injuries")
    suspend fun getInjuriesByDate(
        @Query("date") date: String,
    ): Response<BaseResponse<com.cheesecake.data.remote.response.InjuriesResponse>>
    //endregion

    //region leagues
    @GET("leagues")
    suspend fun getAllLeagues(): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesById(
        @Query("id") leagueId: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByName(
        @Query("name") leagueName: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByCountryName(
        @Query("country") countryName: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByCountryCode(
        @Query("code") countryCode: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesOfSeason(
        @Query("season") season: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getLeagueByIdBySeason(
        @Query("id") leagueId: Int, @Query("season") season: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByType(
        @Query("type") type: LeagueType
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getLeaguesByTypeById(
        @Query("type") type: LeagueType, @Query("id") id: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getLeagueByTypeByIdBySeason(
        @Query("type") type: LeagueType, @Query("id") id: Int, @Query("season") season: Int
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getCurrentActiveLeagues(
        @Query("current") current: Boolean
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun searchByLeagueName(
        @Query("search") name: String
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues/seasons")
    suspend fun getLeaguesSeasons(): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    @GET("leagues")
    suspend fun getCurrentSeasonLeague(
        @Query("id") id: Int, @Query("current") current: Boolean
    ): Response<BaseResponse<com.cheesecake.data.remote.response.LeagueResponse>>

    //endregion

    //region players
    @GET("players")
    suspend fun getPlayerBySeasonByPlayerId(
        @Query("season") season: String,
        @Query("id") playerId: Int,
    ): Response<BaseResponse<PlayerResponse>>

    @GET("players")
    suspend fun getPlayerBySeasonByTeamId(
        @Query("season") season: String,
        @Query("team") teamId: Int,
    ): Response<BaseResponse<PlayerResponse>>

    @GET("players")
    suspend fun getPlayerBySeasonByLeagueId(
        @Query("season") season: String, @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerResponse>>

    @GET("players")
    suspend fun searchPlayerNameByTeamId(
        @Query("search") playerName: String, @Query("team") teamId: Int
    ): Response<BaseResponse<PlayerResponse>>

    @GET("players")
    suspend fun searchPlayerNameByLeagueId(
        @Query("search") playerName: String, @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerResponse>>

    @GET("players/seasons")
    suspend fun getPlayerSeasons(): Response<BaseResponse<Int>>

    @GET("players/squads")
    suspend fun getSquadByPlayerId(
        @Query("player") playerId: Int
    ): Response<BaseResponse<SquadResponse>>

    @GET("players/squads")
    suspend fun getSquadByTeamId(
        @Query("team") teamId: Int
    ): Response<BaseResponse<SquadResponse>>

    @GET("players/topscorers")
    suspend fun getTopScorers(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerResponse>>

    @GET("players/topassists")
    suspend fun getTopAssists(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerResponse>>

    @GET("players/topyellowcards")
    suspend fun getTopYellowCards(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerResponse>>

    @GET("players/topredcards")
    suspend fun getTopRedCards(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerResponse>>
    //endregion

    //region predictions
    @GET("predictions")
    suspend fun getPredictionsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<PredictionsResponse>>
    //endregion

    //region sidelined

    @GET("sidelined")
    suspend fun getPlayerSidelined(
        @Query("player") playerId: Int
    ): Response<BaseResponse<SidelinedResponse>>


    @GET("sidelined")
    suspend fun getCoachSidelined(
        @Query("coach") coachId: Int
    ): Response<BaseResponse<SidelinedResponse>>
    //endregion

    //region standings
    @GET("standings")
    suspend fun getStandingsByTeamId(
        @Query("season") seasonId: Int, @Query("team") teamId: Int
    ): Response<BaseResponse<StandingsResponse>>

    @GET("standings")
    suspend fun getStandingsByLeagueId(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BaseResponse<StandingsResponse>>

    @GET("standings")
    suspend fun getStandingsByTeamIdAndLeagueId(
        @Query("season") seasonId: Int, @Query("team") teamId: Int, @Query("league") leagueId: Int
    ): Response<BaseResponse<StandingsResponse>>
    //endregion

    //region teams
    @GET("teams")
    suspend fun getTeamsByLeagueAndSeason(
        @Query("league") leagueId: Int, @Query("season") seasonId: Int
    ): Response<BaseResponse<TeamInformationResponse>> @GET("teams")

    suspend fun getTeamsByName(
        @Query("name") name: String
    ): Response<BaseResponse<TeamInformationResponse>>

    @GET("teams")
    suspend fun getTeamById(
        @Query("id") teamId: Int
    ): Response<BaseResponse<TeamInformationResponse>>

    @GET("teams/statistics")
    suspend fun getTeamStatistics(
        @Query("team") teamId: Int, @Query("season") season: Int, @Query("league") leagueId: Int
    ): Response<BaseStaticResponse<TeamStatisticsResponse>>

    @GET("teams/seasons")
    suspend fun getTeamSeasons(
        @Query("team") teamId: Int
    ): Response<BaseResponse<Int>>

    @GET("teams/countries")
    suspend fun getTeamCountries(): Response<BaseResponse<TeamCountriesResponse>>
    //endregion

    //region timezone
    @GET("timezone")
    suspend fun getTimezoneList(): Response<BaseResponse<String>>
    //endregion

    //region transfers
    @GET("transfers")
    suspend fun getTransfersByPlayerId(
        @Query("id") playerId: Int
    ): Response<BaseResponse<TransferResponse>>

    @GET("transfers")
    suspend fun getTransfersByTeamId(
        @Query("team") teamId: Int
    ): Response<BaseResponse<TransferResponse>>
    //endregion

    //region trophies
    @GET("trophies")
    suspend fun getPlayerTrophies(
        @Query("player") playerId: Int
    ): Response<BaseResponse<TrophyResponse>>


    @GET("trophies")
    suspend fun getCoachTrophies(
        @Query("coach") coachId: Int
    ): Response<BaseResponse<TrophyResponse>>
    //endregion

    //region venues
    @GET("venues")
    suspend fun getVenueById(
        @Query("id") venueId: Int
    ): Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun getVenueByName(
        @Query("name") venueName: String
    ): Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun getVenuesByCityName(
        @Query("city") cityName: String
    ): Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun getVenuesByCountryName(
        @Query("country") countryName: String
    ): Response<BaseResponse<VenuesResponse>>

    @GET("venues")
    suspend fun searchVenue(
        @Query("search") name: String
    ): Response<BaseResponse<VenuesResponse>>
    //endregion

}