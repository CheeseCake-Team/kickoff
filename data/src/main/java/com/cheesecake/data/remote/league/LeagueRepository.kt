package com.cheesecake.data.remote.league

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.LeagueResponse
import retrofit2.Response
import javax.inject.Inject

class LeagueRepository @Inject constructor(private val leaguesApiService: ILeaguesApiService) {

    suspend fun getAllLeagues(): Response<BaseResponse<List<LeagueResponse>>> {
        return leaguesApiService.getAllLeagues()
    }

    suspend fun getLeaguesById(leagueId: Int): Response<BaseResponse<LeagueResponse>> {
        return leaguesApiService.getLeaguesById(leagueId)
    }

    suspend fun getLeaguesByName(leagueName: String): Response<BaseResponse<LeagueResponse>> {
        return leaguesApiService.getLeaguesByName(leagueName)
    }

    suspend fun getLeaguesByCountryName(countryName: String): Response<BaseResponse<List<LeagueResponse>>> {
        return leaguesApiService.getLeaguesByCountryName(countryName)
    }

    suspend fun getLeaguesByCountryCode(countryCode: String): Response<BaseResponse<List<LeagueResponse>>> {
        return leaguesApiService.getLeaguesByCountryCode(countryCode)
    }

    suspend fun getLeaguesOfSeason(season: Int): Response<BaseResponse<List<LeagueResponse>>> {
        return leaguesApiService.getLeaguesOfSeason(season)
    }

    suspend fun getLeagueByIdBySeason(leagueId: Int, season: Int): Response<BaseResponse<LeagueResponse>> {
        return leaguesApiService.getLeagueByIdBySeason(leagueId, season)
    }
}
