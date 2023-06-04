package com.cheesecake.data.remote

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.CoachDTO
import com.cheesecake.data.models.dto.IjuriesDTO
import com.cheesecake.data.models.dto.LeagueDTO
import com.cheesecake.data.models.dto.TeamCountriesDTO
import com.cheesecake.data.models.dto.TeamInformationDTO
import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.utils.LeagueType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteDataSource {

    suspend fun getFixtureById(
        timeZone: String,
        fixtureId: Int
    ): List<FixtureResponse>

    suspend fun getFixturesBySeasonIdByTeamId(
        timeZone: String,
        season: String,
        teamId: Int

    ): List<FixtureResponse>

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