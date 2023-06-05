package com.cheesecake.data.repository.standings

import com.cheesecake.data.models.dto.StandingsDTO
import com.cheesecake.data.remote.RemoteDataSource
import javax.inject.Inject

class StandingsRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getStandingsByTeamId(
        seasonId: Int,
        teamId: Int
    ): List<StandingsDTO> {
        return remoteDataSource.getStandingsByTeamId(seasonId, teamId)
    }

    suspend fun getStandingsByLeagueId(
        seasonId: Int,
        leagueId: Int
    ): List<StandingsDTO> {
        return remoteDataSource.getStandingsByLeagueId(seasonId, leagueId)
    }

    suspend fun getStandingsByTeamIdAndLeagueId(
        seasonId: Int,
        teamId: Int,
        leagueId: Int
    ): List<StandingsDTO> {
        return remoteDataSource.getStandingsByTeamIdAndLeagueId(seasonId, teamId, leagueId)
    }


}