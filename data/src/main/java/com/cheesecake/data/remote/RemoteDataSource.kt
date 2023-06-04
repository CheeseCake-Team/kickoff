package com.cheesecake.data.remote

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
import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.utils.LeagueType


interface RemoteDataSource {

    suspend fun getFixtureById(
        timeZone: String,
        fixtureId: Int
    ): List<FixtureResponse>

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
        season: String,
        leagueId: Int
    ): List<PlayerDTO>


    suspend fun searchPlayerNameByTeamId(
        playerName: String,
        teamId: Int
    ): List<PlayerDTO>


    suspend fun searchPlayerNameByLeagueId(
        playerName: String,
        leagueId: Int
    ): List<PlayerDTO>

    suspend fun getPlayerSeasons(): List<Int>

    suspend fun getSquadByPlayerId(
        playerId: Int
    ): List<SquadDTO>

    suspend fun getSquadByTeamId(
        teamId: Int
    ): List<SquadDTO>

    suspend fun getTopScorers(
        seasonId: Int,
        leagueId: Int
    ): List<PlayerDTO>

    suspend fun getTopAssists(
        seasonId: Int,
        leagueId: Int
    ): List<PlayerDTO>


    suspend fun getTopYellowCards(
        seasonId: Int,
        leagueId: Int
    ): List<PlayerDTO>


    suspend fun getTopRedCards(
        seasonId: Int,
        leagueId: Int
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
        seasonId: Int,
        teamId: Int
    ): List<StandingsDTO>

    suspend fun getStandingsByLeagueId(
        seasonId: Int,
        leagueId: Int
    ): List<StandingsDTO>

    suspend fun getStandingsByTeamIdAndLeagueId(
        seasonId: Int,
        teamId: Int,
        leagueId: Int
    ): List<StandingsDTO>

    //endregion

    //region teams
    suspend fun getTeamsByLeagueAndSeason(
        leagueId: Int,
        seasonId: Int
    ): List<TeamInformationDTO>

    suspend fun getTeamById(
        teamId: Int
    ): List<TeamInformationDTO>

    suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): List<TeamStatisticsDTO>

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

    //region leagues
    suspend fun getAllLeagues(

    ): List<LeagueDTO>

    suspend fun getLeaguesById(
        leagueId: Int
    ): List<LeagueDTO>

    suspend fun getLeaguesByName(
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

    suspend fun getLeagueByIdBySeason(
        season: Int,
        leagueId: Int
    ): List<LeagueDTO>

    suspend fun getLeaguesByType(
        type: LeagueType
    ): List<LeagueDTO>

    suspend fun getLeaguesByTypeById(
        type: LeagueType,
        id: Int
    ): List<LeagueDTO>

    suspend fun getLeagueByTypeByIdBySeason(
        type: LeagueType,
        id: Int,
        season: Int
    ): List<LeagueDTO>

    suspend fun getCurrentActiveLeagues(
        current: Boolean
    ): List<LeagueDTO>

    suspend fun searchByLeagueName(
        name: String
    ): List<LeagueDTO>

    suspend fun getLeaguesSeasons(

    ): List<LeagueDTO>
    //endregion
    //region coachs

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
    //region injuries

    suspend fun getInjuriesByFixtureID(
        fixtureId: Int
    ): List<IjuriesDTO>


    suspend fun getInjuriesByLeagueIDAndSeason(
        leagueId: Int,
        season: Int

    ): List<IjuriesDTO>


    suspend fun getInjuriesByTeamIDAndSeason(
        teamId: Int,
        season: Int

    ): List<IjuriesDTO>


    suspend fun getInjuriesByPlayerIDAndSeason(
        playerId: Int,
        season: Int

    ): List<IjuriesDTO>


    suspend fun getInjuriesByTimeZone(
        timeZone: String,
    ): List<IjuriesDTO>


    suspend fun getInjuriesByDate(
        date: String,
    ): List<IjuriesDTO>
    //endregion

}