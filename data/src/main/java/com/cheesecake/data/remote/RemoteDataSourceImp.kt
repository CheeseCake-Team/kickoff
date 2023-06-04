package com.cheesecake.data.remote

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.base.BaseStaticResponse
import com.cheesecake.data.models.dto.CoachDTO
import com.cheesecake.data.models.dto.IjuriesDTO
import com.cheesecake.data.models.dto.LeagueDTO
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
import com.cheesecake.data.remote.api.FootballApiService
import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.utils.LeagueType
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val service: FootballApiService
) : RemoteDataSource {
    override suspend fun getFixtureById(timeZone: String, fixtureId: Int): List<FixtureResponse> {
        return wrapBaseResponse {
            service.getFixtureById(timeZone, fixtureId)
        }
    }
    //region coachs
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
    override suspend fun getAllCountries(): List<TeamCountriesDTO> {
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

    //region injuries
    override suspend fun getInjuriesByFixtureID(fixtureId: Int): List<IjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByFixtureID(fixtureId) }
    }

    override suspend fun getInjuriesByLeagueIDAndSeason(
        leagueId: Int,
        season: Int
    ): List<IjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByLeagueIDAndSeason(leagueId, season) }
    }

    override suspend fun getInjuriesByTeamIDAndSeason(teamId: Int, season: Int): List<IjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByTeamIDAndSeason(teamId, season) }
    }

    override suspend fun getInjuriesByPlayerIDAndSeason(
        playerId: Int,
        season: Int
    ): List<IjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByPlayerIDAndSeason(playerId, season) }
    }

    override suspend fun getInjuriesByTimeZone(timeZone: String): List<IjuriesDTO> {
        return wrapBaseResponse { service.getInjuriesByTimeZone(timeZone) }
    }

    override suspend fun getInjuriesByDate(date: String): List<IjuriesDTO> {
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

    override suspend fun getLeaguesByName(leagueName: String): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByName(leagueName) }
    }

    override suspend fun getLeaguesByCountryName(countryName: String): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByCountryName(countryName) }
    }


    override suspend fun getLeaguesByCountryCode(countryName: String): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByCountryCode(countryName) }
    }


    override suspend fun getLeaguesOfSeason(season: Int): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesOfSeason(season) }
    }


    override suspend fun getLeagueByIdBySeason(season: Int, leagueId: Int): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeagueByIdBySeason(season, leagueId) }
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

    override suspend fun getLeaguesSeasons(): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesSeasons() }
    }


    //endregion

    //region players
    override suspend fun getPlayerBySeasonByPlayerId(
        season: String,
        playerId: Int
    ): List<PlayerDTO> {
        return wrapBaseResponse { service.getPlayerBySeasonByPlayerId(season, playerId) }
    }

    override suspend fun getPlayerBySeasonByTeamId(season: String, teamId: Int): List<PlayerDTO> {
        return wrapBaseResponse { service.getPlayerBySeasonByTeamId(season, teamId) }
    }

    override suspend fun getPlayerBySeasonByLeagueId(
        season: String,
        leagueId: Int
    ): List<PlayerDTO> {
        return wrapBaseResponse { service.getPlayerBySeasonByLeagueId(season, leagueId) }
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

    override suspend fun getStandingsByLeagueId(seasonId: Int, leagueId: Int): List<StandingsDTO> {
        return wrapBaseResponse { service.getStandingsByLeagueId(seasonId, leagueId) }
    }

    override suspend fun getStandingsByTeamIdAndLeagueId(
        seasonId: Int,
        teamId: Int,
        leagueId: Int
    ): List<StandingsDTO> {
        return wrapBaseResponse {
            service.getStandingsByTeamIdAndLeagueId(
                seasonId,
                teamId,
                leagueId
            )
        }
    }

    //endregion

    //region teams
    override suspend fun getTeamsByLeagueAndSeason(
        leagueId: Int,
        seasonId: Int
    ): List<TeamInformationDTO> {
        return wrapBaseResponse { service.getTeamsByLeagueAndSeason(leagueId, seasonId) }
    }

    override suspend fun getTeamById(teamId: Int): List<TeamInformationDTO> {
        return wrapBaseResponse { service.getTeamById(teamId) }
    }

    override suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): List<TeamStatisticsDTO> {
        return wrapBaseStaticResponse { service.getTeamStatistics(teamId, season, leagueId) }
    }

    override suspend fun getTeamSeasons(teamId: Int): List<Int> {
        return wrapBaseResponse { service.getTeamSeasons(teamId) }
    }

    override suspend fun getTeamCountries(): List<TeamCountriesDTO> {
        return wrapBaseResponse { service.getTeamCountries() }
    }

    //endregion

    //region timezone

    override suspend fun getTimezoneList(): List<String> {
        return wrapBaseResponse { service.getTimezoneList() }
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


    //endregion



    private suspend fun <T> wrapBaseResponse(
        function: suspend () -> Response<BaseResponse<T>>,
    ): List<T> {
        val response = function()
        return if (response.isSuccessful) {
            response.body()?.response
        } else {
            throw Throwable(" Not Success Request ")
        } as List<T>
    }

    private suspend fun <T> wrapBaseStaticResponse(
        function: suspend () -> Response<BaseStaticResponse<T>>,
    ): List<T> {
        val response = function()
        return if (response.isSuccessful) {
            response.body()?.response
        } else {
            throw Throwable(" Not Success Request ")
        } as List<T>
    }
}