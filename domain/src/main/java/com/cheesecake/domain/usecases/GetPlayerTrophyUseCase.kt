package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.TrophyEntity
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetPlayerTrophyUseCase@Inject constructor(
    private val footballRepository: IFootballRepository
) {
    suspend operator fun invoke(playerId:Int): List<TrophyEntity> {
        return footballRepository.getPlayerTrophy(playerId)
    }
}