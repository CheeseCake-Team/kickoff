package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteTeamsUseCase(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(): Flow<List<Team>> {
        return footballRepository.getFavoriteTeams()
    }
}