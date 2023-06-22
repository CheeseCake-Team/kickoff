package com.cheesecake.data.remote.api

import com.cheesecake.data.remote.models.CoachDTO
import com.cheesecake.data.remote.models.EventDTO
import com.cheesecake.data.remote.models.FixtureDTO
import com.cheesecake.data.remote.models.FixtureStatisticsDTO
import com.cheesecake.data.remote.models.FixturesDTO
import com.cheesecake.data.remote.models.HeadToHeadDTO
import com.cheesecake.data.remote.models.InjuriesDTO
import com.cheesecake.data.remote.response.BasePagingResponse
import com.cheesecake.data.remote.response.BasePagingForStaticResponse
import com.cheesecake.data.remote.models.LeagueDTO
import com.cheesecake.data.remote.models.LineupDTO
import com.cheesecake.data.remote.models.PlayerDTO
import com.cheesecake.data.remote.models.PredictionsDTO
import com.cheesecake.data.remote.models.SidelinedDTO
import com.cheesecake.data.remote.models.SquadDTO
import com.cheesecake.data.remote.models.StandingsDTO
import com.cheesecake.data.remote.models.TeamCountriesDTO
import com.cheesecake.data.remote.models.TeamDTO
import com.cheesecake.data.remote.models.TeamStatisticsDTO
import com.cheesecake.data.remote.models.TransferDTO
import com.cheesecake.data.remote.models.TrophyDTO
import com.cheesecake.data.remote.models.VenuesDTO

