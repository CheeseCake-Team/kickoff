package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamSquadByIdUseCase @Inject constructor(
    private val footballRepository: IFootballRepository
) {
    suspend operator fun invoke(teamId: Int): List<Pair<String, List<SquadPlayer>>> {
        return footballRepository.getSquadOfTeam(teamId).groupBy { it.position }.toList()
    }
}