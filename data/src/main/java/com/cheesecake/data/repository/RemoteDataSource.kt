package com.cheesecake.data.repository

import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.remote.response.LeagueResponse
import com.cheesecake.data.remote.response.LineupResponse
import com.cheesecake.data.remote.response.PlayerResponse
import com.cheesecake.data.remote.response.PredictionsResponse
import com.cheesecake.data.remote.response.SidelinedResponse
import com.cheesecake.data.remote.response.SquadResponse
import com.cheesecake.data.remote.response.StandingsResponse
import com.cheesecake.data.remote.response.TeamCountriesResponse
import com.cheesecake.data.remote.response.TeamResponse
import com.cheesecake.data.remote.response.TeamStatisticsResponse
import com.cheesecake.data.remote.response.TransferResponse
import com.cheesecake.data.remote.response.TrophyResponse
import com.cheesecake.data.remote.response.VenuesResponse
import com.cheesecake.data.utils.FixtureStatus
import com.cheesecake.data.utils.LeagueType


interface RemoteDataSource {


    //region coaches

    suspend fun getCoachById(
        playerID: Int
    ): List<com.cheesecake.data.remote.response.CoachResponse>


    suspend fun getCoachByTeam(
        teamID: Int
    ): List<com.cheesecake.data.remote.response.CoachResponse>


    suspend fun getCoachBySearch(
        getCoachName: String
    ): List<com.cheesecake.data.remote.response.CoachResponse>
    //endregion

    //region countries

    suspend fun getAllCountries(): List<TeamCountriesResponse>


    suspend fun getCountryByName(
        countryName: String
    ): List<TeamCountriesResponse>


    suspend fun getCountryByCode(
        countryCode: String
    ): List<TeamCountriesResponse>


    suspend fun searchInCountries(
        searchQuery: String
    ): List<TeamCountriesResponse>
    //endregion

    //region fixtures
    //region Rounds
    suspend fun getFixtureRounds(
        seasonId: Int, leagueId: Int
    ): List<String>


    suspend fun getCurrentRoundByLeagueIdAndSeason(
        seasonId: Int,
        leagueId: Int,
        current: Boolean,
    ): List<String>

    //endregion
    //region Fixtures
    suspend fun getFixtureById(
        timeZone: String, fixtureId: Int
    ): List<com.cheesecake.data.remote.response.FixtureResponse>

    suspend fun getFixtureBySeasonByTeamId(
        timeZone: String, season: String, TeamId: Int
    ): List<com.cheesecake.data.remote.response.FixtureResponse>

    suspend fun getFixturesBySeasonIdAndLeagueId(
        timeZone: String, season: String, leagueId: Int
    ): List<FixtureResponse>

    suspend fun getFixturesByDate(
        timeZone: String, date: String
    ): List<com.cheesecake.data.remote.response.FixtureResponse>


    suspend fun getFixturesFromDate(
        timeZone: String, date: String
    ): List<com.cheesecake.data.remote.response.FixtureResponse>

    suspend fun getFixturesToDate(
        timeZone: String, date: String
    ): List<com.cheesecake.data.remote.response.FixtureResponse>

    suspend fun getFixturesFromDateToDate(
        timeZone: String, season: String, TeamId: Int, from: String, date: String
    ): List<com.cheesecake.data.remote.response.FixtureResponse>

    suspend fun getFixturesStatus(
        timeZone: String, fixtureStatusType: String
    ): List<com.cheesecake.data.remote.response.FixtureResponse>
    //endregion
    //region Head 2 Head

