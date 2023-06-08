package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.PlayerStatisticsEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTopScorersByLeagueIdAndSeason @Inject constructor(
    private val footballRepository: IFootballRepository
) {

    suspend operator fun invoke(leagueId: Int, season: Int): List<PlayerStatisticsEntity> {
        return footballRepository.getLeagueTopScorers(leagueId, season)
    }

}