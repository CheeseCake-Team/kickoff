package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.PlayerEntity
import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.domain.repository.IFootballRepository

class GetAllFavoriteUseCase(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(): List<TeamEntity> {
        return footballRepository.getFavoriteTeams()
    }
}