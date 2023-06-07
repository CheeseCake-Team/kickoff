package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.PlayerStatisticsEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetPlayerBySeasonByPlayerId @Inject constructor(
    private val footballRepository: IFootballRepository,
    ) {
    suspend operator fun invoke(season:String, playerId: Int): PlayerStatisticsEntity {

        return footballRepository.getPlayerBySeasonByPlayerId(season, playerId)

    }


}

