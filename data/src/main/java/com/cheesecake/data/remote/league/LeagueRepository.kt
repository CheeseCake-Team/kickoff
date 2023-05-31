package com.cheesecake.data.remote.league

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.LeagueResponse
import com.cheesecake.data.utils.LeagueType
import retrofit2.Response
import javax.inject.Inject

class LeagueRepository @Inject constructor(private val leaguesApiService: ILeaguesApiService) {

    suspend fun getAllLeagues(): Response<BaseResponse<LeagueResponse>> {
        return leaguesApiService.getAllLeagues()
    }

    suspend fun getLeaguesById(leagueId: Int): Response<BaseResponse<LeagueResponse>> {
        return leaguesApiService.getLeaguesById(leagueId)
    }

    suspend fun getLeaguesByName(leagueName: String): Response<BaseResponse<LeagueResponse>> {
        return leaguesApiService.getLeaguesByName(leagueName)
    }

    suspend fun getLeaguesByCountryName(countryName: String): Response<BaseResponse<LeagueResponse>> {
        return leaguesApiService.getLeaguesByCountryName(countryName)
    }

    suspend fun getLeaguesByCountryCode(countryCode: String): Response<BaseResponse<LeagueResponse>>{
        return leaguesApiService.getLeaguesByCountryCode(countryCode)
    }

    suspend fun getLeaguesOfSeason(season: Int): Response<BaseResponse<LeagueResponse>> {
        return leaguesApiService.getLeaguesOfSeason(season)
    }

    suspend fun getLeagueByIdBySeason(leagueId: Int, season: Int): Response<BaseResponse<LeagueResponse>> {
        return leaguesApiService.getLeagueByIdBySeason(leagueId, season)
    }

    suspend fun getLeaguesByType(type: LeagueType): Response<BaseResponse<LeagueResponse>>{
        return leaguesApiService.getLeaguesByType(type)
    }

    suspend fun getLeaguesByTypeById(type: LeagueType, id: Int)
    : Response<BaseResponse<LeagueResponse>>{
        return leaguesApiService.getLeaguesByTypeById(type, id)
    }

    suspend fun getLeaguesByTypeByIdBySeason(type: LeagueType, id: Int, season: Int)
    : Response<BaseResponse<LeagueResponse>>{
        return leaguesApiService.getLeagueByTypeByIdBySeason(type, id, season)
    }

    suspend fun getCurrentActiveLeagues(current: Boolean): Response<BaseResponse<LeagueResponse>>{
        return leaguesApiService.getCurrentActiveLeagues(current)
    }

    suspend fun searchLeague(name: String): Response<BaseResponse<LeagueResponse>>{
        return leaguesApiService.searchByLeagueName(name)
    }

    suspend fun getLeaguesSeasons(): Response<BaseResponse<LeagueResponse>>{
        return leaguesApiService.getLeaguesSeasons()
    }
}
