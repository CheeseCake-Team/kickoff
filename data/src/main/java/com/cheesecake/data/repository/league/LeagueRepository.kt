package com.cheesecake.data.repository.league

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.LeagueDTO
import com.cheesecake.data.utils.LeagueType
import retrofit2.Response
import javax.inject.Inject

class LeagueRepository @Inject constructor(private val leaguesApiService: ILeaguesApiService) {

    suspend fun getAllLeagues(): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getAllLeagues()
    }

    suspend fun getLeaguesById(leagueId: Int): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeaguesById(leagueId)
    }

    suspend fun getLeaguesByName(leagueName: String): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeaguesByName(leagueName)
    }

    suspend fun getLeaguesByCountryName(countryName: String): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeaguesByCountryName(countryName)
    }

    suspend fun getLeaguesByCountryCode(countryCode: String): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeaguesByCountryCode(countryCode)
    }

    suspend fun getLeaguesOfSeason(season: Int): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeaguesOfSeason(season)
    }

    suspend fun getLeagueByIdBySeason(
        leagueId: Int,
        season: Int
    ): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeagueByIdBySeason(leagueId, season)
    }

    suspend fun getLeaguesByType(type: LeagueType): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeaguesByType(type)
    }

    suspend fun getLeaguesByTypeById(type: LeagueType, id: Int)
            : Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeaguesByTypeById(type, id)
    }

    suspend fun getLeaguesByTypeByIdBySeason(type: LeagueType, id: Int, season: Int)
            : Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeagueByTypeByIdBySeason(type, id, season)
    }

    suspend fun getCurrentActiveLeagues(current: Boolean): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getCurrentActiveLeagues(current)
    }

    suspend fun searchLeague(name: String): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.searchByLeagueName(name)
    }

    suspend fun getLeaguesSeasons(): Response<BaseResponse<LeagueDTO>> {
        return leaguesApiService.getLeaguesSeasons()
    }
}
