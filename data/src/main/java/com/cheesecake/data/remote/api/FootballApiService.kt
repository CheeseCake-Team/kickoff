package com.cheesecake.data.remote.api

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.base.BaseStaticResponse
import com.cheesecake.data.models.dto.CoachDTO
import com.cheesecake.data.models.dto.EventDTO
import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.models.dto.FixtureStatisticsDTO
import com.cheesecake.data.models.dto.FixturesDTO
import com.cheesecake.data.models.dto.HeadToHeadDTO
import com.cheesecake.data.models.dto.IjuriesDTO
import com.cheesecake.data.models.dto.LeagueDTO
import com.cheesecake.data.models.dto.LineupDTO
import com.cheesecake.data.models.dto.PlayerDTO
import com.cheesecake.data.models.dto.PredictionsDTO
import com.cheesecake.data.models.dto.SidelinedDTO
import com.cheesecake.data.models.dto.SquadDTO
import com.cheesecake.data.models.dto.StandingsDTO
import com.cheesecake.data.models.dto.TeamCountriesDTO
import com.cheesecake.data.models.dto.TeamInformationDTO
import com.cheesecake.data.models.dto.TeamStatisticsDTO
import com.cheesecake.data.models.dto.TransferDTO
import com.cheesecake.data.models.dto.TrophyDTO
import com.cheesecake.data.models.dto.VenuesDTO
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
    ): Response<BaseResponse<CoachDTO>>

    @GET("coachs")
    suspend fun getCoachByTeam(
        @Query("team") teamID: Int
    ): Response<BaseResponse<CoachDTO>>

    @GET("coachs")
    suspend fun getCoachBySearch(
        @Query("search") getCoachName: String
    ): Response<BaseResponse<CoachDTO>>
    //endregion

    //region countries
    @GET("countries")
    suspend fun getAllCountries(): Response<BaseResponse<TeamCountriesDTO>>

    @GET("countries")
    suspend fun getCountryByName(
        @Query("name") countryName: String
    ): Response<BaseResponse<TeamCountriesDTO>>

    @GET("countries")
    suspend fun getCountryByCode(
        @Query("code") countryCode: String
    ): Response<BaseResponse<TeamCountriesDTO>>

    @GET("countries")
    suspend fun searchInCountries(
        @Query("search") searchQuery: String
    ): Response<BaseResponse<TeamCountriesDTO>>
    //endregion

    //region fixtures
    //region Rounds
    @GET("fixtures/rounds")
    suspend fun getFixtureRounds(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<String>>

    @GET("fixtures/rounds")
    suspend fun getFixtureRoundsCurrentOnly(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int,
        @Query("current") current: Boolean,
    ): Response<BaseResponse<String>>
    //endregion

    //region Fixtuers
    @GET("fixtures")
    suspend fun getFixtureById(
        @Query("timezone") timeZone: String,
        @Query("id") fixtureId: Int
    ): Response<BaseResponse<FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesBySeasonIdByTeamId(
        @Query("timezone") timeZone: String,
        @Query("season") season: String,
        @Query("team") teamId: Int
    ): Response<BaseResponse<FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesByDate(
        @Query("timezone") timeZone: String,
        @Query("date") date: String
    ): Response<BaseResponse<FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesFromDate(
        @Query("timezone") timeZone: String,
        @Query("from") date: String
    ): Response<BaseResponse<FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesToDate(
        @Query("timezone") timeZone: String,
        @Query("to") date: String
    ): Response<BaseResponse<FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesFromDateToDate(
        @Query("timezone") timeZone: String,
        @Query("season") season: String,
        @Query("team") teamId: Int,
        @Query("from") from: String,
        @Query("to") date: String
    ): Response<BaseResponse<FixtureResponse>>

    @GET("fixtures")
    suspend fun getFixturesStatus(
        @Query("timezone") timeZone: String,
        @Query("status") fixtureStatusType: String
    ): Response<BaseResponse<FixtureResponse>>


    //endregion

    //region Head 2 Head
    @GET("fixtures/headtohead")
    suspend fun getHeadToHead(
        @Query("h2h") teamsId: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByDate(
        @Query("h2h") teamsId: String,
        @Query("date") date: String,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatus(
        @Query("h2h") teamsId: String,
        @Query("status") status: FixtureStatus,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTO(
        @Query("h2h") teamsId: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByByDateAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("date") date: String,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByStatusAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("status") status: FixtureStatus,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadDTO>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadByFromAndTOAndLeague(
        @Query("h2h") teamsId: String,
        @Query("league") leagueId: Int,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("season") seasonId: Int,
        @Query("timezone") timeZone: String
    ): Response<BaseResponse<HeadToHeadDTO>>
    //endregion

    //region Statistics
    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<FixtureStatisticsDTO>>

    @GET("fixtures/statistics")
    suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<FixtureStatisticsDTO>>
    //endregion

    //region Events
    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<EventDTO>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<EventDTO>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int,
        @Query("player") playerId: Int,
    ): Response<BaseResponse<EventDTO>>

    @GET("fixtures/events")
    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int,
        @Query("player") playerId: Int,
        @Query("type") fixtureEventType: String,
    ): Response<BaseResponse<EventDTO>>
    //endregion

    //region Lineups
    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<LineupDTO>>


    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<LineupDTO>>

    @GET("fixtures/lineups")
    suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        @Query("fixture") fixtureId: Int,
        @Query("player") playerId: Int
    ): Response<BaseResponse<LineupDTO>>

    //endregion

    //region Players

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureId(
        @Query("fixture") fixtureId: String
    ): Response<BaseResponse<FixturesDTO>>

    @GET("fixtures/players")
    suspend fun getFixturePlayersByFixtureIdByTeamId(
        @Query("fixture") fixtureId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<FixturesDTO>>

    //endregion

    //endregion

    //region injuries
    @GET("injuries")
    suspend fun getInjuriesByFixtureID(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<IjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByLeagueIDAndSeason(
        @Query("league") leagueId: Int,
        @Query("season") season: Int

    ): Response<BaseResponse<IjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByTeamIDAndSeason(
        @Query("team") teamId: Int,
        @Query("season") season: Int

    ): Response<BaseResponse<IjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByPlayerIDAndSeason(
        @Query("player") playerId: Int,
        @Query("season") season: Int

    ): Response<BaseResponse<IjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByTimeZone(
        @Query("timezone") timeZone: String,
    ): Response<BaseResponse<IjuriesDTO>>

    @GET("injuries")
    suspend fun getInjuriesByDate(
        @Query("date") date: String,
    ): Response<BaseResponse<IjuriesDTO>>
    //endregion

    //region leagues
    @GET("leagues")
    suspend fun getAllLeagues(): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesById(
        @Query("id") leagueId: Int
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByName(
        @Query("name") leagueName: String
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByCountryName(
        @Query("country") countryName: String
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByCountryCode(
        @Query("code") countryCode: String
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesOfSeason(
        @Query("season") season: Int
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeagueByIdBySeason(
        @Query("id") leagueId: Int,
        @Query("season") season: Int
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByType(
        @Query("type") type: LeagueType
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeaguesByTypeById(
        @Query("type") type: LeagueType,
        @Query("id") id: Int
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getLeagueByTypeByIdBySeason(
        @Query("type") type: LeagueType,
        @Query("id") id: Int,
        @Query("season") season: Int
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun getCurrentActiveLeagues(
        @Query("current") current: Boolean
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues")
    suspend fun searchByLeagueName(
        @Query("search") name: String
    ): Response<BaseResponse<LeagueDTO>>

    @GET("leagues/seasons")
    suspend fun getLeaguesSeasons(): Response<BaseResponse<LeagueDTO>>
    //endregion

    //region players
    @GET("players")
    suspend fun getPlayerBySeasonByPlayerId(
        @Query("season") season: String,
        @Query("id") playerId: Int,
    ): Response<BaseResponse<PlayerDTO>>

    @GET("players")
    suspend fun getPlayerBySeasonByTeamId(
        @Query("season") season: String,
        @Query("team") teamId: Int,
    ): Response<BaseResponse<PlayerDTO>>

    @GET("players")
    suspend fun getPlayerBySeasonByLeagueId(
        @Query("season") season: String,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerDTO>>

    @GET("players")
    suspend fun searchPlayerNameByTeamId(
        @Query("search") playerName: String,
        @Query("team") teamId: Int
    ): Response<BaseResponse<PlayerDTO>>

    @GET("players")
    suspend fun searchPlayerNameByLeagueId(
        @Query("search") playerName: String,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerDTO>>

    @GET("players/seasons")
    suspend fun getPlayerSeasons(): Response<BaseResponse<Int>>

    @GET("players/squads")
    suspend fun getSquadByPlayerId(
        @Query("player") playerId: Int
    ): Response<BaseResponse<SquadDTO>>

    @GET("players/squads")
    suspend fun getSquadByTeamId(
        @Query("team") teamId: Int
    ): Response<BaseResponse<SquadDTO>>

    @GET("players/topscorers")
    suspend fun getTopScorers(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerDTO>>

    @GET("players/topassists")
    suspend fun getTopAssists(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerDTO>>

    @GET("players/topyellowcards")
    suspend fun getTopYellowCards(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerDTO>>

    @GET("players/topredcards")
    suspend fun getTopRedCards(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<PlayerDTO>>
    //endregion

    //region predictions
    @GET("predictions")
    suspend fun getPredictionsByFixtureId(
        @Query("fixture") fixtureId: Int
    ): Response<BaseResponse<PredictionsDTO>>
    //endregion

    //region sidelined

    @GET("sidelined")
    suspend fun getPlayerSidelined(
        @Query("player") playerId: Int
    ): Response<BaseResponse<SidelinedDTO>>


    @GET("sidelined")
    suspend fun getCoachSidelined(
        @Query("coach") coachId: Int
    ): Response<BaseResponse<SidelinedDTO>>
    //endregion

    //region standings
    @GET("standings")
    suspend fun getStandingsByTeamId(
        @Query("season") seasonId: Int,
        @Query("team") teamId: Int
    ): Response<BaseResponse<StandingsDTO>>

    @GET("standings")
    suspend fun getStandingsByLeagueId(
        @Query("season") seasonId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<StandingsDTO>>

    @GET("standings")
    suspend fun getStandingsByTeamIdAndLeagueId(
        @Query("season") seasonId: Int,
        @Query("team") teamId: Int,
        @Query("league") leagueId: Int
    ): Response<BaseResponse<StandingsDTO>>
    //endregion

    //region teams
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
    //endregion

    //region timezone
    @GET("timezone")
    suspend fun getTimezoneList(): Response<BaseResponse<String>>
    //endregion

    //region transfers
    @GET("transfers")
    suspend fun getTransfersByPlayerId(
        @Query("id") playerId: Int
    ): Response<BaseResponse<TransferDTO>>

    @GET("transfers")
    suspend fun getTransfersByTeamId(
        @Query("team") teamId: Int
    ): Response<BaseResponse<TransferDTO>>
    //endregion

    //region trophies
    @GET("trophies")
    suspend fun getPlayerTrophies(
        @Query("player") playerId: Int
    ): Response<BaseResponse<TrophyDTO>>


    @GET("trophies")
    suspend fun getCoachTrophies(
        @Query("coach") coachId: Int
    ): Response<BaseResponse<TrophyDTO>>
    //endregion

    //region venues
    @GET("venues")
    suspend fun getVenueById(
        @Query("id") venueId: Int
    ): Response<BaseResponse<VenuesDTO>>

    @GET("venues")
    suspend fun getVenueByName(
        @Query("name") venueName: String
    ): Response<BaseResponse<VenuesDTO>>

    @GET("venues")
    suspend fun getVenuesByCityName(
        @Query("city") cityName: String
    ): Response<BaseResponse<VenuesDTO>>

    @GET("venues")
    suspend fun getVenuesByCountryName(
        @Query("country") countryName: String
    ): Response<BaseResponse<VenuesDTO>>

    @GET("venues")
    suspend fun searchVenue(
        @Query("search") name: String
    ): Response<BaseResponse<VenuesDTO>>
    //endregion

}