import com.cheesecake.data.remote.utils.FixtureStatus
import com.cheesecake.data.remote.utils.LeagueType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApiService {

    //region coachs

    @GET("coachs")
    suspend fun getCoachById(
        @Query("id") playerID: Int
    ): Response<BasePagingResponse<CoachDTO>>

    @GET("coachs")
    suspend fun getCoachByTeam(
        @Query("team") teamID: Int
    ): Response<BasePagingResponse<CoachDTO>>

    @GET("coachs")
    suspend fun getCoachBySearch(
        @Query("search") getCoachName: String
    ): Response<BasePagingResponse<CoachDTO>>
    //endregion

    //region countries
    @GET("countries")
    suspend fun getAllCountries(): Response<BasePagingResponse<TeamCountriesDTO>>

    @GET("countries")
    suspend fun getCountryByName(
        @Query("name") countryName: String
    ): Response<BasePagingResponse<TeamCountriesDTO>>

    @GET("countries")
    suspend fun getCountryByCode(
        @Query("code") countryCode: String
    ): Response<BasePagingResponse<TeamCountriesDTO>>

    @GET("countries")
    suspend fun searchInCountries(
        @Query("search") searchQuery: String
    ): Response<BasePagingResponse<TeamCountriesDTO>>
    //endregion

    //region fixtures
    //region Rounds
    @GET("fixtures/rounds")
    suspend fun getFixtureRounds(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BasePagingResponse<String>>

    @GET("fixtures/rounds")
    suspend fun getCurrentRoundByLeagueIdAndSeason(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int,
        @Query("current") current: Boolean,
    ): Response<BasePagingResponse<String>>
    //endregion

    //region Fixtuers
    @GET("fixtures")
    suspend fun getFixtureById(
        @Query("timezone") timeZone: String, @Query("id") fixtureId: Int
    ): Response<BasePagingResponse<FixtureDTO>>

    @GET("fixtures")
    suspend fun getFixturesBySeasonIdByTeamId(
        @Query("timezone") timeZone: String,
        @Query("season") season: String,
        @Query("team") teamId: Int
    ): Response<BasePagingResponse<FixtureDTO>>

    @GET("fixtures")
    suspend fun getFixturesBySeasonIdAndLeagueId(
        @Query("timezone") timeZone: String,
        @Query("season") season: Int,
        @Query("league") leagueId: Int
    ): Response<BasePagingResponse<FixtureDTO>>

    @GET("fixtures")
    suspend fun getFixturesByDate(
        @Query("timezone") timeZone: String, @Query("date") date: String
    ): Response<BasePagingResponse<FixtureDTO>>

    @GET("fixtures")
    suspend fun getFixturesFromDate(
        @Query("timezone") timeZone: String, @Query("from") date: String
    ): Response<BasePagingResponse<FixtureDTO>>

    @GET("fixtures")
    suspend fun getFixturesToDate(
        @Query("timezone") timeZone: String, @Query("to") date: String
    ): Response<BasePagingResponse<FixtureDTO>>

    @GET("fixtures")
    suspend fun getFixturesFromDateToDate(
        @Query("timezone") timeZone: String,
        @Query("season") season: String,
        @Query("team") teamId: Int,
        @Query("from") from: String,
        @Query("to") date: String
    ): Response<BasePagingResponse<FixtureDTO>>

    @GET("fixtures")
    suspend fun getFixturesStatus(
        @Query("timezone") timeZone: String, @Query("status") fixtureStatusType: String
    ): Response<BasePagingResponse<FixtureDTO>>


    //endregion

    //region Head 2 Head
    @GET("fixtures/headtohead")
    suspend fun getHeadToHead(
        @Query("h2h") teamsId: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BasePagingResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByDate(
        @Query("h2h") teamsId: String,
        @Query("date") date: String,
        @Query("timezone") timeZone: String
    ): Response<BasePagingResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatus(
        @Query("h2h") teamsId: String,
        @Query("status") status: FixtureStatus,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BasePagingResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTO(
        @Query("h2h") teamsId: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BasePagingResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BasePagingResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByByDateAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("date") date: String,
        @Query("timezone") timeZone: String
    ): Response<BasePagingResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatusAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("status") status: FixtureStatus,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BasePagingResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTOAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BasePagingResponse<HeadToHeadDTO>>
    //endregion

    //region Statistics
    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BasePagingResponse<FixtureStatisticsDTO>>

    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int, @Query("team") teamId: Int
    ): Response<BasePagingResponse<FixtureStatisticsDTO>>
    //endregion

    //region Events
    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BasePagingResponse<EventDTO>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int, @Query("team") teamId: Int
    ): Response<BasePagingResponse<EventDTO>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int,
        @Query("player") playerId: Int,
    ): Response<BasePagingResponse<EventDTO>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int,
        @Query("player") playerId: Int,
        @Query("type") fixtureEventType: String,
    ): Response<BasePagingResponse<EventDTO>>
    //endregion

    //region Lineups
    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BasePagingResponse<LineupDTO>>


    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int, @Query("team") teamId: Int
    ): Response<BasePagingResponse<LineupDTO>>

    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        @Query("fixture") fixtureId: Int, @Query("player") playerId: Int
    ): Response<BasePagingResponse<LineupDTO>>

    //endregion

    //region Players

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureId(
        @Query("fixture") fixtureId: String
    ): Response<BasePagingResponse<FixturesDTO>>

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int, @Query("team") teamId: Int
    ): Response<BasePagingResponse<FixturesDTO>>

    //endregion

    //endregion

    //region injuries
    @GET("injuries")
    suspend fun getInjuriesByFixtureID(
        @Query("fixture") fixtureId: Int
    ): Response<BasePagingResponse<InjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByLeagueIDAndSeason(
        @Query("league") leagueId: Int, @Query("season") season: Int

    ): Response<BasePagingResponse<InjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByTeamIDAndSeason(
        @Query("team") teamId: Int, @Query("season") season: Int

    ): Response<BasePagingResponse<InjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByPlayerIDAndSeason(
        @Query("player") playerId: Int, @Query("season") season: Int

    ): Response<BasePagingResponse<InjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByTimeZone(
        @Query("timezone") timeZone: String,
    ): Response<BasePagingResponse<InjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByDate(
        @Query("date") date: String,
    ): Response<BasePagingResponse<InjuriesDTO>>
    //endregion

    //region leagues
    @GET("leagues")
    suspend fun getAllLeagues(): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesById(
        @Query("id") leagueId: Int
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByName(
        @Query("name") leagueName: String
    ): Response<BasePagingResponse<LeagueDTO>>


    @GET("leagues")
    suspend fun getLeaguesBySearch(
        @Query("search") leagueName: String
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByCountryName(
        @Query("country") countryName: String
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByCountryCode(
        @Query("code") countryCode: String
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesOfSeason(
        @Query("season") season: Int
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeagueByIdBySeason(
        @Query("id") leagueId: Int, @Query("season") season: Int
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByType(
        @Query("type") type: LeagueType
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByTypeById(
        @Query("type") type: LeagueType, @Query("id") id: Int
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeagueByTypeByIdBySeason(
        @Query("type") type: LeagueType, @Query("id") id: Int, @Query("season") season: Int
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getCurrentActiveLeagues(
        @Query("current") current: Boolean
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun searchByLeagueName(
        @Query("search") name: String
    ): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues/seasons")
    suspend fun getLeaguesSeasons(): Response<BasePagingResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getCurrentSeasonLeague(
        @Query("id") id: Int, @Query("current") current: Boolean
    ): Response<BasePagingResponse<LeagueDTO>>

    //endregion

    //region players
    @GET("players")
    suspend fun getPlayerBySeasonByPlayerId(
        @Query("season") season: String,
        @Query("id") playerId: Int,
    ): Response<BasePagingResponse<PlayerDTO>>

    @GET("players")
    suspend fun getPlayerBySeasonByTeamId(
        @Query("season") season: String,
        @Query("team") teamId: Int,
    ): Response<BasePagingResponse<PlayerDTO>>

    @GET("players")
    suspend fun getPlayerBySeasonByLeagueId(
        @Query("season") season: String, @Query("league") leagueId: Int
    ): Response<BasePagingResponse<PlayerDTO>>

    @GET("players")
    suspend fun searchPlayerNameByTeamId(
        @Query("search") playerName: String, @Query("team") teamId: Int
    ): Response<BasePagingResponse<PlayerDTO>>

    @GET("players")
    suspend fun searchPlayerNameByLeagueId(
        @Query("search") playerName: String, @Query("league") leagueId: Int
    ): Response<BasePagingResponse<PlayerDTO>>

    @GET("players/seasons")
    suspend fun getPlayerSeasons(): Response<BasePagingResponse<Int>>

    @GET("players/squads")
    suspend fun getSquadByPlayerId(
        @Query("player") playerId: Int
    ): Response<BasePagingResponse<SquadDTO>>

    @GET("players/squads")
    suspend fun getSquadByTeamId(
        @Query("team") teamId: Int
    ): Response<BasePagingResponse<SquadDTO>>

    @GET("players/topscorers")
    suspend fun getTopScorers(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BasePagingResponse<PlayerDTO>>

    @GET("players/topassists")
    suspend fun getTopAssists(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BasePagingResponse<PlayerDTO>>

    @GET("players/topyellowcards")
    suspend fun getTopYellowCards(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BasePagingResponse<PlayerDTO>>

    @GET("players/topredcards")
    suspend fun getTopRedCards(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BasePagingResponse<PlayerDTO>>
    //endregion

    //region predictions
    @GET("predictions")
    suspend fun getPredictionsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BasePagingResponse<PredictionsDTO>>
    //endregion

    //region sidelined

    @GET("sidelined")
    suspend fun getPlayerSidelined(
        @Query("player") playerId: Int
    ): Response<BasePagingResponse<SidelinedDTO>>


    @GET("sidelined")
    suspend fun getCoachSidelined(
        @Query("coach") coachId: Int
    ): Response<BasePagingResponse<SidelinedDTO>>
    //endregion

    //region standings
    @GET("standings")
    suspend fun getStandingsByTeamId(
        @Query("season") seasonId: Int, @Query("team") teamId: Int
    ): Response<BasePagingResponse<StandingsDTO>>

    @GET("standings")
    suspend fun getStandingsByLeagueId(
        @Query("season") seasonId: Int, @Query("league") leagueId: Int
    ): Response<BasePagingResponse<StandingsDTO>>

    @GET("standings")
    suspend fun getStandingsByTeamIdAndLeagueId(
        @Query("season") seasonId: Int, @Query("team") teamId: Int, @Query("league") leagueId: Int
    ): Response<BasePagingResponse<StandingsDTO>>
    //endregion

    //region teams
    @GET("teams")
    suspend fun getTeamsByLeagueAndSeason(
        @Query("league") leagueId: Int, @Query("season") seasonId: Int
    ): Response<BasePagingResponse<TeamDTO>> @GET("teams")

    suspend fun getTeamsBySearch(
        @Query("search") name: String,
    ): Response<BasePagingResponse<TeamDTO>>

    @GET("teams")
    suspend fun getTeamById(
        @Query("id") teamId: Int
    ): Response<BasePagingResponse<TeamDTO>>

    @GET("teams/statistics")
    suspend fun getTeamStatistics(
        @Query("team") teamId: Int, @Query("season") season: Int, @Query("league") leagueId: Int
    ): Response<BasePagingForStaticResponse<TeamStatisticsDTO>>

    @GET("teams/seasons")
    suspend fun getTeamSeasons(
        @Query("team") teamId: Int
    ): Response<BasePagingResponse<Int>>

    @GET("teams")
    suspend fun getTeamsByCountryName(@Query("country") countryName: String): Response<BasePagingResponse<TeamDTO>>

    //endregion

    //region timezone
    @GET("timezone")
    suspend fun getTimezoneList(): Response<BasePagingResponse<String>>
    //endregion

    //region transfers
    @GET("transfers")
    suspend fun getTransfersByPlayerId(
        @Query("id") playerId: Int
    ): Response<BasePagingResponse<TransferDTO>>

    @GET("transfers")
    suspend fun getTransfersByTeamId(
        @Query("team") teamId: Int
    ): Response<BasePagingResponse<TransferDTO>>
    //endregion

    //region trophies
    @GET("trophies")
    suspend fun getPlayerTrophies(
        @Query("player") playerId: Int
    ): Response<BasePagingResponse<TrophyDTO>>


    @GET("trophies")
    suspend fun getCoachTrophies(
        @Query("coach") coachId: Int
    ): Response<BasePagingResponse<TrophyDTO>>
    //endregion

    //region venues
    @GET("venues")
    suspend fun getVenueById(
        @Query("id") venueId: Int
    ): Response<BasePagingResponse<VenuesDTO>>

    @GET("venues")
    suspend fun getVenueByName(
        @Query("name") venueName: String
    ): Response<BasePagingResponse<VenuesDTO>>

    @GET("venues")
    suspend fun getVenuesByCityName(
        @Query("city") cityName: String
    ): Response<BasePagingResponse<VenuesDTO>>

    @GET("venues")
    suspend fun getVenuesByCountryName(
        @Query("country") countryName: String
    ): Response<BasePagingResponse<VenuesDTO>>

    @GET("venues")
    suspend fun searchVenue(
        @Query("search") name: String
    ): Response<BasePagingResponse<VenuesDTO>>
    //endregion

}