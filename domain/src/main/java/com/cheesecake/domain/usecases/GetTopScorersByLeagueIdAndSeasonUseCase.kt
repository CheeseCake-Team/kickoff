package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTopScorersByLeagueIdAndSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository
) {
    suspend operator fun invoke(leagueId: Int, season: Int): List<PlayerStatistics> {
        return footballRepository.getLeagueTopScorers(leagueId, season)
    }
}