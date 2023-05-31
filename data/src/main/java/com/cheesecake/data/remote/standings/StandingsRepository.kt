package com.cheesecake.data.remote.standings

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.StandingsResponse
import retrofit2.Response
import javax.inject.Inject

class StandingsRepository @Inject constructor(private val standingsApiService: IStandingsApiService) {

    suspend fun getStandingsByTeamId(
        seasonId: Int,
        teamId: Int
    ): Response<BaseResponse<StandingsResponse>> {
        return standingsApiService.getStandingsByTeamId(seasonId, teamId)
    }

    suspend fun getStandingsByLeagueId(
        seasonId: Int,
        leagueId: Int
    ): Response<BaseResponse<StandingsResponse>> {
        return standingsApiService.getStandingsByLeagueId(seasonId, leagueId)
    }

    suspend fun getStandingsByTeamIdAndLeagueId(
        seasonId: Int,
        teamId: Int,
        leagueId: Int
    ): Response<BaseResponse<StandingsResponse>> {
        return standingsApiService.getStandingsByTeamIdAndLeagueId(seasonId, teamId, leagueId)
    }
}