package com.cheesecake.data.remote

import com.cheesecake.data.remote.api.FootballApiService
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
import com.cheesecake.data.remote.response.BasePagingForStaticResponse
import com.cheesecake.data.remote.response.BasePagingResponse
import com.cheesecake.data.remote.response.Error
import com.cheesecake.data.remote.utils.ErrorType
import com.cheesecake.data.remote.utils.FixtureStatus
import com.cheesecake.data.remote.utils.LeagueType
import com.cheesecake.data.repository.RemoteDataSource
import com.cheesecake.domain.KickoffException
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val service: FootballApiService
) : RemoteDataSource {

    //region coach
    override suspend fun getCoachById(playerID: Int): List<CoachDTO> {
        return wrapBaseResponse { service.getCoachById(playerID) }
    }

    override suspend fun getCoachByTeam(teamID: Int): List<CoachDTO> {
        return wrapBaseResponse { service.getCoachByTeam(teamID) }
    }

    override suspend fun getCoachBySearch(getCoachName: String): List<CoachDTO> {
        return wrapBaseResponse { service.getCoachBySearch(getCoachName) }
    }

    //endregion

    //region countries
    override suspend fun getCountries(): List<TeamCountriesDTO> {
        return wrapBaseResponse { service.getAllCountries() }
    }

    override suspend fun getCountryByName(countryName: String): List<TeamCountriesDTO> {
        return wrapBaseResponse { service.getCountryByName(countryName) }
    }

    override suspend fun getCountryByCode(countryCode: String): List<TeamCountriesDTO> {
        return wrapBaseResponse { service.getCountryByCode(countryCode) }
    }

    override suspend fun searchInCountries(searchQuery: String): List<TeamCountriesDTO> {
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
        return wrapBaseResponse {
            service.getCurrentRoundByLeagueIdAndSeason(
                leagueId,
                seasonId,
                current
            )
        }
    }

    override suspend fun getFixtureById(timeZone: String, fixtureId: Int): List<FixtureDTO> {
        return wrapBaseResponse {
            service.getFixtureById(timeZone, fixtureId)
        }
    }

    override suspend fun getFixtureBySeasonByTeamId(
        timeZone: String,
        season: Int,
        TeamId: Int
    ): List<FixtureDTO> {
        return wrapBaseResponse { service.getFixturesBySeasonIdByTeamId(timeZone, season, TeamId) }
    }

    override suspend fun getFixturesBySeasonIdAndLeagueId(
        timeZone: String,
        season: Int,
        leagueId: Int
    ): List<FixtureDTO> {
        return wrapBaseResponse {
            service.getFixturesBySeasonIdAndLeagueId(
                timeZone,
                season,
                leagueId
            )
        }
    }

    override suspend fun getFixturesByDate(timeZone: String, date: String): List<FixtureDTO> {
        return wrapBaseResponse { service.getFixturesByDate(timeZone, date) }
    }

    override suspend fun getFixturesFromDate(
        timeZone: String,
        date: String
    ): List<FixtureDTO> {
        return wrapBaseResponse { service.getFixturesFromDate(timeZone, date) }
    }

    override suspend fun getFixturesToDate(timeZone: String, date: String): List<FixtureDTO> {
        return wrapBaseResponse { service.getFixturesToDate(timeZone, date) }
    }

    override suspend fun getFixturesFromDateToDate(
        timeZone: String,
        season: String,
        TeamId: Int,
        from: String,
        date: String
    ): List<FixtureDTO> {
        return wrapBaseResponse {
            service.getFixturesFromDateToDate(
                timeZone, season, TeamId, from, date
            )
        }
    }

    override suspend fun getFixturesStatus(
        timeZone: String,
        fixtureStatusType: String
    ): List<FixtureDTO> {
        return wrapBaseResponse { service.getFixturesStatus(timeZone, fixtureStatusType) }
    }


    //endregion
    //region Head 2 Head
    override suspend fun getHeadToHead(
        teamsId: String,
        date: String,
        timeZone: String
    ): List<HeadToHeadDTO> {
        return wrapBaseResponse { service.getHeadToHeadByDate(teamsId, date, timeZone) }
    }

    override suspend fun getHeadToHeadByDate(
        teamsId: String,
        date: String,
        timeZone: String
    ): List<HeadToHeadDTO> {
        return wrapBaseResponse {
            service.getHeadToHeadByDate(
                teamsId, date, timeZone
            )
        }
    }

    override suspend fun getHeadToHeadByStatus(
        teamsId: String,
        status: FixtureStatus,
        seasonId: Int,
        timeZone: String
    ): List<HeadToHeadDTO> {
        return wrapBaseResponse {
            service.getHeadToHeadByStatus(
                teamsId, status, seasonId, timeZone
            )
        }
    }

    override suspend fun getHeadToHeadByFromAndTO(
        teamsId: String,
        from: String,
        to: String,
        seasonId: Int,
        timeZone: String
    ): List<HeadToHeadDTO> {
        return wrapBaseResponse {
            service.getHeadToHeadByFromAndTO(
                teamsId, from, to, seasonId, timeZone
            )
        }
    }

    override suspend fun getHeadToHeadByLeague(
        teamsId: String,
        leagueId: Int,
        seasonId: Int,
        timeZone: String
    ): List<HeadToHeadDTO> {
        return wrapBaseResponse {
            service.getHeadToHeadByLeague(
                teamsId, leagueId, seasonId, timeZone
            )
        }
    }

    override suspend fun getHeadToHeadByByDateAndLeague(
        teamsId: String,
        leagueId: Int,
        date: String,
        timeZone: String
    ): List<HeadToHeadDTO> {
        return wrapBaseResponse {
            service.getHeadToHeadByByDateAndLeague(
                teamsId, leagueId, date, timeZone
            )
        }
    }

    override suspend fun getHeadToHeadByStatusAndLeague(
        teamsId: String,
        leagueId: Int,
        status: FixtureStatus,
        seasonId: Int,
        timeZone: String
    ): List<HeadToHeadDTO> {
        return wrapBaseResponse {
            service.getHeadToHeadByStatusAndLeague(
                teamsId, leagueId, status, seasonId, timeZone
            )
        }
    }

    override suspend fun getHeadToHeadByFromAndTOAndLeague(
        teamsId: String,
        leagueId: Int,
        from: String,
        to: String,
        seasonId: Int,
        timeZone: String
    ): List<HeadToHeadDTO> {
        return wrapBaseResponse {
            service.getHeadToHeadByFromAndTOAndLeague(
                teamsId, leagueId, from, to, seasonId, timeZone
            )
        }
    }

    //endregion
    //region Statistics
    override suspend fun getFixtureStatisticsByFixtureId(fixtureId: Int): List<FixtureStatisticsDTO> {
        return wrapBaseResponse { service.getFixtureStatisticsByFixtureId(fixtureId) }
    }

    override suspend fun getFixtureStatisticsByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): List<FixtureStatisticsDTO> {
        return wrapBaseResponse {
            service.getFixtureStatisticsByFixtureIdByTeamId(
                fixtureId, teamId
            )
        }
    }

    //endregion
    //region Events
    override suspend fun getFixtureEventsByFixtureId(fixtureId: Int): List<EventDTO> {
        return wrapBaseResponse { service.getFixtureEventsByFixtureId(fixtureId) }
    }

    override suspend fun getFixtureEventsByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): List<EventDTO> {
        return wrapBaseResponse { service.getFixtureEventsByFixtureIdByTeamId(fixtureId, teamId) }
    }

    override suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerId(
        fixtureId: Int,
        teamId: Int,
        playerId: Int
    ): List<EventDTO> {
        return wrapBaseResponse {
            service.getFixtureEventsByFixtureIdByTeamIdByPlayerId(
                fixtureId, teamId, playerId
            )
        }
    }

    override suspend fun getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
        fixtureId: Int,
        teamId: Int,
        playerId: Int,
        fixtureEventType: String
    ): List<EventDTO> {
        return wrapBaseResponse {
            service.getFixtureEventsByFixtureIdByTeamIdByPlayerIdByType(
                fixtureId, teamId, playerId, fixtureEventType
            )
        }
    }

    //endregion
    //region LineUps
    override suspend fun getFixtureLineupsByFixtureId(fixtureId: Int): List<LineupDTO> {
        return wrapBaseResponse { service.getFixtureLineupsByFixtureId(fixtureId) }
    }

    override suspend fun getFixtureLineupsByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): List<LineupDTO> {
        return wrapBaseResponse {
            service.getFixtureLineupsByFixtureIdByTeamId(
                fixtureId, teamId
            )
        }
    }

    override suspend fun getFixtureLineupsByFixtureIdByPlayerId(
        fixtureId: Int,
        playerId: Int
    ): List<LineupDTO> {
        return wrapBaseResponse {
            service.getFixtureLineupsByFixtureIdByPlayerId(
                fixtureId,
                playerId
            )
        }
    }

    //endregion
    //region Players
    override suspend fun getFixturePlayersByFixtureId(fixtureId: String): List<FixturesDTO> {
        return wrapBaseResponse { service.getFixturePlayersByFixtureId(fixtureId) }
    }

    override suspend fun getFixturePlayersByFixtureIdByTeamId(
        fixtureId: Int,
        teamId: Int
    ): List<FixturesDTO> {
        return wrapBaseResponse { service.getFixturePlayersByFixtureIdByTeamId(fixtureId, teamId) }
    }
    //endregion
    //endregion

    //region injuries
    override suspend fun getInjuriesByFixtureID(fixtureId: Int): List<InjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByFixtureID(fixtureId) }
    }

    override suspend fun getInjuriesByLeagueIDAndSeason(
        leagueId: Int,
        season: Int
    ): List<InjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByLeagueIDAndSeason(leagueId, season) }
    }

    override suspend fun getInjuriesByTeamIDAndSeason(
        teamId: Int,
        season: Int
    ): List<InjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByTeamIDAndSeason(teamId, season) }
    }

    override suspend fun getInjuriesByPlayerIDAndSeason(
        playerId: Int,
        season: Int
    ): List<InjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByPlayerIDAndSeason(playerId, season) }
    }

    override suspend fun getInjuriesByTimeZone(timeZone: String): List<InjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByTimeZone(timeZone) }
    }

    override suspend fun getInjuriesByDate(date: String): List<InjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByDate(date) }
    }
    //endregion

    //region leagues
    override suspend fun getAllLeagues(): List<LeagueDTO> {
        return wrapBaseResponse { service.getAllLeagues() }
    }

    override suspend fun getLeaguesById(leagueId: Int): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesById(leagueId) }
    }

    override suspend fun getLeaguesByCountryCode(countryName: String): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByCountryCode(countryName) }
    }

    override suspend fun getLeaguesOfSeason(season: Int): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesOfSeason(season) }
    }

    override suspend fun getCompetitionByIdAndSeason(competitionId: Int, season: String): List<LeagueDTO> {
        return wrapBaseResponse { service.getCompetitionByIdAndSeason(competitionId, season) }
    }

    override suspend fun getLeaguesByType(type: LeagueType): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByType(type) }
    }

    override suspend fun getLeaguesByTypeById(type: LeagueType, id: Int): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByTypeById(type, id) }
    }

    override suspend fun getLeagueByTypeByIdBySeason(
        type: LeagueType,
        id: Int,
        season: Int
    ): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeagueByTypeByIdBySeason(type, id, season) }
    }

    override suspend fun getCurrentActiveLeagues(current: Boolean): List<LeagueDTO> {
        return wrapBaseResponse { service.getCurrentActiveLeagues(current) }
    }

    override suspend fun searchByLeagueName(name: String): List<LeagueDTO> {
        return wrapBaseResponse { service.searchByLeagueName(name) }
    }

    override suspend fun getAllSeasons(): List<String> {
        return wrapBaseResponse { service.getAllSeasons() }
    }

    override suspend fun getCurrentSeasonLeague(id: Int, current: Boolean): List<LeagueDTO> {
        return wrapBaseResponse { service.getCurrentSeasonLeague(id, current) }
    }

    //endregion

    //region players
    override suspend fun getPlayerBySeasonByPlayerId(
        season: Int,
        playerId: Int
    ): List<PlayerDTO> {
        return wrapBaseResponse { service.getPlayerBySeasonByPlayerId(season, playerId) }
    }

    override suspend fun getPlayerBySeasonByTeamId(
        season: String,
        teamId: Int
    ): List<PlayerDTO> {
        return wrapBaseResponse { service.getPlayerBySeasonByTeamId(season, teamId) }
    }

    override suspend fun searchPlayerNameByTeamId(
        playerName: String,
        teamId: Int
    ): List<PlayerDTO> {
        return wrapBaseResponse { service.searchPlayerNameByTeamId(playerName, teamId) }
    }

    override suspend fun searchPlayerNameByLeagueId(
        playerName: String,
        leagueId: Int
    ): List<PlayerDTO> {
        return wrapBaseResponse { service.searchPlayerNameByLeagueId(playerName, leagueId) }
    }

    override suspend fun getPlayerSeasons(): List<Int> {
        return wrapBaseResponse { service.getPlayerSeasons() }
    }

    override suspend fun getSquadByPlayerId(playerId: Int): List<SquadDTO> {
        return wrapBaseResponse { service.getSquadByPlayerId(playerId) }
    }

    override suspend fun getSquadByTeamId(teamId: Int): List<SquadDTO> {
        return wrapBaseResponse { service.getSquadByTeamId(teamId) }
    }

    override suspend fun getTopScorers(seasonId: Int, leagueId: Int): List<PlayerDTO> {
        return wrapBaseResponse { service.getTopScorers(seasonId, leagueId) }
    }

    override suspend fun getTopAssists(seasonId: Int, leagueId: Int): List<PlayerDTO> {
        return wrapBaseResponse { service.getTopAssists(seasonId, leagueId) }
    }

    override suspend fun getTopYellowCards(seasonId: Int, leagueId: Int): List<PlayerDTO> {
        return wrapBaseResponse { service.getTopYellowCards(seasonId, leagueId) }
    }

    override suspend fun getTopRedCards(seasonId: Int, leagueId: Int): List<PlayerDTO> {
        return wrapBaseResponse { service.getTopRedCards(seasonId, leagueId) }
    }
    //endregion

    //region predictions
    override suspend fun getPredictionsByFixtureId(fixtureId: Int): List<PredictionsDTO> {
        return wrapBaseResponse { service.getPredictionsByFixtureId(fixtureId) }
    }
    //endregion

    //region sidelined
    override suspend fun getPlayerSidelined(playerId: Int): List<SidelinedDTO> {
        return wrapBaseResponse { service.getPlayerSidelined(playerId) }
    }

    override suspend fun getCoachSidelined(coachId: Int): List<SidelinedDTO> {
        return wrapBaseResponse { service.getCoachSidelined(coachId) }
    }
    //endregion

    //region standings
    override suspend fun getStandingsByTeamId(seasonId: Int, teamId: Int): List<StandingsDTO> {
        return wrapBaseResponse { service.getStandingsByTeamId(seasonId, teamId) }
    }

    override suspend fun getStandingsByLeagueId(
        seasonId: Int,
        leagueId: Int
    ): List<StandingsDTO> {
        return wrapBaseResponse { service.getStandingsByLeagueId(seasonId, leagueId) }
    }

    override suspend fun getStandingsByTeamIdAndLeagueId(
        seasonId: Int,
        teamId: Int,
        leagueId: Int
    ): List<StandingsDTO> {
        return wrapBaseResponse {
            service.getStandingsByTeamIdAndLeagueId(seasonId, teamId, leagueId)
        }
    }

    //endregion

    //region teams
    override suspend fun getTeamsByLeagueAndSeason(
        leagueId: Int,
        seasonId: Int
    ): List<TeamDTO> {
        return wrapBaseResponse { service.getTeamsByLeagueAndSeason(leagueId, seasonId) }
    }

    override suspend fun getTeamsBySearch(name: String): List<TeamDTO> {
        return wrapBaseResponse { service.getTeamsBySearch(name) }
    }

    override suspend fun getLeaguesByName(leagueName: String): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByName(leagueName) }
    }

    override suspend fun getLeaguesBySearch(leagueName: String): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesBySearch(leagueName) }
    }

    override suspend fun getTeamById(teamId: Int): List<TeamDTO> {
        return wrapBaseResponse { service.getTeamById(teamId) }
    }

    override suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): TeamStatisticsDTO {
        return wrapBaseStaticResponse { service.getTeamStatistics(teamId, season, leagueId) }
    }

    override suspend fun getTeamSeasons(teamId: Int): List<Int> {
        return wrapBaseResponse { service.getTeamSeasons(teamId) }
    }

    override suspend fun getTeamsByCountryName(countryName: String): List<TeamDTO> {
        return wrapBaseResponse { service.getTeamsByCountryName(countryName) }
    }

    //endregion

    //region timezone

    override suspend fun getTimezones(): List<String> {
        return wrapBaseResponse { service.getTimezones() }
    }

    //endregion

    //region transfers
    override suspend fun getTransfersByPlayerId(playerId: Int): List<TransferDTO> {
        return wrapBaseResponse { service.getTransfersByPlayerId(playerId) }
    }

    override suspend fun getTransfersByTeamId(teamId: Int): List<TransferDTO> {
        return wrapBaseResponse { service.getTransfersByTeamId(teamId) }
    }
    //endregion

    //region trophies

    override suspend fun getPlayerTrophies(playerId: Int): List<TrophyDTO> {
        return wrapBaseResponse { service.getPlayerTrophies(playerId) }
    }

    override suspend fun getCoachTrophies(coachId: Int): List<TrophyDTO> {
        return wrapBaseResponse { service.getCoachTrophies(coachId) }
    }

    //endregion

    //region venues
    override suspend fun getVenueById(venueId: Int): List<VenuesDTO> {
        return wrapBaseResponse { service.getVenueById(venueId) }
    }

    override suspend fun getVenueByName(venueName: String): List<VenuesDTO> {
        return wrapBaseResponse { service.getVenueByName(venueName) }
    }

    override suspend fun getVenuesByCityName(cityName: String): List<VenuesDTO> {
        return wrapBaseResponse { service.getVenuesByCityName(cityName) }
    }

    override suspend fun getVenuesByCountryName(countryName: String): List<VenuesDTO> {
        return wrapBaseResponse { service.getVenuesByCountryName(countryName) }
    }

    override suspend fun searchVenue(name: String): List<VenuesDTO> {
        return wrapBaseResponse { service.searchVenue(name) }
    }

    override suspend fun getLeaguesByCountryName(countryName: String): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByCountryName(countryName) }
    }

    private suspend fun <T> wrapBaseResponse(
        response: suspend () -> Response<BasePagingResponse<T>>
    ): List<T> {
        val apiResponse = response()
        return if (apiResponse.isSuccessful) {
            val responseBody = apiResponse.body()
            responseBody?.error?.let { handleError(it) }
            responseBody?.response ?: throw KickoffException.NoDataFoundException()
        } else {
            throw KickoffException.InternalServerErrorException()
        }
    }

    private suspend fun <T> wrapBaseStaticResponse(
        response: suspend () -> Response<BasePagingForStaticResponse<T>>
    ): T {
        val apiResponse = response()
        return if (apiResponse.isSuccessful) {
            val responseBody = apiResponse.body()
            responseBody?.errors?.let { handleError(it) }
            responseBody?.response ?: throw KickoffException.NoDataFoundException()
        } else {
            throw KickoffException.InternalServerErrorException()
        }
    }

    private fun handleError(error: Error) {
        when (val errorType = error.getErrorType()) {
            ErrorType.DOMAIN_NOT_ALLOWED -> throw KickoffException.DomainNotAllowedException(
                errorType.message
            )
            ErrorType.IP_NOT_ALLOWED -> throw KickoffException.IpNotAllowedException(errorType.message)
            ErrorType.RATE_LIMIT_EXCEEDED_MINUTE -> throw KickoffException.RateLimitExceededMinuteException(
                errorType.message
            )
            ErrorType.RATE_LIMIT_EXCEEDED_DAY -> throw KickoffException.RateLimitExceededDayException(
                errorType.message
            )
            ErrorType.SHORT_SEARCH_QUERY -> throw KickoffException.ShortSearchQueryException(errorType.message)
            ErrorType.UNKNOWN_ERROR -> throw KickoffException.UnknownErrorException(errorType.message)
        }
    }
}