package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteTeamsUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(): Flow<List<Team>> {
        return footballRepository.getFavoriteTeams()
    }
}