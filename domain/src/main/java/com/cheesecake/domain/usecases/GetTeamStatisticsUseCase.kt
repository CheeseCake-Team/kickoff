package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.TeamStatisticsEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamStatisticsUseCase @Inject constructor(
    private val footballRepository: IFootballRepository
) {
    suspend operator fun invoke(leagueId: Int, season: Int, teamId: Int): TeamStatisticsEntity {
        return footballRepository.getTeamStatistics(
            teamId = teamId,
            season = season,
            leagueId = leagueId
        )
    }
}