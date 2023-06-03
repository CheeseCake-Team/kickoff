package com.cheesecake.data.remote.teams

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.BaseStaticResponse
import com.cheesecake.data.models.TeamCountriesDTO
import com.cheesecake.data.models.TeamInformationResponse
import com.cheesecake.data.models.TeamStatisticsDTO
import retrofit2.Response
import javax.inject.Inject

class TeamsRepository @Inject constructor(private val teamsApiService: ITeamsApiService) {

    suspend fun getTeamsByLeagueAndSeason(
        leagueId: Int,
        seasonId: Int
    ): Response<BaseResponse<TeamInformationResponse>> {
        return teamsApiService.getTeamsByLeagueAndSeason(leagueId, seasonId)
    }

    suspend fun getTeamById(teamId: Int): Response<BaseResponse<TeamInformationResponse>> {
        return teamsApiService.getTeamById(teamId)
    }

    suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): Response<BaseStaticResponse<TeamStatisticsDTO>> {
        return teamsApiService.getTeamStatistics(teamId, season, leagueId)
    }

    suspend fun getTeamSeasons(teamId: Int): Response<BaseResponse<Int>> {
        return teamsApiService.getTeamSeasons(teamId)
    }

    suspend fun getTeamCountries(): Response<BaseResponse<TeamCountriesDTO>> {
        return teamsApiService.getTeamCountries()
    }
}





