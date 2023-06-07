package com.cheesecake.data.remote

import com.cheesecake.data.remote.response.BaseResponse
import com.cheesecake.data.remote.response.BaseStaticResponse
import com.cheesecake.data.remote.api.FootballApiService
import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.repository.RemoteDataSource
import com.cheesecake.data.remote.response.LeagueResponse
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
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val service: FootballApiService
) : RemoteDataSource {

    //region coachs
    override suspend fun getCoachById(playerID: Int): List<com.cheesecake.data.remote.response.CoachResponse> {
        return wrapBaseResponse { service.getCoachById(playerID) }
    }

    override suspend fun getCoachByTeam(teamID: Int): List<com.cheesecake.data.remote.response.CoachResponse> {
        return wrapBaseResponse { service.getCoachByTeam(teamID) }
    }

    override suspend fun getCoachBySearch(getCoachName: String): List<com.cheesecake.data.remote.response.CoachResponse> {
        return wrapBaseResponse { service.getCoachBySearch(getCoachName) }
    }


    //endregion

    //region countries
    override suspend fun getAllCountries(): List<TeamCountriesResponse> {
        return wrapBaseResponse { service.getAllCountries() }
    }

    override suspend fun getCountryByName(countryName: String): List<TeamCountriesResponse> {
        return wrapBaseResponse { service.getCountryByName(countryName) }
    }

    override suspend fun getCountryByCode(countryCode: String): List<TeamCountriesResponse> {
        return wrapBaseResponse { service.getCountryByCode(countryCode) }
    }

    override suspend fun searchInCountries(searchQuery: String): List<TeamCountriesResponse> {
        return wrapBaseResponse { service.searchInCountries(searchQuery) }
    }


    //endregion

    //region fixtures
    //region Rounds
    override suspend fun getFixtureRounds(seasonId: Int, leagueId: Int): List<String> {
        return wrapBaseResponse { service.getFixtureRounds(seasonId, leagueId) }
    }

    override suspend fun getCurrentRoundByLeagueIdAndSeason(
        seasonId: Int,
        leagueId: Int,
        current: Boolean
    ): List<String> {
        return wrapBaseResponse { service.getCurrentRoundByLeagueIdAndSeason(leagueId, seasonId, current) }
    }


//    override suspend fun getFixtureRoundsCurrentOnly(
//        seasonId: Int,
//        leagueId: Int,
//        current: Boolean
//    ): List<String> {
//        return wrapBaseResponse { service.getFixtureRoundsCurrentOnly(seasonId, leagueId, current) }
//    }
    //endregion
    //region Fixtuers
    override suspend fun getFixtureById(timeZone: String, fixtureId: Int): List<com.cheesecake.data.remote.response.FixtureResponse> {
        return wrapBaseResponse { service.getFixtureById(timeZone,fixtureId)
        }
    }

    override suspend fun getFixtureBySeasonByTeamId(
        timeZone: String,
        season: String,
        TeamId: Int
    ): List<com.cheesecake.data.remote.response.FixtureResponse> {
        return wrapBaseResponse { service.getFixturesBySeasonIdByTeamId(timeZone, season, TeamId) }
    }

    override suspend fun getFixturesBySeasonIdAndLeagueId(
        timeZone: String,
        season: String,
        leagueId: Int
    ): List<FixtureResponse> {
        return wrapBaseResponse { service.getFixturesBySeasonIdAndLeagueId(timeZone, season, leagueId) }
    }

    override suspend fun getFixturesByDate(timeZone: String, date: String): List<FixtureResponse> {
        return wrapBaseResponse { service.getFixturesByDate(timeZone, date) }
    }

    override suspend fun getFixturesFromDate(
        timeZone: String,
        date: String
    ): List<com.cheesecake.data.remote.response.FixtureResponse> {
        return wrapBaseResponse { service.getFixturesFromDate(timeZone, date) }
    }

    override suspend fun getFixturesToDate(timeZone: String, date: String): List<com.cheesecake.data.remote.response.FixtureResponse> {
        return wrapBaseResponse { service.getFixturesToDate(timeZone, date) }
    }

    override suspend fun getFixturesFromDateToDate(
        timeZone: String,
        season: String,
        TeamId: Int,
        from: String,
        date: String
    ): List<com.cheesecake.data.remote.response.FixtureResponse> {
        return wrapBaseResponse { service.getFixturesFromDateToDate(
            timeZone, season, TeamId,from,date) }
    }

    override suspend fun getFixturesStatus(
        timeZone: String,
        fixtureStatusType: String
    ): List<com.cheesecake.data.remote.response.FixtureResponse> {
        return wrapBaseResponse { service.getFixturesStatus(timeZone, fixtureStatusType) }
    }


    //endregion
    //region Head 2 Head
    override suspend fun getHeadToHead(
        teamsId: String,
        seasonId: Int,
        timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse> {
        return wrapBaseResponse { service.getHeadToHead(teamsId, seasonId, timeZone) }
    }

    override suspend fun getHeadToHeadByDate(
        teamsId: String,
        date: String,
        timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse> {
        return wrapBaseResponse { service.getHeadToHeadByDate(
            teamsId, date, timeZone) }
    }

    override suspend fun getHeadToHeadByStatus(
        teamsId: String,
        status: FixtureStatus,
        seasonId: Int,
        timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse> {
        return wrapBaseResponse { service.getHeadToHeadByStatus(
            teamsId, status, seasonId, timeZone) }
    }

    override suspend fun getHeadToHeadByFromAndTO(
        teamsId: String,
        from: String,
        to: String,
        seasonId: Int,
        timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse> {
        return wrapBaseResponse { service.getHeadToHeadByFromAndTO(
            teamsId, from, to, seasonId, timeZone) }
    }

    override suspend fun getHeadToHeadByLeague(
        teamsId: String,
        leagueId: Int,
        seasonId: Int,
        timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse> {
        return wrapBaseResponse { service.getHeadToHeadByLeague(
            teamsId, leagueId, seasonId, timeZone) }
    }

    override suspend fun getHeadToHeadByByDateAndLeague(
        teamsId: String,
        leagueId: Int,
        date: String,
        timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse> {
        return wrapBaseResponse { service.getHeadToHeadByByDateAndLeague(
            teamsId, leagueId, date, timeZone) }
    }

    override suspend fun getHeadToHeadByStatusAndLeague(
        teamsId: String,
        leagueId: Int,
        status: FixtureStatus,
        seasonId: Int,
        timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse> {
        return wrapBaseResponse { service.getHeadToHeadByStatusAndLeague(
            teamsId, leagueId, status, seasonId, timeZone) }
    }

    override suspend fun getHeadToHeadByFromAndTOAndLeague(
        teamsId: String,
        leagueId: Int,
        from: String,
        to: String,
        seasonId: Int,
        timeZone: String
    ): List<com.cheesecake.data.remote.response.HeadToHeadResponse> {
        return wrapBaseResponse { service.getHeadToHeadByFromAndTOAndLeague(
            teamsId, leagueId, from, to, seasonId, timeZone) }
    }
    //endregion
    //region Statistics
    override suspend fun getFixtureStatisticsByFixtureId(fixtureId: Int): List<com.cheesecake.data.remote.response.FixtureStatisticsResponse> {
        return wrapBaseResponse { service.getFixtureStatisticsByFixtureId(fixtureId) }
    }

    override suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): List<com.cheesecake.data.remote.response.FixtureStatisticsResponse> {
        return wrapBaseResponse { service.getFixtureStatisticsByFixtureIdByTeamId(
            fixtureId, teamId) }
    }
    //endregion
    //region Events
    override suspend fun getFixtureEventsByFixtureId(fixtureId: Int): List<com.cheesecake.data.remote.response.EventResponse> {
        return wrapBaseResponse { service.getFixtureEventsByFixtureId(fixtureId) }
    }

    override suspend fun getFixtureEventsByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): List<com.cheesecake.data.remote.response.EventResponse> {
        return wrapBaseResponse { service.getFixtureEventsByFixtureIdByTeamId(fixtureId, teamId) }
    }

    override suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        fixtureId: Int,
        teamId: Int,
        playerId: Int
    ): List<com.cheesecake.data.remote.response.EventResponse> {
        return wrapBaseResponse { service.getFixtureEventsByFixtureIdByTeamIdByPlayerId(
            fixtureId, teamId, playerId) }
    }

    override suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        fixtureId: Int,
        teamId: Int,
        playerId: Int,
        fixtureEventType: String
    ): List<com.cheesecake.data.remote.response.EventResponse> {
        return wrapBaseResponse { service.getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
            fixtureId, teamId, playerId, fixtureEventType) }
    }
    //endregion
    //region LineUps
    override suspend fun getFixtureLineupsByFixtureId(fixtureId: Int): List<LineupResponse> {
        return wrapBaseResponse { service.getFixtureLineupsByFixtureId(fixtureId) }
    }

    override suspend fun getFixtureLineupsByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): List<LineupResponse> {
        return wrapBaseResponse { service.getFixtureLineupsByFixtureIdByTeamId(
            fixtureId, teamId) }
    }

    override suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        fixtureId: Int,
        playerId: Int
    ): List<LineupResponse> {
        return wrapBaseResponse { service.getFixtureLineupsByFixtureIdByPlayerId(fixtureId, playerId) }
    }
    //endregion
    //region Players
    override suspend fun getFixturePlayersByFixtureId(fixtureId: String): List<com.cheesecake.data.remote.response.FixturesResponse> {
        return wrapBaseResponse { service.getFixturePlayersByFixtureId(fixtureId) }
    }

    override suspend fun getFixturePlayersByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): List<com.cheesecake.data.remote.response.FixturesResponse> {
        return wrapBaseResponse { service.getFixturePlayersByFixtureIdByTeamId(fixtureId, teamId) }
    }
    //endregion
    //endregion

    //region injuries
    override suspend fun getInjuriesByFixtureID(fixtureId: Int): List<com.cheesecake.data.remote.response.InjuriesResponse> {
        return wrapBaseResponse { service.getInjuriesByFixtureID(fixtureId) }
    }

    override suspend fun getInjuriesByLeagueIDAndSeason(
        leagueId: Int,
        season: Int
    ): List<com.cheesecake.data.remote.response.InjuriesResponse> {
        return wrapBaseResponse { service.getInjuriesByLeagueIDAndSeason(leagueId, season) }
    }

    override suspend fun getInjuriesByTeamIDAndSeason(teamId: Int, season: Int): List<com.cheesecake.data.remote.response.InjuriesResponse> {
        return wrapBaseResponse { service.getInjuriesByTeamIDAndSeason(teamId, season) }
    }

    override suspend fun getInjuriesByPlayerIDAndSeason(
        playerId: Int,
        season: Int
    ): List<com.cheesecake.data.remote.response.InjuriesResponse> {
        return wrapBaseResponse { service.getInjuriesByPlayerIDAndSeason(playerId, season) }
    }

    override suspend fun getInjuriesByTimeZone(timeZone: String): List<com.cheesecake.data.remote.response.InjuriesResponse> {
        return wrapBaseResponse { service.getInjuriesByTimeZone(timeZone) }
    }

    override suspend fun getInjuriesByDate(date: String): List<com.cheesecake.data.remote.response.InjuriesResponse> {
        return wrapBaseResponse { service.getInjuriesByDate(date) }
    }
    //endregion

    //region leagues
    override suspend fun getAllLeagues(): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getAllLeagues() }
    }

    override suspend fun getLeaguesById(leagueId: Int): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getLeaguesById(leagueId) }
    }

    override suspend fun getLeaguesByName(leagueName: String): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getLeaguesByName(leagueName) }
    }

    override suspend fun getLeaguesByCountryName(countryName: String): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getLeaguesByCountryName(countryName) }
    }


    override suspend fun getLeaguesByCountryCode(countryName: String): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getLeaguesByCountryCode(countryName) }
    }


    override suspend fun getLeaguesOfSeason(season: Int): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getLeaguesOfSeason(season) }
    }


    override suspend fun getLeagueByIdAndSeason(season: Int, leagueId: Int): List<LeagueResponse> {
        return wrapBaseResponse { service.getLeagueByIdBySeason(season, leagueId) }
    }

    override suspend fun getLeaguesByType(type: LeagueType): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getLeaguesByType(type) }
    }

    override suspend fun getLeaguesByTypeById(type: LeagueType, id: Int): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getLeaguesByTypeById(type, id) }
    }

    override suspend fun getLeagueByTypeByIdBySeason(
        type: LeagueType,
        id: Int,
        season: Int
    ): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getLeagueByTypeByIdBySeason(type, id, season) }
    }

    override suspend fun getCurrentActiveLeagues(current: Boolean): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getCurrentActiveLeagues(current) }
    }

    override suspend fun searchByLeagueName(name: String): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.searchByLeagueName(name) }
    }

    override suspend fun getLeaguesSeasons(): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getLeaguesSeasons() }
    }

    override suspend fun getCurrentSeasonLeague(id: Int, current: Boolean): List<com.cheesecake.data.remote.response.LeagueResponse> {
        return wrapBaseResponse { service.getCurrentSeasonLeague(id, current) }
    }


    //endregion

    //region players
    override suspend fun getPlayerBySeasonByPlayerId(
        season: String,
        playerId: Int
    ): List<PlayerResponse> {
        return wrapBaseResponse { service.getPlayerBySeasonByPlayerId(season, playerId) }
    }

    override suspend fun getPlayerBySeasonByTeamId(season: String, teamId: Int): List<PlayerResponse> {
        return wrapBaseResponse { service.getPlayerBySeasonByTeamId(season, teamId) }
    }

    override suspend fun getPlayerBySeasonByLeagueId(
        season: String,
        leagueId: Int
    ): List<PlayerResponse> {
        return wrapBaseResponse { service.getPlayerBySeasonByLeagueId(season, leagueId) }
    }

    override suspend fun searchPlayerNameByTeamId(
        playerName: String,
        teamId: Int
    ): List<PlayerResponse> {
        return wrapBaseResponse { service.searchPlayerNameByTeamId(playerName, teamId) }
    }

    override suspend fun searchPlayerNameByLeagueId(
        playerName: String,
        leagueId: Int
    ): List<PlayerResponse> {
        return wrapBaseResponse { service.searchPlayerNameByLeagueId(playerName, leagueId) }
    }

    override suspend fun getPlayerSeasons(): List<Int> {
        return wrapBaseResponse { service.getPlayerSeasons() }
    }

    override suspend fun getSquadByPlayerId(playerId: Int): List<SquadResponse> {
        return wrapBaseResponse { service.getSquadByPlayerId(playerId) }
    }

    override suspend fun getSquadByTeamId(teamId: Int): List<SquadResponse> {
        return wrapBaseResponse { service.getSquadByTeamId(teamId) }
    }

    override suspend fun getTopScorers(seasonId: Int, leagueId: Int): List<PlayerResponse> {
        return wrapBaseResponse { service.getTopScorers(seasonId, leagueId) }
    }

    override suspend fun getTopAssists(seasonId: Int, leagueId: Int): List<PlayerResponse> {
        return wrapBaseResponse { service.getTopAssists(seasonId, leagueId) }
    }

    override suspend fun getTopYellowCards(seasonId: Int, leagueId: Int): List<PlayerResponse> {
        return wrapBaseResponse { service.getTopYellowCards(seasonId, leagueId) }
    }

    override suspend fun getTopRedCards(seasonId: Int, leagueId: Int): List<PlayerResponse> {
        return wrapBaseResponse { service.getTopRedCards(seasonId, leagueId) }
    }
    //endregion

    //region predictions
    override suspend fun getPredictionsByFixtureId(fixtureId: Int): List<PredictionsResponse> {
        return wrapBaseResponse { service.getPredictionsByFixtureId(fixtureId) }
    }
    //endregion

    //region sidelined
    override suspend fun getPlayerSidelined(playerId: Int): List<SidelinedResponse> {
        return wrapBaseResponse { service.getPlayerSidelined(playerId) }
    }

    override suspend fun getCoachSidelined(coachId: Int): List<SidelinedResponse> {
        return wrapBaseResponse { service.getCoachSidelined(coachId) }
    }
    //endregion

    //region standings
    override suspend fun getStandingsByTeamId(seasonId: Int, teamId: Int): List<StandingsResponse> {
        return wrapBaseResponse { service.getStandingsByTeamId(seasonId, teamId) }
    }

    override suspend fun getStandingsByLeagueId(seasonId: Int, leagueId: Int): List<StandingsResponse> {
        return wrapBaseResponse { service.getStandingsByLeagueId(seasonId, leagueId) }
    }

    override suspend fun getStandingsByTeamIdAndLeagueId(
        seasonId: Int,
        teamId: Int,
        leagueId: Int
    ): List<StandingsResponse> {
        return wrapBaseResponse { service.getStandingsByTeamIdAndLeagueId(seasonId, teamId, leagueId)
        }
    }

    //endregion

    //region teams
    override suspend fun getTeamsByLeagueAndSeason(
        leagueId: Int,
        seasonId: Int
    ): List<TeamInformationResponse> {
        return wrapBaseResponse { service.getTeamsByLeagueAndSeason(leagueId, seasonId) }
    }

    override suspend fun getTeamById(teamId: Int): List<TeamInformationResponse> {
        return wrapBaseResponse { service.getTeamById(teamId) }
    }

    override suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): TeamStatisticsResponse {
        return wrapBaseStaticResponse { service.getTeamStatistics(teamId, season, leagueId) }
    }

    override suspend fun getTeamSeasons(teamId: Int): List<Int> {
        return wrapBaseResponse { service.getTeamSeasons(teamId) }
    }

    override suspend fun getTeamCountries(): List<TeamCountriesResponse> {
        return wrapBaseResponse { service.getTeamCountries() }
    }

    //endregion

    //region timezone

    override suspend fun getTimezoneList(): List<String> {
        return wrapBaseResponse { service.getTimezoneList() }
    }

    //endregion

    //region transfers
    override suspend fun getTransfersByPlayerId(playerId: Int): List<TransferResponse> {
        return wrapBaseResponse { service.getTransfersByPlayerId(playerId) }
    }

    override suspend fun getTransfersByTeamId(teamId: Int): List<TransferResponse> {
        return wrapBaseResponse { service.getTransfersByTeamId(teamId) }
    }
    //endregion

    //region trophies

    override suspend fun getPlayerTrophies(playerId: Int): List<TrophyResponse> {
        return wrapBaseResponse { service.getPlayerTrophies(playerId) }
    }

    override suspend fun getCoachTrophies(coachId: Int): List<TrophyResponse> {
        return wrapBaseResponse { service.getCoachTrophies(coachId) }
    }

    //endregion

    //region venues
    override suspend fun getVenueById(venueId: Int): List<VenuesResponse> {
        return wrapBaseResponse { service.getVenueById(venueId) }
    }

    override suspend fun getVenueByName(venueName: String): List<VenuesResponse> {
        return wrapBaseResponse { service.getVenueByName(venueName) }
    }

    override suspend fun getVenuesByCityName(cityName: String): List<VenuesResponse> {
        return wrapBaseResponse { service.getVenuesByCityName(cityName) }
    }

    override suspend fun getVenuesByCountryName(countryName: String): List<VenuesResponse> {
        return wrapBaseResponse { service.getVenuesByCountryName(countryName) }
    }

    override suspend fun searchVenue(name: String): List<VenuesResponse> {
        return wrapBaseResponse { service.searchVenue(name) }
    }


    //endregion


    private suspend fun <T> wrapBaseResponse(
        function: suspend () -> Response<BaseResponse<T>>,
    ): List<T> {
        val response = function()
        return if (response.isSuccessful) {
            response.body()?.response!!
        } else {
            throw Throwable(" Not Success Request ")
        }
    }


    private suspend fun <T> wrapBaseStaticResponse(
        function: suspend () -> Response<BaseStaticResponse<T>>,
    ): T {
        val response = function()
        return if (response.isSuccessful) {
            response.body()?.response!!
        } else {
            throw Throwable(" Not Success Request ")
        }
    }
}