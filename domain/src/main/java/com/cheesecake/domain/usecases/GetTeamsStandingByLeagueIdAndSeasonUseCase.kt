package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.TeamStandingEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamsStandingByLeagueIdAndSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {


    suspend operator fun invoke(leagueId: Int, Season: Int): List<TeamStandingEntity> {
        return footballRepository.getTeamsStandingByLeagueIdAndSeason(leagueId, Season)
    }
}