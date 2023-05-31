package com.cheesecake.data.remote.teams

import com.cheesecake.data.di.DefaultDispatcher
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.LocalTeam
import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.BaseStaticResponse
import com.cheesecake.data.models.TeamCountries
import com.cheesecake.data.models.TeamInformationResponse
import com.cheesecake.data.models.TeamStatisticsResponse
import com.cheesecake.data.models.toLocal
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class TeamsRepository @Inject constructor(
    private val teamsApiService: ITeamsApiService,
    private val teamsDao: TeamsDao,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
    ) {

    suspend fun getTeamsByLeagueAndSeason(
        leagueId: Int,
        seasonId: Int
    ): Flow<List<LocalTeam>> {
        refresh(leagueId, seasonId)
        return teamsDao.observeAll()
    }
    private suspend fun refresh(leagueId: Int, seasonId: Int) {
            withContext(defaultDispatcher) {
                val remoteTeams= teamsApiService.getTeamsByLeagueAndSeason(leagueId, seasonId)
                teamsDao.deleteAll()
                remoteTeams.body()?.response?.let { teamInformation ->
                    teamsDao.upsertAll(teamInformation.map {
                        it.toLocal()
                    })
                }
            }

    }

    suspend fun getTeamById(teamId: Int): Response<BaseResponse<TeamInformationResponse>> {
        return teamsApiService.getTeamById(teamId)
    }

    suspend fun getTeamStatistics(
        teamId: Int,
        season: Int,
        leagueId: Int
    ): Response<BaseStaticResponse<TeamStatisticsResponse>> {
        return teamsApiService.getTeamStatistics(teamId, season, leagueId)
    }

    suspend fun getTeamSeasons(teamId: Int): Response<BaseResponse<Int>> {
        return teamsApiService.getTeamSeasons(teamId)
    }

    suspend fun getTeamCountries(): Response<BaseResponse<TeamCountries>> {
        return teamsApiService.getTeamCountries()
    }
}





