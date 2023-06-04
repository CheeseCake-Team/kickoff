package com.cheesecake.data.remote

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.CoachDTO
import com.cheesecake.data.models.dto.IjuriesDTO
import com.cheesecake.data.models.dto.LeagueDTO
import com.cheesecake.data.models.dto.TeamCountriesDTO
import com.cheesecake.data.remote.api.FootballApiService
import com.cheesecake.data.remote.response.FixtureResponse
import com.cheesecake.data.utils.LeagueType
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val service: FootballApiService
) : RemoteDataSource {
    override suspend fun getFixtureById(timeZone: String, fixtureId: Int): List<FixtureResponse> {
       return wrapBaseResponse { service.getFixtureById(timeZone,fixtureId)
        }
    }

    override suspend fun getFixturesBySeasonIdByTeamId(
        timeZone: String,
        season: String,
        teamId: Int
    ): List<FixtureResponse> {
        return wrapBaseResponse { service.getFixturesBySeasonIdByTeamId(timeZone,season,teamId) }
    }
    //region leagues
    override suspend fun getAllLeagues(): List<LeagueDTO> {
        return wrapBaseResponse { service.getAllLeagues()}
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
        return wrapBaseResponse { service.getLeagueByIdBySeason(season,leagueId) }
    }

    override suspend fun getLeaguesByType(type: LeagueType): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByType(type) }
    }

    override suspend fun getLeaguesByTypeById(type: LeagueType, id: Int): List<LeagueDTO> {
        return wrapBaseResponse { service.getLeaguesByTypeById(type,id) }
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
}