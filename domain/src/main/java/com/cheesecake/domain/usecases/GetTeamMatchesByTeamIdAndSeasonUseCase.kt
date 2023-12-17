package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamMatchesByTeamIdAndSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {
    suspend operator fun invoke(
        timeZone: String,
        teamId: Int,
        season: Int
    ): List<Fixture> {
        return footballRepository.getMatchesByTeamIdAndSeason(timeZone, season, teamId)
            .sortedByDescending { it.matchDate }
            .toList()
    }
}