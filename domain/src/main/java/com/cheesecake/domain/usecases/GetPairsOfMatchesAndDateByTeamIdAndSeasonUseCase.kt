package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetPairsOfMatchesAndDateByTeamIdAndSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(
        timeZone: String,
        teamId: Int,
        Season: Int
    ): List<Pair<String, List<Fixture>>> {
        return footballRepository.getMatchesByTeamIdAndSeason(timeZone, teamId, Season)
            .groupBy { it.matchDate }.toList().reversed()
    }
}