    suspend fun getHeadToHead(
        teamsId: String, seasonId: Int, timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse>


    suspend fun getHeadToHeadByDate(
        teamsId: String, date: String, timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse>


    suspend fun getHeadToHeadByStatus(
        teamsId: String, status: FixtureStatus, seasonId: Int, timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse>


    suspend fun getHeadToHeadByFromAndTO(
        teamsId: String, from: String, to: String, seasonId: Int, timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse>


    suspend fun getHeadToHeadByLeague(
        teamsId: String, leagueId: Int, seasonId: Int, timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse>


    suspend fun getHeadToHeadByByDateAndLeague(
        teamsId: String, leagueId: Int, date: String, timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse>


    suspend fun getHeadToHeadByStatusAndLeague(
        teamsId: String, leagueId: Int, status: FixtureStatus, seasonId: Int, timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse>


    suspend fun getHeadToHeadByFromAndTOAndLeague(
        teamsId: String, leagueId: Int, from: String, to: String, seasonId: Int, timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse>
    //endregion
    //region Statistics

    suspend fun getFixtureStatisticsByFixtureId(
        fixtureId: Int
    ): List<com.cheesecake.data.remote.response.FixtureStatisticsResponse>


    suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        fixtureId: Int, teamId: Int
    ): List<com.cheesecake.data.remote.response.FixtureStatisticsResponse>
    //endregion
    //region Events

    suspend fun getFixtureEventsByFixtureId(
        fixtureId: Int
    ): List<com.cheesecake.data.remote.response.EventResponse>


    suspend fun getFixtureEventsByFixtureIdByTeamId(
        fixtureId: Int, teamId: Int
    ): List<com.cheesecake.data.remote.response.EventResponse>


    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        fixtureId: Int,
        teamId: Int,
        playerId: Int,
    ): List<com.cheesecake.data.remote.response.EventResponse>


    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        fixtureId: Int,
        teamId: Int,
        playerId: Int,
        fixtureEventType: String,
    ): List<com.cheesecake.data.remote.response.EventResponse>

    //endregion
    //region Lineups
    suspend fun getFixtureLineupsByFixtureId(
        fixtureId: Int
    ): List<LineupResponse>

    suspend fun getFixtureLineupsByFixtureIdByTeamId(
        fixtureId: Int, teamId: Int
    ): List<LineupResponse>

    suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        fixtureId: Int, playerId: Int
    ): List<LineupResponse>

    //endregion
    //region Players
    suspend fun getFixturePlayersByFixtureId(
        fixtureId: String
    ): List<com.cheesecake.data.remote.response.FixturesResponse>

    suspend fun getFixturePlayersByFixtureIdByTeamId(
        fixtureId: Int, teamId: Int
    ): List<com.cheesecake.data.remote.response.FixturesResponse>

    //endregion
    //endregion

    //region injuries

    suspend fun getInjuriesByFixtureID(
        fixtureId: Int
    ): List<com.cheesecake.data.remote.response.InjuriesResponse>


    suspend fun getInjuriesByLeagueIDAndSeason(
        leagueId: Int, season: Int

    ): List<com.cheesecake.data.remote.response.InjuriesResponse>


    suspend fun getInjuriesByTeamIDAndSeason(
        teamId: Int, season: Int

    ): List<com.cheesecake.data.remote.response.InjuriesResponse>


    suspend fun getInjuriesByPlayerIDAndSeason(
        playerId: Int, season: Int

    ): List<com.cheesecake.data.remote.response.InjuriesResponse>


    suspend fun getInjuriesByTimeZone(
        timeZone: String,
    ): List<com.cheesecake.data.remote.response.InjuriesResponse>


    suspend fun getInjuriesByDate(
        date: String,
    ): List<com.cheesecake.data.remote.response.InjuriesResponse>
    //endregion

    //region leagues
    suspend fun getAllLeagues(

    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getLeaguesById(
        leagueId: Int
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getLeaguesByName(
        leagueName: String
    ): List<LeagueResponse>

    suspend fun getLeaguesByCountryName(
        countryName: String
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getLeaguesByCountryCode(
        countryName: String
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getLeaguesOfSeason(
        season: Int
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getLeagueByIdAndSeason(
        season: Int, leagueId: Int
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getLeaguesByType(
        type: LeagueType
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getLeaguesByTypeById(
        type: LeagueType, id: Int
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getLeagueByTypeByIdBySeason(
        type: LeagueType, id: Int, season: Int
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getCurrentActiveLeagues(
        current: Boolean
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun searchByLeagueName(
        name: String
    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getLeaguesSeasons(

    ): List<com.cheesecake.data.remote.response.LeagueResponse>

    suspend fun getCurrentSeasonLeague(
        id: Int, current: Boolean
    ): List<com.cheesecake.data.remote.response.LeagueResponse>
    //endregion

    //region players
    suspend fun getPlayerBySeasonByPlayerId(
        season: String,
        playerId: Int,
    ): List<PlayerResponse>

    suspend fun getPlayerBySeasonByTeamId(
        season: String,
        teamId: Int,
    ): List<PlayerResponse>

    suspend fun getPlayerBySeasonByLeagueId(
        season: String, leagueId: Int
    ): List<PlayerResponse>


    suspend fun searchPlayerNameByTeamId(
        playerName: String, teamId: Int
    ): List<PlayerResponse>


    suspend fun searchPlayerNameByLeagueId(
        playerName: String, leagueId: Int
    ): List<PlayerResponse>

    suspend fun getPlayerSeasons(): List<Int>

    suspend fun getSquadByPlayerId(
        playerId: Int
    ): List<SquadResponse>

    suspend fun getSquadByTeamId(
        teamId: Int
    ): List<SquadResponse>

    suspend fun getTopScorers(
        seasonId: Int, leagueId: Int
    ): List<PlayerResponse>

    suspend fun getTopAssists(
        seasonId: Int, leagueId: Int
    ): List<PlayerResponse>


    suspend fun getTopYellowCards(
        seasonId: Int, leagueId: Int
    ): List<PlayerResponse>


    suspend fun getTopRedCards(
        seasonId: Int, leagueId: Int
    ): List<PlayerResponse>
    //endregion

    //region predictions
    suspend fun getPredictionsByFixtureId(
        fixtureId: Int
    ): List<PredictionsResponse>
    //endregion

    //region sidelined
    suspend fun getPlayerSidelined(
        playerId: Int
    ): List<SidelinedResponse>


    suspend fun getCoachSidelined(
        coachId: Int
    ): List<SidelinedResponse>
    //endregion

    //region standings
    suspend fun getStandingsByTeamId(
        seasonId: Int, teamId: Int
    ): List<StandingsResponse>

    suspend fun getStandingsByLeagueId(
        seasonId: Int, leagueId: Int
    ): List<StandingsResponse>

    suspend fun getStandingsByTeamIdAndLeagueId(
        seasonId: Int, teamId: Int, leagueId: Int
    ): List<StandingsResponse>

    //endregion

    //region teams
    suspend fun getTeamsByLeagueAndSeason(
        leagueId: Int, seasonId: Int
    ): List<TeamResponse>

    suspend fun getTeamsByName(
        name: String,
    ): List<TeamResponse>

    suspend fun getTeamById(
        teamId: Int
    ): List<TeamResponse>

    suspend fun getTeamStatistics(
        teamId: Int, season: Int, leagueId: Int
    ): TeamStatisticsResponse

    suspend fun getTeamSeasons(
        teamId: Int
    ): List<Int>

    suspend fun getTeamCountries(): List<TeamCountriesResponse>

    //endregion

    //region timezone
    suspend fun getTimezoneList(): List<String>
    //endregion

    //region transfers
    suspend fun getTransfersByPlayerId(
        playerId: Int
    ): List<TransferResponse>

    suspend fun getTransfersByTeamId(
        teamId: Int
    ): List<TransferResponse>
    //endregion

    //region trophies
    suspend fun getPlayerTrophies(
        playerId: Int
    ): List<TrophyResponse>

    suspend fun getCoachTrophies(
        coachId: Int
    ): List<TrophyResponse>

    //endregion

    //region venues
    suspend fun getVenueById(
        venueId: Int
    ): List<VenuesResponse>

    suspend fun getVenueByName(
        venueName: String
    ): List<VenuesResponse>

    suspend fun getVenuesByCityName(
        cityName: String
    ): List<VenuesResponse>

    suspend fun getVenuesByCountryName(
        countryName: String
    ): List<VenuesResponse>

    suspend fun searchVenue(
        name: String
    ): List<VenuesResponse>

    //endregion


}