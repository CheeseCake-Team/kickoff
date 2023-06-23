package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Player
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetPlayerUseCase @Inject constructor(
    private val iFootballRepository: IFootballRepository
) {

    suspend operator fun invoke(seasonId: Int, playerId: Int): Player {
        return iFootballRepository.getPlayerSingle(seasonId, playerId)
    }
}