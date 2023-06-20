package com.cheesecake.data.repository

import com.cheesecake.data.remote.models.CoachDTO
import com.cheesecake.data.remote.models.EventDTO
import com.cheesecake.data.remote.models.FixtureDTO
import com.cheesecake.data.remote.models.FixtureStatisticsDTO
import com.cheesecake.data.remote.models.FixturesDTO
import com.cheesecake.data.remote.models.HeadToHeadDTO
import com.cheesecake.data.remote.models.InjuriesDTO
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


interface RemoteDataSource {

    suspend fun getCoachById(
        playerID: Int
    ): List<CoachDTO>


    suspend fun getCoachByTeam(
        teamID: Int
    ): List<CoachDTO>


    suspend fun getCoachBySearch(
        getCoachName: String
    ): List<CoachDTO>
    //endregion

    //region countries

    suspend fun getAllCountries(): List<TeamCountriesDTO>


    suspend fun getCountryByName(
        countryName: String
    ): List<TeamCountriesDTO>


    suspend fun getCountryByCode(
        countryCode: String
    ): List<TeamCountriesDTO>


    suspend fun searchInCountries(
        searchQuery: String
    ): List<TeamCountriesDTO>
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
    ): List<FixtureDTO>

    suspend fun getFixtureBySeasonByTeamId(
        timeZone: String, season: Int, TeamId: Int
    ): List<FixtureDTO>

    suspend fun getFixturesBySeasonIdAndLeagueId(
        timeZone: String, season: Int, leagueId: Int
    ): List<FixtureDTO>

    suspend fun getFixturesByDate(
        timeZone: String, date: String
    ): List<FixtureDTO>


    suspend fun getFixturesFromDate(
        timeZone: String, date: String
    ): List<FixtureDTO>

    suspend fun getFixturesToDate(
        timeZone: String, date: String
    ): List<FixtureDTO>

    suspend fun getFixturesFromDateToDate(
        timeZone: String, season: String, TeamId: Int, from: String, date: String
    ): List<FixtureDTO>

    suspend fun getFixturesStatus(
        timeZone: String, fixtureStatusType: String
    ): List<FixtureDTO>
    //endregion
    //region Head 2 Head

    suspend fun getHeadToHead(
        teamsId: String, date: String, timeZone: String
    ): List<HeadToHeadDTO>


    suspend fun getHeadToHeadByDate(
        teamsId: String, date: String, timeZone: String
    ): List<HeadToHeadDTO>


    suspend fun getHeadToHeadByStatus(
        teamsId: String, status: FixtureStatus, seasonId: Int, timeZone: String
    ): List<HeadToHeadDTO>


    suspend fun getHeadToHeadByFromAndTO(
        teamsId: String, from: String, to: String, seasonId: Int, timeZone: String
    ): List<HeadToHeadDTO>


    suspend fun getHeadToHeadByLeague(
        teamsId: String, leagueId: Int, seasonId: Int, timeZone: String
    ): List<HeadToHeadDTO>


    suspend fun getHeadToHeadByByDateAndLeague(
        teamsId: String, leagueId: Int, date: String, timeZone: String
    ): List<HeadToHeadDTO>


    suspend fun getHeadToHeadByStatusAndLeague(
        teamsId: String, leagueId: Int, status: FixtureStatus, seasonId: Int, timeZone: String
    ): List<HeadToHeadDTO>


    suspend fun getHeadToHeadByFromAndTOAndLeague(
        teamsId: String, leagueId: Int, from: String, to: String, seasonId: Int, timeZone: String
    ): List<HeadToHeadDTO>
    //endregion
    //region Statistics

    suspend fun getFixtureStatisticsByFixtureId(
        fixtureId: Int
    ): List<FixtureStatisticsDTO>


    suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        fixtureId: Int, teamId: Int
    ): List<FixtureStatisticsDTO>
    //endregion
    //region Events

    suspend fun getFixtureEventsByFixtureId(
        fixtureId: Int
    ): List<EventDTO>


    suspend fun getFixtureEventsByFixtureIdByTeamId(
        fixtureId: Int, teamId: Int
    ): List<EventDTO>


    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        fixtureId: Int,
        teamId: Int,
        playerId: Int,
    ): List<EventDTO>


    suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        fixtureId: Int,
        teamId: Int,
        playerId: Int,
        fixtureEventType: String,
    ): List<EventDTO>

    //endregion
    //region Lineups
    suspend fun getFixtureLineupsByFixtureId(
        fixtureId: Int
    ): List<LineupDTO>

    suspend fun getFixtureLineupsByFixtureIdByTeamId(
        fixtureId: Int, teamId: Int
    ): List<LineupDTO>

    suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        fixtureId: Int, playerId: Int
    ): List<LineupDTO>

    //endregion
    //region Players
    suspend fun getFixturePlayersByFixtureId(
        fixtureId: String
    ): List<FixturesDTO>

    suspend fun getFixturePlayersByFixtureIdByTeamId(
        fixtureId: Int, teamId: Int
    ): List<FixturesDTO>

    //endregion
    //endregion

    //region injuries

    suspend fun getInjuriesByFixtureID(
        fixtureId: Int
    ): List<InjuriesDTO>


    suspend fun getInjuriesByLeagueIDAndSeason(
        leagueId: Int, season: Int

    ): List<InjuriesDTO>


    suspend fun getInjuriesByTeamIDAndSeason(
        teamId: Int, season: Int

    ): List<InjuriesDTO>


    suspend fun getInjuriesByPlayerIDAndSeason(
        playerId: Int, season: Int

    ): List<InjuriesDTO>


    suspend fun getInjuriesByTimeZone(
        timeZone: String,
    ): List<InjuriesDTO>


    suspend fun getInjuriesByDate(
        date: String,
    ): List<InjuriesDTO>
    //endregion

    //region leagues
    suspend fun getAllLeagues(

    ): List<LeagueDTO>

    suspend fun getLeaguesById(
        leagueId: Int
    ): List<LeagueDTO>

    suspend fun getLeaguesByName(
        leagueName: String
    ): List<LeagueDTO>

    suspend fun getLeaguesBySearch(
        leagueName: String
    ): List<LeagueDTO>

    suspend fun getLeaguesByCountryName(
        countryName: String
    ): List<LeagueDTO>

    suspend fun getLeaguesByCountryCode(
        countryName: String
    ): List<LeagueDTO>

    suspend fun getLeaguesOfSeason(
        season: Int
    ): List<LeagueDTO>

    suspend fun getLeagueByIdAndSeason(
        season: Int, leagueId: Int
    ): List<LeagueDTO>

    suspend fun getLeaguesByType(
        type: LeagueType
    ): List<LeagueDTO>

    suspend fun getLeaguesByTypeById(
        type: LeagueType, id: Int
    ): List<LeagueDTO>

    suspend fun getLeagueByTypeByIdBySeason(
        type: LeagueType, id: Int, season: Int
    ): List<LeagueDTO>

    suspend fun getCurrentActiveLeagues(
        current: Boolean
    ): List<LeagueDTO>

    suspend fun searchByLeagueName(
        name: String
    ): List<LeagueDTO>

    suspend fun getLeaguesSeasons(

    ): List<LeagueDTO>

    suspend fun getCurrentSeasonLeague(
        id: Int, current: Boolean
    ): List<LeagueDTO>
    //endregion

    //region players
    suspend fun getPlayerBySeasonByPlayerId(
        season: String,
        playerId: Int,
    ): List<PlayerDTO>

    suspend fun getPlayerBySeasonByTeamId(
        season: String,
        teamId: Int,
    ): List<PlayerDTO>

    suspend fun getPlayerBySeasonByLeagueId(
        season: String, leagueId: Int
    ): List<PlayerDTO>


    suspend fun searchPlayerNameByTeamId(
        playerName: String, teamId: Int
    ): List<PlayerDTO>


    suspend fun searchPlayerNameByLeagueId(
        playerName: String, leagueId: Int
    ): List<PlayerDTO>

    suspend fun getPlayerSeasons(): List<Int>

    suspend fun getSquadByPlayerId(
        playerId: Int
    ): List<SquadDTO>

    suspend fun getSquadByTeamId(
        teamId: Int
    ): List<SquadDTO>

    suspend fun getTopScorers(
        seasonId: Int, leagueId: Int
    ): List<PlayerDTO>

    suspend fun getTopAssists(
        seasonId: Int, leagueId: Int
    ): List<PlayerDTO>


    suspend fun getTopYellowCards(
        seasonId: Int, leagueId: Int
    ): List<PlayerDTO>


    suspend fun getTopRedCards(
        seasonId: Int, leagueId: Int
    ): List<PlayerDTO>
    //endregion

    //region predictions
    suspend fun getPredictionsByFixtureId(
        fixtureId: Int
    ): List<PredictionsDTO>
    //endregion

    //region sidelined
    suspend fun getPlayerSidelined(
        playerId: Int
    ): List<SidelinedDTO>


    suspend fun getCoachSidelined(
        coachId: Int
    ): List<SidelinedDTO>
    //endregion

    //region standings
    suspend fun getStandingsByTeamId(
        seasonId: Int, teamId: Int
    ): List<StandingsDTO>

    suspend fun getStandingsByLeagueId(
        seasonId: Int, leagueId: Int
    ): List<StandingsDTO>

    suspend fun getStandingsByTeamIdAndLeagueId(
        seasonId: Int, teamId: Int, leagueId: Int
    ): List<StandingsDTO>

    //endregion

    //region teams
    suspend fun getTeamsByLeagueAndSeason(
        leagueId: Int, seasonId: Int
    ): List<TeamDTO>

    suspend fun getTeamsBySearch(
        name: String,
    ): List<TeamDTO>

    suspend fun getTeamById(
        teamId: Int
    ): List<TeamDTO>

    suspend fun getTeamStatistics(
        teamId: Int, season: Int, leagueId: Int
    ): TeamStatisticsDTO

    suspend fun getTeamSeasons(
        teamId: Int
    ): List<Int>

    suspend fun getTeamCountries(): List<TeamCountriesDTO>

    //endregion

    //region timezone
    suspend fun getTimezoneList(): List<String>
    //endregion

    //region transfers
    suspend fun getTransfersByPlayerId(
        playerId: Int
    ): List<TransferDTO>

    suspend fun getTransfersByTeamId(
        teamId: Int
    ): List<TransferDTO>
    //endregion

    //region trophies
    suspend fun getPlayerTrophies(
        playerId: Int
    ): List<TrophyDTO>

    suspend fun getCoachTrophies(
        coachId: Int
    ): List<TrophyDTO>

    //endregion

    //region venues
    suspend fun getVenueById(
        venueId: Int
    ): List<VenuesDTO>

    suspend fun getVenueByName(
        venueName: String
    ): List<VenuesDTO>

    suspend fun getVenuesByCityName(
        cityName: String
    ): List<VenuesDTO>

    suspend fun getVenuesByCountryName(
        countryName: String
    ): List<VenuesDTO>

    suspend fun searchVenue(
        name: String
    ): List<VenuesDTO>

    //endregion


}