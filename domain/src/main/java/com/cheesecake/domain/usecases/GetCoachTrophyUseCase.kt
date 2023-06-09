package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Trophy
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetCoachTrophyUseCase@Inject constructor(
    private val footballRepository: IFootballRepository
) {
    suspend operator fun invoke(playerId:Int): List<Trophy> {
        return footballRepository.getCoachTrophy(playerId)
    }
}