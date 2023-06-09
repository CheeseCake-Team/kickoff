package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(
        timeZone: String,
        leagueId: Int,
        Season: Int
    ): List<Pair<String, List<Fixture>>> {
        return footballRepository.getMatchesByLeagueIdAndSeason(timeZone, leagueId, Season)
            .groupBy { it.matchDate }.toList().reversed()
    }

}