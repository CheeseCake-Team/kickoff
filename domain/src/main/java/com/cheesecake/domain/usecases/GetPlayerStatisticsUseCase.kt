package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetPlayerStatisticsUseCase @Inject constructor(
    private val iFootballRepository: IFootballRepository
) {
    suspend operator fun invoke(seasonId: Int, playerId: Int): PlayerStatistics {
        return iFootballRepository.getPlayerFullStatistics(seasonId,playerId)
    }
}