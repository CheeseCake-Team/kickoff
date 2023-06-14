package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamSquadByIdUseCase@Inject constructor(
    private val footballRepository: IFootballRepository) {

    suspend operator fun invoke(teamId: Int): List<Pair<String, List<PlayerStatistics>>>{
        return footballRepository.getSquadOfTeam(teamId).groupBy { it.position }.toList()
    }
}