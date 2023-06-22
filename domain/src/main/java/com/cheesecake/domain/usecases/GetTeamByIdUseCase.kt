package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetTeamByIdUseCase@Inject constructor(
    private val footballRepository: IFootballRepository,
) {
    suspend operator fun invoke(teamId: Int): Team{
        return footballRepository.getLocallyTeamById(teamId)?:
        footballRepository.getRemotelyTeam(teamId)
    }
}